package com.csw.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        Set<Integer> set1 = new HashSet<>(list);
        List<Integer> listNew = new ArrayList<>(set1);
        System.out.println(listNew);
    }
}
