package com.csw.shuanFa.SuanFa;

/**
 * 冒泡排序
 */
public class MaoPao {
    public static void main(String[] args) {
        int[] aac = {40, 68, 38, 91, 86, 74, 53, 15, 9, 22};
        int[] aab = bubbleSort1(aac);
        System.out.println("升序结果是：");
        PrintShuZu.print(aab);
        //
        int[] aab2 = bubbleSort2(aac);
        System.out.println("降序结果是：");
        for (int i : aab2) {
            if (aab2[aab2.length - 1] == i) {
                System.out.print(i);
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.println();
        //
        int[] aab3 = bubbleSort1(aac);
        System.out.println("qian升序结果是：");
        for (int i : aab3) {
            if (aab3[aab3.length - 1] == i) {
                System.out.print(i);
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.println();
        //
        int[] aab4 = bubbleSort2(aac);
        System.out.println("qian降序结果是：");
        for (int i : aab4) {
            if (aab4[aab4.length - 1] == i) {
                System.out.print(i);
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.println();


    }

    public static int[] bubbleSort1(int[] a) {
        int i, j;
        int n = a.length;
        for (i = 0; i < n; i++) {
            for (j = 1; j < n - i; j++) {
                if (a[j - 1] > a[j]) {
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static int[] bubbleSort2(int[] a) {
        int i, j;
        int n = a.length;
        for (i = 0; i < n; i++) {
            for (j = 1; j < n - i; j++) {
                if (a[j - 1] < a[j]) {
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    //前操作
    public static int[] qianSort1(int[] a) {
        int i, j;
        int n = a.length;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n - 1; j++) {
                if (a[j - 1] > a[j]) {
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static int[] qianSort2(int[] a) {
        int i, j;
        int n = a.length;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n - 1; j++) {
                if (a[j - 1] < a[j]) {
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
