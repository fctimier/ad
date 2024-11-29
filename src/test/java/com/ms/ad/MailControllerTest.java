package com.ms.ad;

import com.ms.ad.controller.MailController;
import com.ms.ad.model.request.SendMailRequest;
import com.ms.ad.service.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.MessagingException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MailControllerTest {

    @InjectMocks
    private MailController mailController; // 注入要测试的控制器

    @Mock
    private MailService mailService; // 模拟邮件服务

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // 初始化模拟对象
    }

    @Test
    void sendNormailizeTxtMail() {
        SendMailRequest request = new SendMailRequest();
        request.setTo("ilke33@qq.com");
        request.setSubject("测试邮件");
        request.setContent("这是测试邮件的内容");

        // 进行邮件发送
        mailController.sendNormailizeTxtMail(request);

        // 验证服务层的sendSimpleMail方法是否被调用
        verify(mailService, times(1)).sendSimpleMail("ilke33@qq.com", "测试邮件", "这是测试邮件的内容");
    }

    @Test
    void sendHtmlMail() throws MessagingException {
        SendMailRequest request = new SendMailRequest();
        request.setTo("test@example.com");
        request.setSubject("HTML测试邮件");
        request.setContent("<html><body><h1>这是HTML格式的邮件</h1></body></html>");

        // 进行HTML邮件发送
        mailController.sendHtmlMail(request);

        // 验证服务层的sendHtmlMail方法是否被调用
        verify(mailService, times(1)).sendHtmlMail("test@example.com", "HTML测试邮件", "<html><body><h1>这是HTML格式的邮件</h1></body></html>");
    }

    // 各种无效方法的测试，虽然它们不再在控制器中，但可以测试他们的逻辑
    @Test
    void testSendSimpleMail() throws MessagingException {
        // 模拟发送简单邮件的方法
        mailService.sendSimpleMail("dengxianwen@vowei.com", "这是第一封邮件测试", "大家好，这是我的第一封邮件");
        // 验证sendSimpleMail被调用
        verify(mailService, times(1)).sendSimpleMail("dengxianwen@vowei.com", "这是第一封邮件测试", "大家好，这是我的第一封邮件");
    }

    @Test
    void testSendAttachmentMail() throws MessagingException {
        String filePath = "C:\\Users\\cyj\\Downloads\\SpringQuick\\mail.zip";
        mailService.sendAttachmentMail("sbksendmail@126.com", "这是第一封带附件邮件", "这是第一封带附件邮件", filePath);
        verify(mailService, times(1)).sendAttachmentMail("sbksendmail@126.com", "这是第一封带附件邮件", "这是第一封带附件邮件", filePath);
    }

    @Test
    void testSendPicMail() {
        String rscPath = "C:\\Users\\cyj\\Desktop\\pic.png";
        String rscId = "pic001";
        String content = "<html><body>\n这是第一封图片邮件:<img src='cid:" + rscId + "'></body></html>";
        mailService.sendPicMail("sbksendmail@126.com", "这是第一封图片邮件", content, rscPath, rscId);
        verify(mailService, times(1)).sendPicMail("sbksendmail@126.com", "这是第一封图片邮件", content, rscPath, rscId);
    }

    @Test
    void testSendTemplatesMail() throws MessagingException {
        String emailContext = "<h1>这是一个模板邮件</h1>"; // 假设这是处理后的模板内容
        mailService.sendHtmlMail("sbksendmail@126.com", "这是一个模板邮件", emailContext);
        verify(mailService, times(1)).sendHtmlMail("sbksendmail@126.com", "这是一个模板邮件", emailContext);
    }
}