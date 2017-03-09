package com.lance.demo.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
