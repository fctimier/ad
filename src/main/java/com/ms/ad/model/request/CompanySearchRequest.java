package com.ms.ad.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "公司搜索请求")
public class CompanySearchRequest {

    @ApiModelProperty(value = "公司名称", example = "Amazing Tech Corp")
    private String company_name;

    @ApiModelProperty(value = "行业", example = "Software Development")
    private String industry;

    @ApiModelProperty(value = "所在地", example = "San Francisco, USA")
    private String location;

    @ApiModelProperty(value = "公司规模", example = "50-200")
    private String company_size;

    @ApiModelProperty(value = "收入范围", example = "$1M - $5M")
    private String revenue_range;

    @ApiModelProperty(value = "成立年份", example = "2010")
    private String founded_year;

    @ApiModelProperty(value = "当前页", example = "1")
    private int page;

    @ApiModelProperty(value = "每页数量", example = "10")
    private int size;
}