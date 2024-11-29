package com.ms.ad.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.ms.ad.config.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AroundDealService {

    private static final String BASE_URL = "https://api.arounddeal.com/v2";
    @Autowired
    private ApiConfig apiConfig;

    public String enrichPerson(String firstName, String lastName) {
        String url = BASE_URL + "/people/enrich";
        String json = String.format("{\"first_name\":\"%s\",\"last_name\":\"%s\"}", firstName, lastName);

        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiConfig.getApiKey())
                .body(json)
                .execute();

        return response.body();
    }

    public String enrichCompany(String companyName) {
        String url = BASE_URL + "/company/enrich";
        String json = String.format("{\"name\":\"%s\"}", companyName);

        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiConfig.getApiKey())
                .body(json)
                .execute();

        return response.body();
    }
}