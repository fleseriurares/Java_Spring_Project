package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //by default e la root path
    //ca sa modificam path la /hello, folosim ():
//    @GetMapping("hello") //pentru request
//    @ResponseBody //face partea de html pentru noi
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives /hello/goodbye
    @GetMapping("goodbye") //pentru request
    @ResponseBody
    public String goodbye(){
        return "GoodBye, Spring!";
    }

    // Hanfles request of the form /hello?name=LaunchCode
    @RequestMapping(value ="hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){ //PathVariable cauta /{name{
        model.addAttribute("greeting",  "Hello, " + name + "!");
        return "hello";
    }

    //Form Submission:
    // /hello/form
    @GetMapping("form") //fara ResponseBody va cauta in templates
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
