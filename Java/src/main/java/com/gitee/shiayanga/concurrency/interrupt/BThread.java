package com.gitee.shiayanga.concurrency.interrupt;

/**
 * TODO
 *
 * @author LiYang
 * @version 1.0
 * @date 2022/1/7 16:45
 */
public class BThread extends Thread{
    public BThread(){
        super("[BThread] Thread");
    }
    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 开始执行");
        try {
            for (int i = 0;i < 10;i++){
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " 结束" );
        }catch (Exception e){
            System.out.print(threadName);
            e.printStackTrace();
        }
    }
}
