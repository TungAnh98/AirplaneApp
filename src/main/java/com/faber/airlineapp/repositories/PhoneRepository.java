/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.airlineapp.repositories;

import com.faber.airlineapp.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Engineer_Account
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    
}
