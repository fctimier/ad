package com.ms.ad.controller;

import com.ms.ad.common.ResponseEntity;
import com.ms.ad.model.request.SendMailRequest;
import com.ms.ad.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮件控制器，提供发送邮件的API接口。
 */
@RestController
@RequestMapping("/mail")
@Api(tags = "邮件", description = "提供发送简单文本和HTML邮件的功能")
public class MailController {

    @Autowired
    private MailService mailService;

    /**
     * 发送简单文本邮件接口。
     *
     * @param sendMailRequest 包含邮件发送所需信息的对象
     * @return ResponseEntity
     */
    @PostMapping("sendNormailizeTxtMail")
    @ApiOperation(value = "发送简单文本邮件", notes = "发送一封简单的文本邮件给指定收件人")
    public ResponseEntity sendNormailizeTxtMail(@RequestBody SendMailRequest sendMailRequest) {
        mailService.sendSimpleMail(sendMailRequest.getTo(), sendMailRequest.getSubject(), sendMailRequest.getContent());
        return ResponseEntity.success("邮件发送成功");
    }

    /**
     * 发送HTML格式邮件接口。
     *
     * @param sendMailRequest 包含邮件发送所需信息的对象
     * @return ResponseEntity
     */
    @SneakyThrows
    @PostMapping("sendHtmlMail")
    @ApiOperation(value = "发送HTML邮件", notes = "发送一封HTML格式邮件给指定收件人")
    public ResponseEntity sendHtmlMail(@RequestBody SendMailRequest sendMailRequest) {
        mailService.sendHtmlMail(sendMailRequest.getTo(), sendMailRequest.getSubject(), sendMailRequest.getContent());
        return ResponseEntity.success("HTML邮件发送成功");
    }


}