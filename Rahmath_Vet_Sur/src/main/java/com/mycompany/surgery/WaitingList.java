package com.mycompany.surgery;

import java.time.LocalDate;  // import the LocalDate class

import java.io.Serializable;
import java.util.ArrayList;

public class WaitingList implements Serializable {

    LocalDate myObj = LocalDate.now();  // Create a date object

    private final ArrayList<Animal> waitingList;
    public final int MAX;

    public WaitingList(int maxIn) {
        waitingList = new ArrayList<>();
        MAX = maxIn;
    }

    public String addAnimal(Animal creature) {
        if (!isFull()) {
            waitingList.add(creature);

            return creature.animal_name + "Animal Added";
        } else {
            return "Animal Failed to add!!";
        }
    }

    /**
     * Reports on whether or not the list is empty
     *
     * @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    /**
     * Reports on whether or not the list is full
     *
     * @return Returns true if the list is full and false otherwise
     */
    public boolean isFull() {
        boolean fullChecker;
        if (waitingList.size() <= MAX) {
            fullChecker = false;
        } else {
            fullChecker = true;
        }
        return fullChecker;
    }

    /**
     * Outputs all the Animal and owner details in the list
     *
     * @return Returns all the Animal and owners in the list in an easy to read
     * format
     */
    public String displayWaitingList() {

        String output = "\n";
        for (int counter = 0; counter < waitingList.size(); counter++) {
            output += waitingList.get(counter).owner.given_name + " " + waitingList.get(counter).owner.surname + "\t";
            output += "Owners of " + waitingList.get(counter).animal_name + "\n";
            output += waitingList.get(counter).animal_name + " suffering from " + waitingList.get(counter).animal_issue;
            output += "\n" + "Animal Details: ";
            output += "\n" + "Type of Animal: " + waitingList.get(counter).animal_type + "\n" + " Animal Breed: " + waitingList.get(counter).animal_breed + "\n" + " Animal name: " + waitingList.get(counter).animal_name + "\n" + "Animal Gender: " + waitingList.get(counter).animal_gender + "\n" + "Animal Colour: " + waitingList.get(counter).animal_colour + "\n" + "Animal Issue: " + waitingList.get(counter).animal_issue + "\n";
            output += "Date of Registration: " + (myObj) + "\n";  // Display the current date
            output += "\n" + "Owner's Details";
            output += "\n" + "Name: " + waitingList.get(counter).owner.given_name + "\n" + "Surname: " + waitingList.get(counter).owner.surname + "\n" + "Address: " + waitingList.get(counter).owner.address + "\n" + "Postcode: " + waitingList.get(counter).owner.postcode + "\n";
            output += "\n" + " ------------------------------------------------------------------------ ";
            output += "\n\n";
        }
        return output;
    }
}
