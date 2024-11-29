package com.ms.ad.model.response;  

import io.swagger.annotations.ApiModel;  
import io.swagger.annotations.ApiModelProperty;  
import lombok.Data;  

import java.util.Date;  

@Data  
@ApiModel(description = "邮件记录响应体")  
public class EmailRecordResponse {  
    @ApiModelProperty(value = "邮件记录的唯一标识符")  
    private Long id;  
    @ApiModelProperty(value = "收件人的电子邮件地址")  
    private String recipient;  
    @ApiModelProperty(value = "邮件主题")  
    private String subject;  
    @ApiModelProperty(value = "邮件内容")  
    private String content;  
    @ApiModelProperty(value = "发送时间")  
    private Date sentTime;  
    @ApiModelProperty(value = "邮件发送状态")  
    private String status;  
    @ApiModelProperty(value = "发送失败时的错误信息")  
    private String errorMessage;  
}