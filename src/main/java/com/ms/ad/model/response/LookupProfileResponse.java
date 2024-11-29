package com.ms.ad.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查找个人资料响应")
public class LookupProfileResponse {

    @ApiModelProperty(value = "姓名", example = "John Doe")
    private String name;

    @ApiModelProperty(value = "职位", example = "Software Engineer")
    private String job_title;

    @ApiModelProperty(value = "公司", example = "Tech Company")
    private String company;

    @ApiModelProperty(value = "邮箱", example = "john.doe@example.com")
    private String email;

    @ApiModelProperty(value = "电话号码", example = "+1234567890")
    private String phone;

    @ApiModelProperty(value = "LinkedIn链接", example = "https://linkedin.com/in/johndoe")
    private String linkedin_url;

    @ApiModelProperty(value = "个人简介", example = "Experienced software engineer")
    private String summary;

    @ApiModelProperty(value = "技能", example = "Java, Spring, Hibernate")
    private String skills;

    @ApiModelProperty(value = "教育背景", example = "Bachelor's degree in Computer Science")
    private String education;
}