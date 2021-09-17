package com.csw.algorithm.security;

import java.util.Collections;
import java.util.List;

public class SecurityPassword_s_6 {
    private static final int MIN_LENGTH = 5;//下面数组的个数

    public static void main(String[] args) {
        //密码长度
        int maxLength = 6;
        //生成个数
        int numBer = 11;
        s(maxLength, numBer);//数字

    }

    private static void s(int maxLength, int numBer) {
        String[] a1 = {"0", "1"};
        String[] a2 = {"2", "3"};
        String[] a3 = {"4", "5"};
        String[] a4 = {"6", "7"};
        String[] a5 = {"8", "9"};
        for (int n = 0; n < numBer; n++) {
            StringBuilder base = new StringBuilder(a1[(int) (Math.random() * (a1.length))] + a2[(int) (Math.random() * (a2.length))] +
                    a3[(int) (Math.random() * (a3.length))] + a4[(int) (Math.random() * (a4.length))] +
                    a5[(int) (Math.random() * (a5.length))] );
            for (int i = 0; i < maxLength - MIN_LENGTH; i++) {//还有多少个字母
                int indexA = (int) (Math.random() * MIN_LENGTH + 1);
                if (indexA == 1) {
                    base.append(a1[(int) (Math.random() * (a1.length))]);
                } else if (indexA == 2) {
                    base.append(a2[(int) (Math.random() * (a2.length))]);
                } else if (indexA == 3) {
                    base.append(a3[(int) (Math.random() * (a3.length))]);
                } else if (indexA == 4) {
                    base.append(a4[(int) (Math.random() * (a4.length))]);
                } else if (indexA == 5) {
                    base.append(a5[(int) (Math.random() * (a5.length))]);
                }
            }
            List<Character> stringList = new java.util.ArrayList<>();
            for (int i = 0; i < base.toString().length(); i++) {
                stringList.add(base.toString().charAt(i));
            }
            //System.out.println("打乱前"+stringList.toString().substring(1, stringList.toString().length() - 1).replace(", ",""));
            Collections.shuffle(stringList);
            System.out.println(stringList.toString().substring(1, stringList.toString().length() - 1).replace(", ", ""));
        }
        System.out.println("按照每秒2000次破解速度破解需要" + (long) (Math.pow((a1.length + a2.length + a3.length + a4.length + a5.length ), maxLength) / 60 / 2000) + "分钟");
    }
}

