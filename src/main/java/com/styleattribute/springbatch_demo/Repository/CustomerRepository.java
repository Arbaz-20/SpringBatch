/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styleattribute.springbatch_demo.Repository;

import com.styleattribute.springbatch_demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author arbaz
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
