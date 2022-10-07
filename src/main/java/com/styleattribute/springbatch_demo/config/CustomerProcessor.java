/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styleattribute.springbatch_demo.config;

import com.styleattribute.springbatch_demo.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

/**
 *
 * @author arbaz
 */
public class CustomerProcessor implements ItemProcessor<Customer, Customer>{

    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
    }
    
    
}
