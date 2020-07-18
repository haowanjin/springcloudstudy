package com.ddup.quartz.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author wanjin.hao@woqutech.com
 * @Date 18-07-2020
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> System.out.println("新年好!"));
        service.submit(() -> System.out.println("新年好!"));
    }


}
