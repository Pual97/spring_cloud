package com.pual.sz.hystrix.observer.watcher;

import com.pual.sz.hystrix.observer.Observer;
import com.pual.sz.hystrix.observer.Subject;

public class HexaObserver extends Observer {
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
