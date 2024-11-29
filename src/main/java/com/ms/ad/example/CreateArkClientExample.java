package com.ms.ad.example;

import com.volcengine.ark.runtime.service.ArkService;

import java.time.Duration;

import static com.ms.ad.config.DoubaoConfig.API_KEY;

public class CreateArkClientExample {
    public static void main(String[] args) {
//        String apiKey = System.getenv("ARK_API_KEY");
        ArkService service = ArkService.builder()
                .apiKey(API_KEY)
//                .baseUrl("https://<ARK_DOMAIN>/api/v3")
                .baseUrl("https://ark.cn-beijing.volces.com/api/v3")
                .timeout(Duration.ofSeconds(120))
                .connectTimeout(Duration.ofSeconds(20))
                .retryTimes(2)
                .build();
    }
    // do your operation...
}