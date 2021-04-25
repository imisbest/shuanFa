package com.csw.shuanFa;

import java.util.*;

public class ScoreRemove {
    public static void main(String[] args) {
        int[] scores =new int []{0,0,1,1,1,2,2,3,3,4};

        ArrayList<Integer> list = new ArrayList<>();
        for (int score : scores) {
            list.add(score);
        }
        HashSet<Integer> set1 = new HashSet<>(list);
        ArrayList<Integer> listNew = new ArrayList<>(set1);
        for (Object o : listNew) {
            System.out.println(o);
        }
    }
}
