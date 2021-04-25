package com.csw.shuanFa.huaWei;

import java.util.Scanner;

/**
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 * <p>
 * 输出描述:
 * 输出到长度为8的新字符串数组
 */
public class StringSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder longString = new StringBuilder();
        while (sc.hasNext()) {
            String aa = sc.next();
            if (aa.equals("")) {
                break;
            }
            StringBuilder oo = new StringBuilder();
            // System.out.println("需要补" + (int) (8 - aa.length() % 8) + "个0");
            if (!((aa.length() % 8) == 0)) {
                for (int i = 0; i < 8 - aa.length() % 8; i++) {
                    oo.append("0");
                    //System.out.println("00]"+oo);
                }
            }


            longString.append(aa).append(oo);

        }
        for (int i = 0; i < longString.length() - 1; i++) {
            String out = longString.substring(i, i + 8);
            System.out.println(out);
            if (i <= longString.length() - 8) {
                i += 7;//
            }
        }
    }
}
