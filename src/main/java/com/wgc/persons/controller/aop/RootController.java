package com.wgc.persons.controller.aop;

import com.wgc.persons.exception.root.OrdinaryUserException;
import com.wgc.persons.exception.root.TouristException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class RootController {

    @Autowired
    private HttpSession session;

    @Pointcut(value = "execution(* com.wgc.persons.controller.admin.AdminController.*(..))")
    public void adminMethod() {
    }

    @Around("adminMethod()")
    public String accessAuthority(ProceedingJoinPoint joinPoint) throws Throwable {
        //String name = (String) session.getAttribute("name");
       // int id = (int) MySession.getSession().getAttribute("id");
        String name = (String) session.getAttribute("name");
        int id = (int) session.getAttribute("id");
        //理论上讲这里应该抛异常的，最后有一全局的异常来处理
        if (id == 1) {
            return (String) joinPoint.proceed();
        } else if (id == 2){
          throw  new  OrdinaryUserException(name);
        } else {
          throw  new TouristException();
        }

    }
}
