package com.ms.ad.util;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class OutputUtil {
    public static void str2File(String jsonString, String fileName) {
        // 写入文件
        FileUtil.writeString(jsonString, new File(fileName), "UTF-8"); // 直接写入文件
    }
}
