package com.gitee.shiayanga.concurrency.interrupt;

import java.util.HashMap;

/**
 * TODO
 *
 * @author LiYang
 * @version 1.0
 * @date 2022/1/7 16:41
 */
public class InterruptTest {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                BThread bThread = new BThread();
                bThread.start();
                String name = Thread.currentThread().getName();
                System.out.println(name + " 开始执行");
                try {
                    Thread.sleep(2000);
                    Thread.currentThread().interrupt();
                    bThread.join();
                } catch (InterruptedException e) {
                    System.out.println(name + " 中断");
                }
                System.out.println(name + " 结束");
            }
        },"[NThread] Thread");
        thread.start();
        thread.join();
    }

    public void test(){
        new HashMap<String, String>()
    }
}
