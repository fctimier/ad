package com.ms.ad.example;

import com.volcengine.ark.runtime.model.embeddings.Embedding;
import com.volcengine.ark.runtime.model.embeddings.EmbeddingRequest;
import com.volcengine.ark.runtime.model.embeddings.EmbeddingResult;
import com.volcengine.ark.runtime.service.ArkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ms.ad.config.DoubaoConfig.EMBEDDING_MODEL_DOUBAO_EMBEDDING;
import static com.ms.ad.config.DoubaoConfig.getArkService;

public class ChatCompletionsExample {
    public static void main(String[] args) {
        ArkService service = getArkService();

        System.out.println("\n----- doubao embeddings request -----");
        // 检索 query 建议添加 instruction 前缀
        String queryInstruction = "为这个句子生成表示以用于检索相关文章：";
        String query = "天是什么颜色？";
        // 向量索引的 document 则不添加 instruction
        String document = "天空呈现颜色主要与“瑞利散射”现象有关，具体形成过程如下：太阳光是由红、橙、黄、绿、蓝、靛、紫等多种颜色的光混合而成的。大气中存在着无数的气体分子和其他微粒。当太阳光进入地球大气层时，波长较长的红光、橙光、黄光能穿透大气层，直接射到地面，而波长较短的蓝、紫、靛等色光，很容易被悬浮在空气中的微粒阻挡，从而使光线散射向四方。其中蓝光波长较短，散射作用更强，因此我们眼睛看到的天空主要呈现蓝色。在一些特殊情况下，如傍晚或早晨，阳光斜射角度大，通过大气层的路径较长，蓝光等短波长光被散射得更多，而红光等长波长光散射损失较少，这时天空可能会呈现橙红色等其他颜色。";

        List<String> inputs = new ArrayList<>();
        inputs.add(queryInstruction + query);
        inputs.add(document);

        EmbeddingRequest chatCompletionRequest = EmbeddingRequest.builder()
                .model(EMBEDDING_MODEL_DOUBAO_EMBEDDING)
                .input(inputs)
                .build();

        EmbeddingResult resp = service.createEmbeddings(chatCompletionRequest);

        EmbeddingResult embeddings2048 = normalize(resp, 2048);
        Double score2048 = matmulVector(embeddings2048.getData().get(0).getEmbedding(), embeddings2048.getData().get(1).getEmbedding());
        System.out.println("product: " + score2048);

        EmbeddingResult embedding1024 = normalize(resp, 1024);
        Double score1024 = matmulVector(embedding1024.getData().get(0).getEmbedding(), embedding1024.getData().get(1).getEmbedding());
        System.out.println("product: " + score1024);

        EmbeddingResult embedding512 = normalize(resp, 512);
        Double score512 = matmulVector(embedding512.getData().get(0).getEmbedding(), embedding512.getData().get(1).getEmbedding());

        System.out.println("product: " + score512);
        // shutdown service
        service.shutdownExecutor();
    }

    public static EmbeddingResult normalize(EmbeddingResult embeddingsResp, int dim) {
        if (embeddingsResp == null) {
            return null;
        }
        List<Embedding> list = embeddingsResp.getData();
        list.replaceAll(e -> {
            List<Double> embedding = e.getEmbedding();
            if (embedding.size() > dim) {
                embedding = embedding.subList(0, dim);
            }
            e.setEmbedding(normalizeVector(embedding));
            return e;
        });
        EmbeddingResult resp = new EmbeddingResult();
        resp.setData(list);
        return resp;
    }

    public static List<Double> normalizeVector(List<Double> vector) {
        double norm = vector.stream().filter(Objects::nonNull).mapToDouble(value -> value * value).sum();
        double finalNorm = Math.sqrt(norm);
        if (finalNorm != 0) {
            vector.replaceAll(item -> item / finalNorm);
        }
        return vector;
    }

    public static Double matmulVector(List<Double> vector1, List<Double> vector2) {
        double dotProduct = 0.0;
        for (int i = 0; i < vector1.size(); i++) {
            dotProduct += vector1.get(i) * vector2.get(i);
        }
        return dotProduct;
    }
}