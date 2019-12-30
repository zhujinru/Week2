package com.bawei.week2.base;

public abstract class BasePresenter <V> {
    public V view;

    public void attach(V view) {
        this.view = view;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void detach(){
        view=null;
    }
}
