package com.wgc.persons.spring.root;

        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;

@Configuration  //配置文件
@ComponentScan("com.wgc.persons.service")   //扫描service层
public class SpringServiceConfig {

}
