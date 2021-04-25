package com.csw.shuanFa.ThreadShunXu;
/*好了，到这里不知道大家感觉怎么样，有没有想明白，其实，关于多线程顺序执行的问题，
我总结了一个万能的解答方法，通过一个小例子进行演示

        例题描述：建立三个线程，A线程打印100次A，B线程打印100次B,C线程打印100次C，
        要求线程同时运行，交替打印100次ABC。这个问题用Object的wait()，
        notify()就可以很方便的解决。

        代码如下：*/

public class QueueThread implements Runnable {

    private Object current;
    private Object next;
    private int max = 100;
    private String word;

    public QueueThread(Object current, Object next, String word) {
        this.current = current;
        this.next = next;
        this.word = word;
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Object d = new Object();
        Object e = new Object();
        //之所以每次当前线程都要sleep(10)是为了保证线程的执行顺序
        new Thread(new QueueThread(a, b, "a")).start();
        Thread.sleep(10);
        new Thread(new QueueThread(b, c, "b")).start();
        Thread.sleep(10);
        new Thread(new QueueThread(c, d, "c")).start();
        Thread.sleep(10);
        new Thread(new QueueThread(d, e, "d")).start();
        Thread.sleep(10);
        Thread thread4 = new Thread(new QueueThread(e, a, "e"));
        thread4.start();
        thread4.join();//因为线程0-4停止是依次执行的，所以如果保证主线程在线程4后停止，
        // 那么就能保证主线程是最后关闭的
        System.out.println("程序耗时：" + (System.currentTimeMillis() - startTime));

    }

    @Override
    public void run() {
        for (int i = 0; i < max; i++) {
            synchronized (current) {
                synchronized (next) {
                    System.out.println(word);
                    next.notify();
                }
                try {
                    current.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //必须做一下这样处理，否则thread1-thread4停不了
        synchronized (next) {
            next.notify();
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }

    }
}

/*

其实这个程序很容易理解，首先，我们保证了线程0-线程4依次启动，并设置了Thread.sleep(10)，
保证线程0-4依次执行他们的run方法。

        其次，我们看QueueThread的run()便可知：1.线程获得current锁，2.获得next锁。
        3.打印并notify拥有next锁的一个对象4.线程执行current.wait(),
        释放current锁对象，并使线程处于阻塞状态。

        然后，假设已经执行到了thread-4的run方法，那么此时的情况是这样的：

        线程0处于阻塞状态，需要a.notify()才能使其回到runnale状态

        线程1处于阻塞状态，需要b.notify()才能使其回到runnale状态

        线程2处于阻塞状态，需要c.notify()才能使其回到runnale状态

        线程3处于阻塞状态，需要d.notify()才能使其回到runnale状态

        而线程4恰好可以需要执行a.notify()，所以能够使线程0回到runnale状态。
        然后执行e,wait()方法，使自身线程阻塞，需要e.notify()才能唤醒。

        依次执行下去，就可以发现规律了！

        最后之所以要在for循环后加上一个处理，是因为，如果不进行处理，
        除了线程0能够结束for循环，其余线程1-4实际上是会停在current,wait()这句代码的。

        假设已经执行到最后一次循环了，此时线程4唤醒线程0，并将自身阻塞。线程0被唤醒后，
        继续执行，然而因为i=max的缘故，它无法再进入循环了。
        然而如果循环后没有唤醒下一个线程的操作的话，
        那么剩下的线程1-4就会一直处于阻塞状态！也就不会停止了。
        但是加了处理之后就完美解决了。*/
