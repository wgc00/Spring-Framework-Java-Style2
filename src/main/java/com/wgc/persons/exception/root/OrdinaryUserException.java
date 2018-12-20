package com.wgc.persons.exception.root;

public class OrdinaryUserException extends Exception {
    public OrdinaryUserException(String name){
        super(name + "，您是普通用户，没有权限访问这个页面，开通会员在访问");
    }
}
