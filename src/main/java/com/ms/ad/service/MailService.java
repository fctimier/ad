package com.ms.ad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件服务类，用于发送不同类型的电子邮件。
 * 该类使用Spring的JavaMailSender进行邮件发送。
 */
@Service
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;

    /**
     * 发送简单文本邮件。
     *
     * @param to      收件人邮箱地址
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);

        javaMailSender.send(message);
    }

    /**
     * 发送HTML格式的邮件。
     *
     * @param to      收件人邮箱地址
     * @param subject 邮件主题
     * @param content 邮件内容，支持HTML格式
     * @throws MessagingException 发送邮件时可能抛出的异常
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);

        javaMailSender.send(message);
    }

    /**
     * 发送带附件的邮件。
     * 该方法将从指定的文件路径中读取文件，并将其附加到邮件中。
     *
     * @param to       收件人邮箱地址
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param filePath 附件文件的路径
     * @throws MessagingException 发送邮件时可能抛出的异常
     */
    public void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
        String fileName = fileSystemResource.getFilename();
        helper.addAttachment(fileName, fileSystemResource);

        javaMailSender.send(message);
    }

    /**
     * 发送带附件的邮件，附件为从前端上传的文件。
     *
     * @param to      收件人邮箱地址
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param file    上传的文件，封装为MultipartFile对象
     * @throws MessagingException 发送邮件时可能抛出的异常
     */
    public void sendAttachmentMail(String to, String subject, String content, MultipartFile file) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(from);

        String fileName = file.getOriginalFilename(); // 获取原始文件名
        helper.addAttachment(fileName, file); // 直接使用MultipartFile

        javaMailSender.send(message);
    }

    /**
     * 发送包含内联图片的邮件。
     * 可以用于发送具有嵌入图像的HTML邮件。
     *
     * @param to      收件人邮箱地址
     * @param subject 邮件主题
     * @param content 邮件内容，支持HTML格式
     * @param rscPath 图片资源的路径
     * @param rscId   图片的ID，该ID将在邮件的HTML中引用
     */
    public void sendPicMail(String to, String subject, String content, String rscPath, String rscId) {
        logger.info("发送静态邮件开始：{},{},{},{},{}", to, subject, content, rscPath, rscId);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            helper.setFrom(from);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, fileSystemResource);
            javaMailSender.send(message);
            logger.info("发送邮件成功");
        } catch (MessagingException e) {
            logger.error("发送图片邮件失败", e);
        }
    }
}