/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.styleattribute.springbatch_demo.config;

import com.styleattribute.springbatch_demo.Repository.CustomerRepository;
import com.styleattribute.springbatch_demo.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

/**
 *
 * @author arbaz
 */
@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class springbatchconfig {
    
    
    private JobBuilderFactory jobBuilderFactory;
    
    private StepBuilderFactory stepBuilderFactory;
    
    private CustomerRepository customerRepository;
       
    @Bean
    public FlatFileItemReader<Customer> read(){
        FlatFileItemReader<Customer> itemreader = new FlatFileItemReader<>();
        itemreader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemreader.setName("CSV Reader");
        itemreader.setLinesToSkip(1);
        itemreader.setLineMapper(lineMapper());
        return itemreader;
    }
 
    //Linemapper for the item reader object to get all the data related to the files such as 
    private LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer LineTokenizer = new DelimitedLineTokenizer();
        LineTokenizer.setDelimiter(",");
        LineTokenizer.setStrict(false);
        LineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");
        
        //BeanWrapprerFieldSetMapper is the method to process the targeted file in the system to process the millions of record
        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);
        
        //Setting the values in the method to return it 
        lineMapper.setLineTokenizer(LineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
    
}
