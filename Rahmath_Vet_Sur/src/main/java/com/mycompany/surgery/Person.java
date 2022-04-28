package com.mycompany.surgery;

//package serialisation;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rahma
 */
public class Person implements Serializable {

    String given_name;
    String surname;
    String address;
    String postcode;
    //private static final long serialVersionUID = 5462223600l;

    /*
 *this code will return person information. 
 *@return 
     */
    public Person(String given_name, String surname, String address, String postcode) {
        this.given_name = given_name;
        this.surname = surname;
        this.address = address;
        this.postcode = postcode;

    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
