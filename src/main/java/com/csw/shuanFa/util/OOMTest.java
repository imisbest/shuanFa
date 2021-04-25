package com.csw.shuanFa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            System.out.println("i]" + i);
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
