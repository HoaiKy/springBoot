package com.example.demo_3.Controller;

import com.example.demo_3.Entity.CUSTOMER;
import com.example.demo_3.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller
@RequestMapping("/customer")
public class CustomerService {
    @Autowired
    private ICustomerService iCustomerService;


    @GetMapping("/")
    public String test(){
        return "hoai";
    }

    @PostMapping("/add")
    public String addCustomer(@RequestBody CUSTOMER  customer){
        String result = iCustomerService.addCustomer(customer);
        return result;

    }
//    public ResponseEntity<Map<String,Object>> addCustomer(@RequestBody CUSTOMER  customer) {
//        Map<String, Object> result = new HashMap<>();
//        if(iCustomerService.addCustomer(customer)){
//            result.put("message","Them thanh cong");
//            result.put("status",HttpStatus.OK.value());
//            return new ResponseEntity<>(result,HttpStatus.OK);
//        }
//        result.put("message","Them thất bại////Trung id_no hoac postalCode it hon 15 ki tu");
//        result.put("status", HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
//    }
    @GetMapping("/update")
    public  CUSTOMER updateCustomer(@RequestParam("id") long id,@RequestBody CUSTOMER customer){
        return iCustomerService.updateCustomer(id, customer);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Object>> deleteCustomer(@PathVariable("id")long id){
        Map<String, Object> result = new HashMap<>();
        if (iCustomerService.deleteCustomer(id)){
            result.put("message","Xóa thành công");
            result.put("status", HttpStatus.OK.value());
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        result.put("message","Xóa thất bại");
        result.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/find/{id}")

    public CUSTOMER getOneCustomer(@PathVariable("id") long id){
        return iCustomerService.getOneCustomer(id);
    }

    @GetMapping("/findByName/{lastName}")
    public CUSTOMER getOne1Customer(@PathVariable("lastName") String lastName){
        return iCustomerService.getOne1Customer(lastName);
    }
    @GetMapping("/list")
    public List<CUSTOMER> getAllStudent(){
        return iCustomerService.getAllCustomer();
    }


//   @GetMapping("/li/{lastName}{id_no}")
//    public List<CUSTOMER> getOne2Customers(@PathVariable("lastName")String lastName,@PathVariable("id_no") String id_no){
//
//        return   iCustomerService.getOne2Customers(lastName,id_no);
//   }
//@RequestParam(value="param1", required=true) String param1, @RequestParam(value="param2", required=false) String param2
    @PostMapping("/li")
    public List<CUSTOMER> getOne2Customers(@RequestBody(required = false) CUSTOMER customer ){
        return  iCustomerService.getOne2Customers(customer);
    }


}
