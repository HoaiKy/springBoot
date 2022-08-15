package com.example.demo_3.Service;

import com.example.demo_3.Entity.CUSTOMER;

import java.util.List;


public interface ICustomerService {

   public String addCustomer(CUSTOMER customer);

    public CUSTOMER updateCustomer(long id, CUSTOMER customer);

    public boolean deleteCustomer(long id);

    public CUSTOMER getOneCustomer(long id);

    public  CUSTOMER getOne1Customer(String lastName);

    public List <CUSTOMER> getAllCustomer();

    public List <CUSTOMER> getOne2Customers(CUSTOMER customer);
//    public boolean addCustomer(CUSTOMER customer);


//    List<CUSTOMER> getOne2Customers(String lastName);
}
