package com.csw.shuanFa;

import java.util.HashMap;

public class CountSZ {
    public static void main(String[] args) {
        int[] arr = new int[]{9,7,7,9,9,3};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.get(j) == null) {
                map.put(j, 1);
            } else {
                int cou = map.get(j);
                map.put(j, cou + 1);
            }
        }
        for (Integer mm: map.keySet()) {
            System.out.println(mm+"出现了"+map.get(mm)+"次");
        }
    }
}
