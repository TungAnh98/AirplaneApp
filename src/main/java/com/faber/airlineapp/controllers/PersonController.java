package com.faber.airlineapp.controllers;

import com.faber.airlineapp.entities.Hotel;
import com.faber.airlineapp.entities.Person;
import com.faber.airlineapp.entities.Phone;
import com.faber.airlineapp.repositories.HotelRepository;
import com.faber.airlineapp.repositories.PersonRepository;
import com.faber.airlineapp.services.PersonService;
import com.faber.airlineapp.services.PhoneService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Engineer_Account
 */
@Controller
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PhoneService phoneService;

    @Autowired
    HotelRepository hotelRepository;
    
    @Value("${tunganh.test.url}")
    String myTestUrl;

    @GetMapping(path = "all")
    public String getAllPeople(Model model) {
        model.addAttribute("people", personService.findAll());
        return "person/all";
    }

    @GetMapping(path = "test")
    public String getByName(Model model) {
        model.addAttribute("people", personService.findWithParams(4));
        model.addAttribute("myTestUrl", myTestUrl);
        return "person/all";
    }

    @GetMapping("")
    public String index() {
        return "person/index";
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "phoneNumber", required = false, defaultValue = "0123456789") String phoneNumber,
            Model model) {
        Person newPerson = new Person();
        newPerson.setName(name);
        personService.savePerson(newPerson);
        Phone phone = new Phone();
        phone.setPhoneNumber(phoneNumber);
        phone.setPerson(newPerson);
        phoneService.save(phone);
        model.addAttribute("people", personService.findAll());
        return "person/all";
    }

    @GetMapping("/manytomany")
    @Transactional
    public String manytomany(@RequestParam(name="id",required=false,defaultValue="1")String id,Model model) {
        Hotel queryResult = hotelRepository.findById(Integer.valueOf(id)).get();
        model.addAttribute("people",queryResult.getPersons());
        return "person/all";
       
    }
}
