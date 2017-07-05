package com.cnea.textgitone;

/**
 * Created by Administrator on 2017/6/20.
 * 高级用法
 */

public class MyStringUtils {
    public static String capitalize(String word) {
        if (word.length() > 1) {
            //toUpperCase  转换为大写
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }
}
