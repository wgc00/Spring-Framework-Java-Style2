package com.wgc.persons.exception.root;

public class TouristException extends Exception {
    public TouristException() {
        super("您是游客无法访问这个页面，请先去注册才可以访问");
    }
}
