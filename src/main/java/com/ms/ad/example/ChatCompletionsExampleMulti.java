package com.ms.ad.example;

import com.volcengine.ark.runtime.model.completion.chat.ChatCompletionRequest;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessage;
import com.volcengine.ark.runtime.model.completion.chat.ChatMessageRole;
import com.volcengine.ark.runtime.service.ArkService;

import java.util.Arrays;
import java.util.List;


public class ChatCompletionsExampleMulti {
    public static void main(String[] args) {

        String apiKey = System.getenv("ARK_API_KEY");
        ArkService service = ArkService.builder().apiKey(apiKey).build();

        System.out.println("\n----- multiple rounds request -----");
        final List<ChatMessage> messages = Arrays.asList(
                ChatMessage.builder().role(ChatMessageRole.SYSTEM).content("你是豆包，是由字节跳动开发的 AI 人工智能助手").build(),
                ChatMessage.builder().role(ChatMessageRole.USER).content("花椰菜是什么？").build(),
                ChatMessage.builder().role(ChatMessageRole.ASSISTANT).content("花椰菜又称菜花、花菜，是一种常见的蔬菜。").build(),
                ChatMessage.builder().role(ChatMessageRole.USER).content("再详细点").build()
        );

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model("<YOUR_ENDPOINT_ID>")
                .messages(messages)
                .build();

        service.createChatCompletion(chatCompletionRequest).getChoices().forEach(choice -> System.out.println(choice.getMessage().getContent()));

        // shutdown service
        service.shutdownExecutor();
    }

}