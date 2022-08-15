package com.example.demo_3.Service;

import com.example.demo_3.Entity.CUSTOMER;
import com.example.demo_3.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServicelmpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public String addCustomer(CUSTOMER customer) {
      CUSTOMER  cus = customerRepository.findById_no(customer.getId_no());
      if (Objects.isNull(cus)){
          if (cus.getPostalCode().length() > 15){
              customerRepository.save(customer);
              return "Them  moi thanh cong";
          }
          return "Truong postalCode ,,,,,";
      }else {
          return "Id_no da ton tai.Ko the them moi";
      }

    }

    @Override
    public CUSTOMER updateCustomer(long id, CUSTOMER customer) {
        if(customer != null){
            CUSTOMER customer1 = customerRepository.getReferenceById(id);

            if(customer != null){

                customer1.setId_no(customer.getId_no());
                customer1.setFistName(customer.getFistName());
                customer1.setLastName(customer.getLastName());
                customer1.setStreet(customer.getStreet());
                customer1.setPostalCode(customer.getPostalCode());
                customer1.setCity(customer.getCity());
                customer1.setCountryID(customer.getCountryID());

                return  customerRepository.save(customer1);

            }
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(long id) {
        if(id>=1){
            CUSTOMER  customer = customerRepository.findById(id);
            if(customer !=  null){
                customerRepository.delete(customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public CUSTOMER getOneCustomer(long  id) {
        return customerRepository.findById(id);
    }
    @Override
    public  CUSTOMER getOne1Customer(String lastName){
        return  customerRepository.findByLastName(lastName);
    }

    @Override
    public List<CUSTOMER> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public List<CUSTOMER> getOne2Customers(CUSTOMER customer) {
        return customerRepository.myCustomQuery2(customer.getLastName(),customer.getId_no(),customer.getCity());
    }


}
