package com.csw.shuanFa.ThreadXiangMu;

import static java.lang.Thread.sleep;

/**
 * 有时效的 join
 * 等够时间
 */
public class Join3 {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });
        long start = System.currentTimeMillis();
        t1.start();

        t1.join(1500);
        long end = System.currentTimeMillis();
        System.out.println("r1: {} r2: {} cost: {}" + r1 + "," + r2 + "," + (end - start));
    }
}
