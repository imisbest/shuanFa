package com.csw.algorithm.ThreadXiangMu;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 使用队列方式多线程消费
 */
public class QueueThread {
    public static void main(String[] args) {
        final Queue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.add("11111111111");
        queue.add("22222222222");
        queue.add("33333333333");
        queue.add("44444444444444");
        queue.add("555555555555555");
        queue.add("666666666666666");
        queue.add("7777777777777");

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (queue.size() > 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String value = queue.poll();
                        if (value != "" && null != value)
                            System.out.println(Thread.currentThread().getName() + "------------ " + value);
                    }
                }
            }).start();
        }
    }
    /*这种写法，既不会出现漏掉资源的情况，同时也不会出现将同一个资源同时执行的情况！
        ————————————————
        版权声明：本文为CSDN博主「fengchao2016」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/fengchao2016/article/details/79489867
*/
}