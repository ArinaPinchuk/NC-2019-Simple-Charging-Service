package com.netcracker.edu.name.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    @RequestMapping(value = "/get-simple-object")
    SimpleObject getSimpleString() {
        SimpleObject simpleObject= new SimpleObject();
        simpleObject.setId(12345);
        simpleObject.setName("Arina");
        return simpleObject;
    }

}
class SimpleObject{
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
