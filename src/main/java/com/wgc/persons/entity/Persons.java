package com.wgc.persons.entity;

import java.util.Date;

public class Persons {
    private Integer id;

    private String name;

    private Date birthday;

    private String city;

    private Integer age;

    private Long baborage;

    public Persons() {}

    public Persons(String name, Date birthday, String city, Integer age, Long baborage) {
        this.name = name;
        this.birthday = birthday;
        this.city = city;
        this.age = age;
        this.baborage = baborage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getBaborage() {
        return baborage;
    }

    public void setBaborage(Long baborage) {
        this.baborage = baborage;
    }
}