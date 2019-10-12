package com.monster.dataMining.c45;

/**
 * @auther: Monster
 * @date: 2019/10/3
 * @description: 连续变量单元。此类用于保存一个属性的连续变量，以及此变量下的结果
 */
public class ContinuouslyVariableUnit {

    private int value = 0;
    private String classify = "";
    
    public ContinuouslyVariableUnit() {
    }
    
    public ContinuouslyVariableUnit(int value, String classify) {
        this.value = value;
        this.classify = classify;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
    
    @Override
    public String toString() {
        return "[" + value + ", " + classify + "]";
    }
}
