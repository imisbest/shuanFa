package com.csw.algorithm.huaWei;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 0到9，10个数字使得两个相加等于第三者，并且这三个数数字不能重复，0-9必须都用到
 */
public class ShuShu {

    public static void main(String[] args) {
        int a;//第一个数
        int b;//第二个数
        int c;//第三个数

        ArrayList<String> list = new ArrayList<>();
        for (int i = 100; i < 999; i++) {
            a = i;
            if (panChong3(a)) {
                for (int j = Math.max(1000 - a, 100); j < 999; j++) {
                    HashSet<Integer> set = new HashSet<>();//放最内层循环
                    b = j;
                    if (panChong3(b)) {
                        c = a + b;
                        if (panChong4(c)) {
                            set3(a, set);
                            set3(b, set);
                            set4(c, set);
                            if (set.size() == 10) {
                                String adds = a + "+" + b + "=" + c;
                                if (!list.contains(adds)) {
                                    list.add(adds);
                                }
                            }
                        }
                    }
                }
            }
        }//
        int lin=10;
        int ll=list.size();
        for (int i = 0; i < ll; ) {
            int bb=ll - ll%lin;
            if (bb-lin< i) {
                for (int j = bb; j < ll; j++) {
                    System.out.print(list.get(j) +"】");
                }
            }else {
                for (int j = 0; j < lin; j++) {
                    System.out.print(list.get(i+j) +"】");
                }
            }
            i+=lin;
            System.out.println();
        }
    }


    public static boolean panChong3(int ss) {//除/前，于%后
        int ge = ss % 10;
        int shi = ss / 10 % 10;
        int bai = ss / 100;
        return ge != shi && ge != bai && shi != bai;
    }

    public static void set3(int ss, HashSet<Integer> set) {//除/前，于%后
        int ge = ss % 10;
        int shi = ss / 10 % 10;
        int bai = ss / 100;

        set.add(ge);
        set.add(shi);
        set.add(bai);
    }

    public static boolean panChong4(int ss) {//除/前，于%后
        int ge = ss % 10;
        int shi = ss / 10 % 10;
        int bai = ss / 100 % 10;
        int qian = ss / 1000;
        return ge != shi && ge != bai && ge != qian && shi != bai && shi != qian && bai != qian;
    }

    public static void set4(int ss, HashSet<Integer> set) {//除/前，于%后
        int ge = ss % 10;
        int shi = ss / 10 % 10;
        int bai = ss / 100 % 10;
        int qian = ss / 1000;

        set.add(ge);
        set.add(shi);
        set.add(bai);
        set.add(qian);

    }
}
