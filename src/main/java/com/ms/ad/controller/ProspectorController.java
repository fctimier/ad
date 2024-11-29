package com.ms.ad.controller;

import com.ms.ad.common.ResponseEntity;
import com.ms.ad.model.request.CompanySearchRequest;
import com.ms.ad.model.request.LookupProfileRequest;
import com.ms.ad.model.request.PeopleSearchRequest;
import com.ms.ad.model.response.CompanySearchResponse;
import com.ms.ad.model.response.LookupProfileResponse;
import com.ms.ad.model.response.PeopleSearchResponse;
import com.ms.ad.service.ProspectorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prospector")
@Api(tags = "Aroude deal API", description = "提供人员和公司搜索的API接口")
public class ProspectorController {

    @Autowired
    private ProspectorService prospectorService;

    @PostMapping("/search-people")
    @ApiOperation(value = "搜索人员", notes = "根据传入的条件搜索人员信息")
    public ResponseEntity searchPeople(@RequestBody PeopleSearchRequest request) {
        try {
            PeopleSearchResponse response = prospectorService.searchPeople(request);
            return ResponseEntity.success(response);
        } catch (Exception e) {
            return ResponseEntity.fail("人员搜索失败: " + e.getMessage());
        }
    }

    @PostMapping("/search-company")
    @ApiOperation(value = "搜索公司", notes = "根据传入的条件搜索公司信息")
    public ResponseEntity searchCompany(@RequestBody CompanySearchRequest request) {
        try {
            CompanySearchResponse response = prospectorService.searchCompany(request);
            return ResponseEntity.success(response);
        } catch (Exception e) {
            return ResponseEntity.fail("公司搜索失败: " + e.getMessage());
        }
    }

    @PostMapping("/lookup-profile")
    @ApiOperation(value = "查找个人资料", notes = "根据AroundDeal ID查找个人资料")
    public ResponseEntity lookupProfile(@RequestBody LookupProfileRequest request) {
        try {
            LookupProfileResponse response = prospectorService.lookupProfile(request);
            return ResponseEntity.success(response);
        } catch (Exception e) {
            return ResponseEntity.fail("查找个人资料失败: " + e.getMessage());
        }
    }
}