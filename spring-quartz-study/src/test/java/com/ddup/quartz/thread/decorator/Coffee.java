package com.ddup.quartz.thread.decorator;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author wanjin.hao@woqutech.com
 * @Date 21-07-2020
 */
public class Coffee implements Component {

    @Override
    public void makeKoKo() {
        System.out.println("倒入咖啡。。。。");
    }
}
