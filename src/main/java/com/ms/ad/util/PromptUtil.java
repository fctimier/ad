package com.ms.ad.util;

import cn.hutool.core.io.FileUtil;

public class PromptUtil {
    public static String readFileToString(String fileName) {
        // 使用Hutool的FileUtil读取文件内容
        return FileUtil.readString("prompt/" + fileName, "UTF-8");
    }

    public static void main(String[] args) {
        String content = readFileToString("example.txt");
        System.out.println(content);
    }
}

