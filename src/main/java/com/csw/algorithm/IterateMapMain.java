package com.csw.algorithm;

import java.util.HashMap;

public class IterateMapMain {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("India", "Delhi");
        map.put("Japan", "Tokyo");
        map.put("France", "Paris");
        map.put("Russia", "Moscow");
        System.out.println("Iterating java Iterator");
        for (String cc : map.keySet()) {
            map.put("Nepal", "KathMandu");
            System.out.println(cc);
        }
        System.out.println("-----------------");
    }
}
