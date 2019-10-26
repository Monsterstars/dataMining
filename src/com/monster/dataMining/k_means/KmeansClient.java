package com.monster.dataMining.k_means;

import java.util.ArrayList;
import java.util.Random;

/**
 * @auther: Monster
 * @date: 2019/10/18
 * @description: Kmeans算法
 * 1.随机选择k个点作为初始质心
 * 2.对每个点计算与质心的距离，并将其归入距离最短的类
 * 3.重新计算质心
 * 4.重复二三步，直到 新质心计算结果与之前质心 误差较低或达到最大迭代次数
 */
public class KmeansClient {
    private int k;
    public int m;
    private int dataSetLength;
    private ArrayList<double[]> center;
    private ArrayList<double[]> dataSet;
    private ArrayList<ArrayList<double[]>> cluster;
    private ArrayList<Double> jc;
    private Random random;

    /**
     * 设置数据集
     * @param dataSet
     */
    public void setDataSet(ArrayList<double[]> dataSet) {
        this.dataSet = dataSet;
    }

    /**
     * 设置返回
     * @return
     */
    public ArrayList<ArrayList<double[]>> getCluster() {
        return this.cluster;
    }

    /**
     * 构造函数，传入k
     * @param k
     */
    public KmeansClient(int k) {
        this.k = k;
    }


    /**
     * 初始化 (类内初始化)
     */
    private void init() {
        m = 0;
        random = new Random();
        //  如果调用者未初始化数据集，则采用内部测试数据集
        if (dataSet == null || dataSet.size() == 0) {
            initDataSet();
        }
        dataSetLength = dataSet.size();
        if (k > dataSetLength) {
            k = dataSetLength;
        }
        center = initCenter();
        cluster = initCluster();
        jc = new ArrayList<Double>();
    }

    /**
     * 初始化数据集
     */
    private void initDataSet() {
        dataSet = new ArrayList<double[]>();
        double dataSetArray[][] = {{8, 2}, {3, 4}, {2, 5},
                {4, 2}, {7, 3}, {6, 2}, {4, 7}, {6, 3}, {5, 3},
                {6, 3}, {6, 9}, {1, 6}, {3, 9}, {4, 1}, {8, 6}};
        for (int i = 0; i < dataSetArray.length; i++) {
            dataSet.add(dataSetArray[i]);
        }
    }

    /**
     * 初始化中心点
     * @return
     */
    private ArrayList<double[]> initCenter() {
        center = new ArrayList<double[]>();
        for (int i = 0; i < k; i++) {
            int temp = random.nextInt(dataSetLength);
            center.add(dataSet.get(temp));
        }
        return center;
    }

    /**
     * 初始化簇
     * @return
     */
    private ArrayList<ArrayList<double[]>> initCluster() {
        cluster = new ArrayList<ArrayList<double[]>>();
        for (int i = 0; i < k; i++) {
            cluster.add(new ArrayList<double[]>());
        }
        return cluster;
    }

    /**
     * 对每个文档计算与质心的距离，并将其归入距离最短的类
     * @param element
     * @param center
     * @return
     */
    public double getDis(double[] element, double[] center) {
        double dis = 0.0;
        double temp = 0.0;
        int len = element.length;
        for (int i = 0; i < len; i++) {
            temp += Math.pow((element[i] - center[i]), 2);
        }
        dis = Math.sqrt(temp);
        return dis;
    }

    /**
     * 获取最小值
     * @param distance
     * @return
     */
    public int getMin(double[] distance) {
        double minDis = distance[0];
        int minLoc = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < minDis) {
                minDis = distance[i];
                minLoc = i;
            }
        }
        return minLoc;
    }

    /**
     * 设置簇
     */
    public void setCluster() {
        double[] distance = new double[k];
        for (int i = 0; i < dataSetLength; i++) {
            for (int j = 0; j < k; j++) {
                distance[j] = getDis(dataSet.get(i), center.get(j));
            }
            int minLocation = getMin(distance);
            cluster.get(minLocation).add(dataSet.get(i));
        }
    }

    /**
     * 重新计算质心
     */
    public void resetCenter() {
        double[][] calculate = new double[k][cluster.get(0).get(0).length];
        for (int i = 0; i < k; i++) {
            int size = cluster.get(i).size();
            if (size != 0) {
                for (int j = 0; j < size; j++) {
                    double[] element = cluster.get(i).get(j);
                    int len = element.length;
                    for (int n = 0; n < len; n++) {
                        calculate[i][n] += element[n] / size;
                    }
                }
                center.set(i, calculate[i]);
            }
        }
    }

    /**
     * 计算每一次的均方误差之和，add到jc中
     * @param element
     * @param center
     * @return
     */
    private double errorSquare(double[] element, double[] center) {
        int len = element.length;
        double errSquare = 0.0;
        for (int i = 0; i < len; i++) {
            errSquare += Math.pow(element[i] - center[i], 2);
        }
        return errSquare;
    }

    /**
     * 计数
     */
    private void countRule() {
        double jcF = 0.0;
        for (int i = 0; i < cluster.size(); i++) {
            for (int j = 0; j < cluster.get(i).size(); j++) {
                jcF += errorSquare(cluster.get(i).get(j), center.get(i));

            }
        }
        jc.add(jcF);
    }

    /**
     * 打印数据到控制台
     * @param data
     * @param name
     */
    public void printDataArray(ArrayList<double[]> data, int name) {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(name + " [" + i + "] = {" + data.get(i)[0] + "," + data.get(i)[1] + "}");
        }
        System.out.println("==========================");
    }

    /**
     * 无参构造系
     */
    public void Kmeans() {
        init();
        while (true) {
            setCluster();
            countRule();
            if (m > 60) {
                break;
            }
            resetCenter();
            m++;
            cluster.clear();
            initCluster();
        }
    }

    /**
     * 执行方法
     */
    public void execute() {
        Kmeans();
    }
}