package com.lance.demo.spring.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by perdonare on 2017/3/10.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "person")
@XmlType(name="personType")
public class Person {
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
