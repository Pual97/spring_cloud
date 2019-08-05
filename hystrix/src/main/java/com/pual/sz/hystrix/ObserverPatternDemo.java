package com.pual.sz.hystrix;

import com.pual.sz.hystrix.observer.Subject;
import com.pual.sz.hystrix.observer.watcher.BinaryObserver;
import com.pual.sz.hystrix.observer.watcher.HexaObserver;
import com.pual.sz.hystrix.observer.watcher.OctalObserver;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年08月05日 16:17:00
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
