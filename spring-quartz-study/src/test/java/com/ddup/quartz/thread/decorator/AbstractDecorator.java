package com.ddup.quartz.thread.decorator;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author wanjin.hao@woqutech.com
 * @Date 21-07-2020
 */
public abstract class AbstractDecorator implements Component {

    public Component comp;

    public AbstractDecorator(Component comp) {
        this.comp = comp;
    }

    @Override
    public void makeKoKo() {
        comp.makeKoKo();
    }
}
