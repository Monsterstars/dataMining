package com.monster.dataMining.c45;

/**
 * @auther: Monster
 * @date: 2019/10/3
 * @description: 通用工具类
 */
public class CommonUtils {

    /**
     * 计算以 2 为底的对数
     * @param x 输入值
     * @return 输出对数
     */
    public static double log2(double x) {
        return Math.log(x) / Math.log(2.0);
    }
}
