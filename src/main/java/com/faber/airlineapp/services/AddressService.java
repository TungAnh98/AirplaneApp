/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.airlineapp.services;

import com.faber.airlineapp.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Engineer_Account
 */
@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    
    
}
