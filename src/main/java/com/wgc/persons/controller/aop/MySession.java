package com.wgc.persons.controller.aop;

import javax.servlet.http.HttpSession;

public class MySession {
    public static ThreadLocal<HttpSession> session = null;

    public static HttpSession getSession() {
        return session.get();
    }
}
