package com.ms.ad.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查找个人资料请求")
public class LookupProfileRequest {

    @ApiModelProperty(value = "AroundDeal ID", example = "AD123456")
    private String around_deal_id;

    @ApiModelProperty(value = "邮箱", example = "john.doe@example.com")
    private String email;

    @ApiModelProperty(value = "电话号码", example = "+1234567890")
    private String phone;
}