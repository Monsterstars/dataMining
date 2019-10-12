package com.monster.dataMining.c45;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Monster
 * @date: 2019/10/3
 * @description: 构建 C4.5 决策树的结点
 */
public class AttributeNode {

    private String attributeName = null;

    private List<AttributeNode> childNodes = null;

    private String parentStatus = null;

    private boolean isLeaf = false;

    public AttributeNode(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public List<AttributeNode> getChildNodes() {
        return childNodes;
    }

    public void addChildNodes(AttributeNode node) {
        if (childNodes == null) {
            childNodes = new ArrayList<>();
        }

        childNodes.add(node);
    }

    public void setParentStatus(String parentStatus) {
        this.parentStatus = parentStatus;
    }

    public String getParentStatus() {
        return parentStatus;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

}
