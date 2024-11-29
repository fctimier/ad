package com.ms.ad.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "公司搜索响应")
public class CompanySearchResponse {

    @ApiModelProperty(value = "公司列表")
    private List<Company> companies;

    @ApiModelProperty(value = "总记录数", example = "50")
    private int total;

    @Data
    @ApiModel(description = "公司信息")
    public static class Company {

        @ApiModelProperty(value = "唯一标识符", example = "1")
        private String id;

        @ApiModelProperty(value = "公司名称", example = "Amazing Tech Corp")
        private String name;

        @ApiModelProperty(value = "行业", example = "Software Development")
        private String industry;

        @ApiModelProperty(value = "所在地", example = "San Francisco, USA")
        private String location;

        @ApiModelProperty(value = "公司规模", example = "50-200")
        private String company_size;

        @ApiModelProperty(value = "收入", example = "$1M - $5M")
        private String revenue;

        @ApiModelProperty(value = "成立年份", example = "2010")
        private int founded_year;

        @ApiModelProperty(value = "公司网站", example = "https://example.com")
        private String website;
    }
}