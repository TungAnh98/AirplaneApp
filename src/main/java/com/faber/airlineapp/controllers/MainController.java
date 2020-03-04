/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.airlineapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Engineer_Account
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "welcome";
    }
}
