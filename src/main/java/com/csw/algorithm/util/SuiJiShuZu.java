package com.csw.algorithm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机数组
 */
public class SuiJiShuZu {
    public static void main(String[] args) {
        List bb = new ArrayList();
        int[] aac = new int[10];
        for (int i = 0; i < 10; i++) {
            bb.add(i);
        }
        System.out.println("bb结果是：");
        for (Object i : bb) {
            if (bb.get(bb.size() - 1) == i) {
                System.out.print(i);
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.println();
        //////////
        for (int i = 0; i < 10; i++) {
            //从bb链表长度获取随机数
            int x1 = (int) (Math.random() * (bb.size()));
            //随机生成个位数
            int x2 = (int) (Math.random() * 10);
            //拼凑出0-99的随机数
            aac[i] = (int) bb.get(x1) * 10 + x2;
            //去除重复的十位数
            bb.remove(x1);
        }
        //
        System.out.println("aac结果是：");
        for (int i : aac) {
            if (aac[aac.length - 1] == i) {
                System.out.print(i);
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.println();

    }

}
