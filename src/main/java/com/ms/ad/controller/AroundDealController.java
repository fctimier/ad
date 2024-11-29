//package com.ms.adSmart.controller;
//
//import com.ms.adSmart.common.ResponseEntity;
//import com.ms.adSmart.service.AroundDealService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/arounddeal")
//public class AroundDealController {
//
//    @Autowired
//    private AroundDealService aroundDealService;
//
//    @PostMapping("/enrich-person")
//    public ResponseEntity enrichPerson(@RequestParam String firstName, @RequestParam String lastName) {
//        try {
//            // 调用服务层，获取增强后的人员信息
//            String result = aroundDealService.enrichPerson(firstName, lastName);
//            return ResponseEntity.success(result);
//        } catch (Exception e) {
//            // 处理异常并返回失败响应
//            return ResponseEntity.fail("人员增强失败: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/enrich-company")
//    public ResponseEntity enrichCompany(@RequestParam String companyName) {
//        try {
//            // 调用服务层，获取增强后的公司信息
//            String result = aroundDealService.enrichCompany(companyName);
//            return ResponseEntity.success(result);
//        } catch (Exception e) {
//            // 处理异常并返回失败响应
//            return ResponseEntity.fail("公司增强失败: " + e.getMessage());
//        }
//    }
//}