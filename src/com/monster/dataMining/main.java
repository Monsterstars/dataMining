package com.monster.dataMining;

import com.monster.dataMining.id3.ID3Client;
import com.monster.dataMining.c45.C45Client;
import com.monster.dataMining.k_means.KmeansClient;

import java.io.IOException;
import java.util.ArrayList;

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
        System.out.println("K-means聚类");
        KmeansClient test = new KmeansClient(5);
        ArrayList<double[]> a = new ArrayList<double[]>();
        double aa[][] = {{0.2, 0.1, 0.9}, {0.45, 0.83, 0.69}, {2.43, 2.96, 5.39},
                {0.14, 0.24, 0.25}, {7, 3, 3}, {12.36, 18.39, 0.25},
                {6, 3, 3}, {6, 9, 6}, {17.92, 64.5, 32.1}};
        for (int i = 0; i < aa.length; i++) {
            a.add(aa[i]);
        }
        test.setDataSet(a);
        test.execute();
        ArrayList<ArrayList<double[]>> cluster = test.getCluster();
        for (int i = 0; i < cluster.size(); i++) {
            test.printDataArray(cluster.get(i), i);
        }
        System.out.println(test.m);
    }

}
