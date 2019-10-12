package com.monster.dataMining.c45;

import java.util.Comparator;

/**
 * @auther: Monster
 * @date: 2019/10/3
 * @description: 通过连续变量单元的值进行比较两个连续变量单元
 */
public class ContinuouslyVariableUnitComparatorByValue implements Comparator<ContinuouslyVariableUnit> {

    @Override
    public int compare(ContinuouslyVariableUnit unit1, ContinuouslyVariableUnit unit2) {
        return unit1.getValue() - unit2.getValue();
    }

}
