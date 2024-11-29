package com.ms.ad.config;


import com.volcengine.ark.runtime.service.ArkService;

import java.time.Duration;

public class DoubaoConfig {
    public static final String BASE_URL = "https://ark.cn-beijing.volces.com/api/v3";
    public static final String API_KEY = "c474b78f-3218-44a8-8a3c-e4b47a49c787";
    public static final String CHAT_MODEL_DOUBAO_PRO_128K = "ep-20241128191311-ln4kl";
    public static final String EMBEDDING_MODEL_DOUBAO_EMBEDDING = "ep-20241128183020-66kpc";

    public static ArkService getArkService() {
        return ArkService.builder()
                .apiKey(API_KEY)
//                .baseUrl("https://<ARK_DOMAIN>/api/v3")
                .baseUrl(BASE_URL)
                .timeout(Duration.ofSeconds(120))
                .connectTimeout(Duration.ofSeconds(20))
                .retryTimes(2)
                .build();
    }
}
