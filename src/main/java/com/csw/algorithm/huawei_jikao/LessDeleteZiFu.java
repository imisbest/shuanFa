package com.csw.algorithm.huawei_jikao;

import java.util.*;

/**
 * abcdd     dd
 * aabbcc   empty
 */
public class LessDeleteZiFu {
    private Integer s;
    private int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] inOut = input.toCharArray();
        Map<Character, Integer> map = new HashMap();
        //统计每个字母出现的次数
        for (int i = 0; i < inOut.length; i++) {
            if (map.get(inOut[i]) == null) {
                map.put(inOut[i], 1);
            } else {
                map.put(inOut[i], map.get(inOut[i]) + 1);
            }
        }
        //找出最小次数
        int minShu = 999;
        for (Character cc : map.keySet()) {
            if (minShu > map.get(cc)) {
                minShu = map.get(cc);
            }
        }
        //System.out.println("minShu"+minShu);
//找出出现最小次数的字母
        List list = new ArrayList();
        for (Character cc : map.keySet()) {
            if (minShu == map.get(cc)) {
                //System.out.println("list添加"+cc);
                list.add(cc);
            }
        }
        String abc = "";
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (!(list.get(i).equals(input.charAt(j)))) {
                    abc += input.charAt(j);
                }
            }
            input = abc;
            abc = "";
        }
        //System.out.println("input.size"+input.length());
        if (input.length() == 0) {
            System.out.println("empty");
        } else {

            System.out.println(input);
        }
    }
}
