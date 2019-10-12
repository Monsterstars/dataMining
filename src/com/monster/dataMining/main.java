package com.monster.dataMining;

import com.monster.dataMining.id3.ID3Client;
import com.monster.dataMining.c45.C45Client;

import java.io.IOException;

/**
 * @auther: Monster
 * @date: 2019/10/10
 * @description: 程序入口
 */
public class main {

    /**
     * 程序启动
     * @param args 启动参数
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        System.out.println("id3算法");
        new ID3Client().start();
        System.out.println("算法");
        new C45Client().start();
    }

}
