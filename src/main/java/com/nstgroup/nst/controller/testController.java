package com.nstgroup.nst.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class testController {

    @RequestMapping(value= "/test", method = RequestMethod.GET)
    public String test(){
        return "test";
    }
}
