package com.wgc.persons.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class UserController {


    @GetMapping(value = "/login/{name},{id}",produces = "application/json;charset=utf-8")
    public String jurisdiction(HttpServletRequest request, @PathVariable("name") String name, @PathVariable("id") int id) {
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("id", id);
        System.out.println(name);
        System.out.println(id);
        return "登陆成功";
    }

    @Autowired
    WebApplicationContext webApplicationContext;

    @GetMapping(value = "/ioc")
    public HashMap<String,String[]> getAllIoc(){
        return new HashMap<String, String[]>(){{

            System.out.println("-------------------父容器-----------------");

            for (String beanDefinitionName : webApplicationContext.getBeanDefinitionNames()) {
                System.out.println(beanDefinitionName);
            }

            System.out.println("-------------------子容器-----------------");

            for (String beanDefinitionName : webApplicationContext.getParent().getBeanDefinitionNames()) {
                System.out.println(beanDefinitionName);
            }


            put("父容器",webApplicationContext.getBeanDefinitionNames());
            put("子容器", Objects.requireNonNull( webApplicationContext.getParent().getBeanDefinitionNames() ));
        }};
    }


}
