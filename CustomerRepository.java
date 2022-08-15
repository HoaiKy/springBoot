package com.example.demo_3.Repository;


import com.example.demo_3.Entity.CUSTOMER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CUSTOMER, Long> {

    CUSTOMER findById(long id);

    CUSTOMER findById_no(String idNo);

    CUSTOMER findByLastName(String lastName);

    @Query(value = "select * from CUSTOMER c where c.lastName like %:lastName% or c.id_no  like %:id_no% or c.city like %:city%", nativeQuery = true)
    List<CUSTOMER> myCustomQuery2( String lastName,String id_no,String city);
//    @Param("lastName")
// and c.id_no  like %:id_no%
//    List<CUSTOMER> myCustomQuery2();
}
