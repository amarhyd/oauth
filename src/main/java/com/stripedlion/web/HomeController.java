package com.stripedlion.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by drewsmith on 3/30/16.
 */
@RestController
public class HomeController {

    @RequestMapping("home")
    public String home() {
        return "Home";
    }

}
