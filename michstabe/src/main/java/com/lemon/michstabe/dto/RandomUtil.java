package com.lemon.michstabe.dto;


import com.lemon.michstabe.service.ArticleService;

public class RandomUtil {

    /**
     * 生成一个 min - max 之间的数
     *
     * @return
     */
    public static int randomInt(int min, int max) {
        return 10 + (int) (Math.random() * (3000 - 10 + 1));
    }


}
