package com.csw.shuanFa.ThreadXiangMu;

import static java.lang.Thread.sleep;

public class Join4 {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });
        long start = System.currentTimeMillis();
        System.out.println("start]" + start);
        t1.start();
// 线程执行结束会导致 join 结束
        t1.join(1500);
        long end = System.currentTimeMillis();
        System.out.println("end]" + end);
        System.out.println("r1: {} r2: {} cost: {}" + r1 + "," + r2 + "," + (end - start));
    }
}
