package com.gitee.shiayanga.concurrency;

/**
 * 并发测试
 *
 * @author LiYang
 * @version 1.0
 * @date 2022/1/7 9:15
 */
public class ConcurrencyTest {
    private static final long COUNT = 1500000000;

    public static void main(String[] args) throws Exception{
        concurrency();
        serial();
    }
    /**
     * 并发执行的方法
     *
     * @author LiYang
     * @date 2022/1/7 9:16
     */
    private static void concurrency() throws Exception {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < COUNT; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency:" + time + "ms,b=" + b);
    }

    /**
     * 串行
     *
     * @author LiYang
     * @date 2022/1/7 9:35
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,a=" + a + ",b=" + b);
    }
}
