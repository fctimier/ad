package com.ms.ad.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "人员搜索请求")
public class PeopleSearchRequest {

    @ApiModelProperty(value = "人名", example = "John Doe")
    private String name;

    @ApiModelProperty(value = "职位", example = "Software Engineer")
    private String job_title;

    @ApiModelProperty(value = "公司名", example = "Tech Company")
    private String company;

    @ApiModelProperty(value = "所在地", example = "New York, USA")
    private String location;

    @ApiModelProperty(value = "行业", example = "Information Technology")
    private String industry;

    @ApiModelProperty(value = "职位等级", example = "Senior")
    private String seniority_level;

    @ApiModelProperty(value = "邮箱", example = "john.doe@example.com")
    private String email;

    @ApiModelProperty(value = "电话号码", example = "+1234567890")
    private String phone;

    @ApiModelProperty(value = "当前页", example = "1")
    private int page;

    @ApiModelProperty(value = "每页数量", example = "10")
    private int size;
}