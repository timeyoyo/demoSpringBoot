package com.imooc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${ccc}")
//    private String ccc;

    @Autowired
    private GirlProperties obj;

    @RequestMapping(value = {"/guy", "/hi"}, method = RequestMethod.GET)
    public String say() {
//        return "hello!@!!!!!" + cupSize + age + ccc;
        return "hello!@!!!!!" + obj.getCupSize() + obj.getAge();
    }

    // localhost:8088/hello/fuck/100
    @RequestMapping(value = {"/fuck/{who}", "/go"}, method = RequestMethod.GET)
    public String fuck(@PathVariable("who") Integer who) {
//        return "hello!@!!!!!" + cupSize + age + ccc;
//        return "hello!@!!!!!" + obj.getCupSize() + obj.getAge();
        return "---> " + who;
    }


    //localhost:8088/hello/see?who=100
    @RequestMapping(value = {"/see"}, method = RequestMethod.GET)
    public String see(@RequestParam(value = "who", required = false, defaultValue = "0") Integer who) {
//        return "hello!@!!!!!" + cupSize + age + ccc;
//        return "hello!@!!!!!" + obj.getCupSize() + obj.getAge();
        return "---> " + who;
    }

    //localhost:8088/hello/see?who=100
    @GetMapping(value = {"/play"})
    public String play(@RequestParam(value = "who", required = false, defaultValue = "0") Integer who) {
//        return "hello!@!!!!!" + cupSize + age + ccc;
//        return "hello!@!!!!!" + obj.getCupSize() + obj.getAge();
        return "---> " + who;
    }
}
