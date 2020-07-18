package test;

import lombok.val;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
    public static void main(String[] args) {
        TestMap t = new TestMap();

        val s = ClassLayout.parseInstance(t).toPrintable();
        System.out.println(s);
    }
}
