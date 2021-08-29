package com.csw.algorithm.SuanFa;

public class PrintShuZu {
    public static void print(int[] aab) {
        System.out.println("结果是：");
        for (int i : aab) {
            if (aab[aab.length - 1] == i) {
                System.out.print(i);
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.println();
    }

}
