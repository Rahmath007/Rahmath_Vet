/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.surgery;

//package serialisation;
import java.io.Serializable;

/**
 *
 * @author rahma
 *
 */
public class Animal implements Serializable {

    String animal_type;
    String animal_breed;
    String animal_name;
    String animal_gender;
    String animal_colour;
    String animal_issue;
    double age;
    double weight;
    Person owner;

    /*
 *this code will return Animal information. 
 *@return 
     */
    public Animal(String animal_type, String animal_breed, String animal_name, String animal_gender, String animal_colour, String animal_issue, double age, double weight, Person owner) {
        this.animal_type = animal_type;
        this.animal_breed = animal_breed;
        this.animal_name = animal_name;
        this.animal_gender = animal_gender;
        this.animal_colour = animal_colour;
        this.animal_issue = animal_issue;
        this.age = age;
        this.weight = weight;
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public String getAnimal_breed() {
        return animal_breed;
    }

    public void setAnimal_breed(String animal_breed) {
        this.animal_breed = animal_breed;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getAnimal_issue() {
        return animal_issue;
    }

    public void setAnimal_issue(String animal_issue) {
        this.animal_issue = animal_issue;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAnimal_gender() {
        return animal_gender;
    }

    public void setAnimal_gender(String animal_gender) {
        this.animal_gender = animal_gender;
    }

    public String getAnimal_colour() {
        return animal_colour;
    }

    public void setAnimal_colour(String animal_colour) {
        this.animal_colour = animal_colour;
    }

}
