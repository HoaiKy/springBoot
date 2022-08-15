package com.example.demo_3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CUSTOMER {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_no")
    private String id_no;

    @Column(name = "Fistname")
    private String fistName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "Street")
    private String street;

    @Column(name = "Postalcode")
    private String postalCode;

    @Column(name = "City")
    private String city;

    @Column(name = "CountryID")
    private String countryID;

    public CUSTOMER() {
    }

    public CUSTOMER(Long id, String id_no, String fistName, String lastName, String street, String postalCode, String city, String countryID) {
        this.id = id;
        this.id_no = id_no;
        this.fistName = fistName;
        this.lastName = lastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.countryID = countryID;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }
}
