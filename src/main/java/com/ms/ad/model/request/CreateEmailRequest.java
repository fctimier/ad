package com.ms.ad.model.request;  

import io.swagger.annotations.ApiModel;  
import io.swagger.annotations.ApiModelProperty;  
import lombok.Data;  

@Data  
@ApiModel(description = "创建邮件请求体")  
public class CreateEmailRequest {  
    @ApiModelProperty(value = "收件人的电子邮件地址", required = true)  
    private String recipient;  
    @ApiModelProperty(value = "邮件主题", required = true)  
    private String subject;  
    @ApiModelProperty(value = "邮件内容", required = true)  
    private String content;  
}