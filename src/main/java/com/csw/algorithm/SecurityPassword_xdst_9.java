package com.csw.algorithm;

import java.util.Collections;
import java.util.List;

public class SecurityPassword_xdst_9 {
    private static final int MIN_LENGTH = 6;

    public static void main(String[] args) {
        //密码长度
        int maxLength = 9;
        //生成个数
        int numBer = 11;
        dxst(maxLength, numBer);//大写+小写+数字+特殊符号

    }

    private static void dxst(int maxLength, int numBer) {
        String[] a1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
        String[] a2 = {"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] a3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
        String[] a4 = {"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] a5 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] a6 = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};
        String[] a7 = {"~", "_", "+", "{", "}", ":", "<", ">", "?", "|"};
        for (int n = 0; n < numBer; n++) {
            StringBuilder base = new StringBuilder(
                    a1[(int) (Math.random() * (a1.length))] +
                            a2[(int) (Math.random() * (a2.length))] +
                            a3[(int) (Math.random() * (a3.length))] +
                            a4[(int) (Math.random() * (a4.length))] +
                            a5[(int) (Math.random() * (a5.length))] +
                            a6[(int) (Math.random() * (a6.length))] +
                            a7[(int) (Math.random() * (a7.length))]
            );
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
                } else if (indexA == 6) {
                    base.append(a6[(int) (Math.random() * (a6.length))]);
                } else if (indexA == 7) {
                    base.append(a6[(int) (Math.random() * (a7.length))]);
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
        System.out.println("按照每秒2000次破解速度破解需要" + (long) (Math.pow((a1.length + a2.length + a3.length + a4.length + a5.length + a6.length + a7.length), maxLength) / 365 / 24 / 60 / 60 / 2000) + "年");
    }
}

