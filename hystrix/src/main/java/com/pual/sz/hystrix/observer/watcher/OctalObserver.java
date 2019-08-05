package com.pual.sz.hystrix.observer.watcher;

import com.pual.sz.hystrix.observer.Observer;
import com.pual.sz.hystrix.observer.Subject;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
