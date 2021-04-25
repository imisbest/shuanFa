package com.csw.shuanFa.SuanFa;

/**
 * 希尔排序
 */
public class XiEr {
    public static void main(String[] args) {
        int[] aac = {30, 88, 52, 49, 24, 0, 93, 15, 71, 68};
        int[] aab = shellSort(aac);
        System.out.println("结果是：");
        PrintShuZu.print(aab);

    }

    private static int[] shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            shellInsertSort(a, dk);
            dk = dk / 2;
        }
        return a;
    }

    private static void shellInsertSort(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {
                int j;
                int x = a[i];
                a[i] = a[i - dk];
                for (j = i - dk; j >= 0 && x < a[j]; j = j - dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = x;
            }
        }
    }
}
