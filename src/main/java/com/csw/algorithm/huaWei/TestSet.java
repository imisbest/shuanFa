package com.csw.algorithm.huaWei;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.size());
        set.add(1);
        System.out.println(set.size());

    }
}
