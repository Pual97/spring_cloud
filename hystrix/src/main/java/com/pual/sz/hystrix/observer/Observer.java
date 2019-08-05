package com.pual.sz.hystrix.observer;

public abstract class Observer {

    protected Subject subject;
    public abstract void update();

}
