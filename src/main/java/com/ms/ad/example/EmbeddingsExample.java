package com.ms.ad.example;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.volcengine.ark.runtime.model.embeddings.EmbeddingRequest;
import com.volcengine.ark.runtime.model.embeddings.EmbeddingResult;
import com.volcengine.ark.runtime.service.ArkService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ms.ad.config.DoubaoConfig.*;

public class EmbeddingsExample {
    public static void main(String[] args) throws JsonProcessingException {


        System.out.println("\n----- embeddings request -----");

        List<String> inputs = new ArrayList<>();
        inputs.add("花椰菜又称菜花、花菜，是一种常见的蔬菜。");
        EmbeddingRequest embeddingRequest = EmbeddingRequest.builder()
                .model(EMBEDDING_MODEL_DOUBAO_EMBEDDING)
                .input(inputs)
                .build();

        ArkService service = getArkService();
        EmbeddingResult res = service.createEmbeddings(embeddingRequest);
        Map<String, Object> data = new HashMap<>();
        data.put("apiKey", API_KEY);
        data.put("inputs", inputs);
        data.put("model", EMBEDDING_MODEL_DOUBAO_EMBEDDING);
        data.put("result", res);  // Mak
        System.out.println(JSONUtil.toJsonStr(res));
        // Write the JSON string to a file

        // shutdown service
        service.shutdownExecutor();
    }
}