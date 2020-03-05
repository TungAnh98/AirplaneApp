/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.airlineapp.repositories;

import com.faber.airlineapp.entities.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Engineer_Account
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<Person> findByName(String name);
    public List<Person> findByCreativeName();
    
    @Query("select p from Person p where p.id < (:id)")
    public List<Person> findWithParams (@Param("id") int id);
}
