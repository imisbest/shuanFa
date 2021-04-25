package com.csw.shuanFa.huawei_jikao;

import java.util.Scanner;

/**
 * 5 5
 * HELLOWORLD
 * CPUCY
 * CPUCY
 * CHELL
 * LROWO
 * LROWO
 * 结果3，2
 */
public class LianXu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        //System.out.println("a]"+a);
        int b = sc.nextInt();
        //System.out.println("b]"+b);
        String bj = sc.next();
        //System.out.println("bj]"+bj);
        String[] cc = new String[a];//string[5][5]
        for (int i = 0; i < a; i++) {
            //int line = 0;
            cc[i] = sc.next();
            //System.out.println("cc数组】"+i+"]"+cc[i]);
        }
        /////
        int h = -1;
        int l = -1;
        tag2:
        if (h == -1) {
            for (int i = 0; i < bj.length() - 1; i++) {
                //System.out.println("1]"+bj.charAt(i));
                //System.out.println("2]"+bj.charAt(i+1));
                String qian = String.valueOf(bj.charAt(i)) + String.valueOf(bj.charAt(i + 1));//找到前缀比较
                //System.out.println("qian】"+qian);
                for (int j = 0; j < cc.length; j++) {
                    String line = cc[j];//每一行的字符串
                    //System.out.println("line]"+j+"]"+line);
                    for (int m = 0; m < line.length() - 1; m++) {
                        String hou = String.valueOf(line.charAt(m)) + String.valueOf(line.charAt(m + 1));
                        //System.out.println("hou]"+hou);
                        if (qian.equals(hou)) {
                            h = j + 1;
                            l = m + 1;
                            // System.out.println("h]" + h);
                            //System.out.println("l]"+l);
                            break tag2;
                        }
                    }
                }
            }
        }
        if (h != -1) {
            System.out.println(h + " " + l);
        } else {
            System.out.println("NO");
        }

    }
}
