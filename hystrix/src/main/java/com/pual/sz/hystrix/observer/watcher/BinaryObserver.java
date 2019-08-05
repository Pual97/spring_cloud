package com.pual.sz.hystrix.observer.watcher;


import com.pual.sz.hystrix.observer.Observer;
import com.pual.sz.hystrix.observer.Subject;


public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject  = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
