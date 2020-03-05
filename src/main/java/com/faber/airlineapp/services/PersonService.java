/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.airlineapp.services;

import com.faber.airlineapp.entities.Person;
import com.faber.airlineapp.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Engineer_Account
 */
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    
    public ArrayList<Person> findAll(){
        return (ArrayList<Person>) personRepository.findAll();
    }
    
    public List<Person> findByName(String name){
        return (ArrayList<Person>)personRepository.findByName(name);
    }
    
    public List<Person> findByCreativeName(){
        return (ArrayList<Person>) personRepository.findByCreativeName();
    }
    public List<Person> findWithParams(int id){
        return (ArrayList<Person>) personRepository.findWithParams(id);
    }
    public void savePerson(Person p){
        personRepository.save(p);
    }
}
