package com.wanyu.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanyu on 2018/4/3.
 * 创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
 * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
 * 此线程池保证所有任务的执行顺序按任务的提交顺序执行
 */
public class SinglethreadTest {
    public static void main(String[] args) {
        ExecutorService service= Executors.newSingleThreadExecutor();
        Thread t1=new MyThread();
        Thread t2=new MyThread();
        Thread t3=new MyThread();
        //将线程放入线程池中执行
        service.execute(t1);
        service.execute(t2);
        service.execute(t3);
        service.shutdown();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            if(i==2){
                throw new RuntimeException("异常");//因异常结束 执行下一个异常
            }
            System.out.println(Thread.currentThread().getName()+"正在执行");
        }
    }
}
