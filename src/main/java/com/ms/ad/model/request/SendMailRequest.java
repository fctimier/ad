package com.ms.ad.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 封装发送邮件请求的参数。
 */
@Data // 自动生成getter和setter方法
public class SendMailRequest {

    @Email(message = "无效的邮箱地址")
    @NotBlank(message = "收件人邮箱不能为空")
    private String to; // 收件人邮箱

    @NotBlank(message = "邮件主题不能为空")
    private String subject; // 邮件主题

    @NotBlank(message = "邮件内容不能为空")
    private String content; // 邮件内容  
}