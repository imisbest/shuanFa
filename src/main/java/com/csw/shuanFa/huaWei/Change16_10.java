package com.csw.shuanFa.huaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Change16_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            String input = sc.next();
            if (!input.startsWith("0x")) {
                break;
            }
            String ins = input.substring(2);
            list.add(Integer.parseInt(ins, 16));//x.toHexString(x);十进制转换到16进制

        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
