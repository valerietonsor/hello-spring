package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handles requests @ /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello") //handles post & get methods
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        return language + " " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives @ /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name' >" +
                "<select name='language'>" +
                "<option value='Hello'>English</option>" +
                "<option value='Bonjour'>French</option>" +
                "<option value='Hola'>Spanish</option>" +
                "<option value='Hallo'>German</option>" +
                "<option value='Helo'>Welsh</option>" +
                "</select>" +
                "<input type='submit' value= 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";


    }

}
