package com.nodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 手写一个二叉树
 */
public class Node {
    //左子节点
    public Node leftNode;
    //右子节点
    public Node rightNode;
    //值
    public Object value;

    //插入数据
    public void add(Object v) {
        //如果当前节点没有值，就把数据放在单签节点
        if (null == value)
            value = v;
            //如果节点有值，就进行判断，新增的值和当前的值的大小关系
        else {
            //新增的值，比当前的小或者相同
            if ((Integer) v - (Integer) value <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);

                // 新增的值，比当前值大
            } else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }

    public List<Object> values() {
        List<Object> values = new ArrayList<>();
        //左节点遍历的结果
        if (null != leftNode)
            values.addAll(leftNode.values());
        //当前节点
        values.add(value);
        //右节点遍历的结果
        if (null != rightNode)
            values.addAll(rightNode.values());

        return values;
    }

    //利用二叉树进行排序
    public static void main(String[] args) {
        int[] arr = new int[]{95, 48, 29, 18, 78, 26, 84, 25, 36};
        //将数组放入二叉树中
        Node n = new Node();
        for (int num : arr) {
            n.add(num);
        }
        //输出二叉树的数据
        System.out.println(n.values());
    }
}
