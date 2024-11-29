package com.ms.ad.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "人员搜索响应")
public class PeopleSearchResponse {

    @ApiModelProperty(value = "人员列表")
    private List<Person> people;

    @ApiModelProperty(value = "总记录数", example = "100")
    private int total;

    @Data
    @ApiModel(description = "人员信息")
    public static class Person {

        @ApiModelProperty(value = "唯一标识符", example = "1")
        private String id;

        @ApiModelProperty(value = "姓名", example = "John Doe")
        private String name;

        @ApiModelProperty(value = "职位", example = "Software Engineer")
        private String job_title;

        @ApiModelProperty(value = "公司", example = "Tech Company")
        private String company;

        @ApiModelProperty(value = "所在地", example = "New York, USA")
        private String location;

        @ApiModelProperty(value = "邮箱", example = "john.doe@example.com")
        private String email;

        @ApiModelProperty(value = "电话号码", example = "+1234567890")
        private String phone;

        @ApiModelProperty(value = "个人资料链接", example = "https://example.com/profile/johndoe")
        private String profile_url;
    }
}