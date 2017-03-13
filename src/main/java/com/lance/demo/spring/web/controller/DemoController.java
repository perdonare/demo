package com.lance.demo.spring.web.controller;

import com.lance.demo.spring.web.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by perdonare on 2017/3/9.
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/demo")
    @ResponseBody
    public String getUserName() {
        return "lance";
    }

    @GetMapping(value = "/person",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson() {
        Person person = new Person("lance", 28);
        return person;
    }
}
