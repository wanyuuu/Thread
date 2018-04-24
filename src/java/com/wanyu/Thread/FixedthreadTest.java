package com.wanyu.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanyu on 2018/4/3.
 * 线程池 减少了创建线程和销毁线程的次数 每个工作线程都可被重复利用
 * 可根据系统情况调整执行的线程数量 防止消耗内存过多
 * 线程开的越多 消耗内存也越大（每个线程大约1MB内存）
 * 线程池的顶级接口是Executor 但它只是一个执行线程的工具
 * 真正的线程池接口是ExecutorService
 */
public class FixedthreadTest {
    public static void main(String[] args) {
        /*
            创建池固定大小的线程 每提交一个任务就创建一个线程 直到达到线程池的最大大小
            若某个线程因异常结束 则线程池会补充一个新线程
         */
        //创建一个固定大小的线程池 3个线程
        ExecutorService service= Executors.newFixedThreadPool(3);
        for(int i=0;i<5;i++){
          //  System.out.println("创建线程"+i);
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"启动线程");
                }
            };
            service.execute(runnable);//未来某个时间执行启动线程的命令
        }
        service.shutdown();//关闭线程
        try {
            //一直等待子线程结束 再继续执行下列代码
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            System.out.println("完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
