package com.ms.ad.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.ad.config.ApiConfig;
import com.ms.ad.model.request.CompanySearchRequest;
import com.ms.ad.model.request.LookupProfileRequest;
import com.ms.ad.model.request.PeopleSearchRequest;
import com.ms.ad.model.response.CompanySearchResponse;
import com.ms.ad.model.response.LookupProfileResponse;
import com.ms.ad.model.response.PeopleSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProspectorService {

    private static final String BASE_URL = "https://api.arounddeal.com/v2";
    @Autowired
    private ApiConfig apiConfig;
    private ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

    public PeopleSearchResponse searchPeople(PeopleSearchRequest request) throws IOException {
        String url = BASE_URL + "/people/search";
        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiConfig.getApiKey())
                .body(objectMapper.writeValueAsString(request)) // 将请求对象转换为JSON字符串
                .execute();

        // 使用Jackson将响应体转换为PeopleSearchResponse对象
        return objectMapper.readValue(response.body(), PeopleSearchResponse.class);
    }

    public CompanySearchResponse searchCompany(CompanySearchRequest request) throws IOException {
        String url = BASE_URL + "/company/search";
        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiConfig.getApiKey())
                .body(objectMapper.writeValueAsString(request)) // 将请求对象转换为JSON字符串
                .execute();

        // 使用Jackson将响应体转换为CompanySearchResponse对象
        return objectMapper.readValue(response.body(), CompanySearchResponse.class);
    }

    public LookupProfileResponse lookupProfile(LookupProfileRequest request) throws IOException {
        String url = BASE_URL + "/people/lookup";
        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiConfig.getApiKey())
                .body(objectMapper.writeValueAsString(request)) // 将请求对象转换为JSON字符串
                .execute();

        // 使用Jackson将响应体转换为LookupProfileResponse对象
        return objectMapper.readValue(response.body(), LookupProfileResponse.class);
    }
}