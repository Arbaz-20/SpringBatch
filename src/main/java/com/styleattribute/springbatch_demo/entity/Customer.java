/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styleattribute.springbatch_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author arbaz
 */
@Entity
@Table(name="customer_info")
public class Customer {
    
    @Id
    private int id;
    
    @Column(name="FirstName")
    private String firstName;
    
    @Column(name="LastName")
    private String lastName;
    
    @Column(name="Email")
    private String email;
    
    @Column(name="Gender")
    private String gender;
    
    @Column(name="ContactNo")
    private String contactNo;
    
    @Column(name="Country")
    private String country;
    
    @Column(name="Dob")
    private String dob;
    
    
}
