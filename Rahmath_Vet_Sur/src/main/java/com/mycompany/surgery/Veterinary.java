package com.mycompany.surgery;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * GUI for the Veterinary application.
 *
 * @author Rahmath
 * @version 1.0
 *
 */
public class Veterinary extends Application {

    //this is the trick. Have class that contains an arrayList here
    //this class can be used for added, deleting and searching for items
    //you will create the object in the start method
    private WaitingList animalList;

    // WIDTH and HEIGHT of GUI stored as constants 
    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;
    // visual components
    private final Label headingLabel = new Label(" Rahmath Veterinary Surgery");
    private final Label patientLabel = new Label("Animal Details");
    //ComboBox.setPromptText("Email address");
    ComboBox<String> box = new ComboBox<>();
    //ComboBox.setValueText("");
    private final Label breedLabel = new Label("Animal Breed");
    private final TextField breedField = new TextField();
    private final Label animalNameLabel = new Label("Animal Name");
    private final TextField animalNameField = new TextField();
    private final Label animalGenderLabel = new Label("Animal Gender");
    private final TextField animalGenderField = new TextField();
    private final Label animalColourLabel = new Label("Animal Colour");
    private final TextField animalColourField = new TextField();
    private final Label animalIssueLabel = new Label("Animal Issue");
    private final TextField animalIssueField = new TextField();
    private final Label ageLabel = new Label("Age");
    private final TextField ageField = new TextField();
    private final Label weightlLabel = new Label("Weight");
    private final TextField weightField = new TextField();
    private final Separator sectSeparator = new Separator();
    private final Separator sectSeparator2 = new Separator();
    private final Separator sectSeparator3 = new Separator();
    private final Separator sectSeparator4 = new Separator();
    private final Label ownerLabel = new Label("Owner Details");
    private final Label nameLabel = new Label("Given Name");
    private final TextField nameField = new TextField();
    private final Label surnameLabel = new Label("Surname");
    private final TextField surnameField = new TextField();
    private final Label addressLabel = new Label("Owner Address");
    private final TextField addressField = new TextField();
    private final Label postcodeLabel = new Label("Owner Postcode");
    private final TextField postcodeField = new TextField();
    private final TextArea displayAnimals = new TextArea();
    private final Button addButton = new Button("Register The Animal");
    private final Button storeButton = new Button("Store The Animal");
    private final Button clearButton = new Button("Clear The Animal");

    /**
     *
     * @param stage
     */
    public void start(Stage stage) {

        if (!showPatientsList()) {
            animalList = new WaitingList(20);
        }
        // This is the box for 
        box.setPromptText("Animal Type");
        box.getItems().addAll("Dog", "Cat", "Rabbit", "Snake", "Kangaroo", "Monkey", "Hamster", "Panda", "Rat", "Alligator", "Tiger", "Leopard", "Parrot", "Llama", "Turtle", "Goldfish", "Duck");
        VBox root2 = new VBox(10);
        root2.setPadding(new Insets(20, 20, 20, 20));
        root2.setAlignment(Pos.TOP_CENTER);

        //create horizontal boxes for the bike and owner details
        HBox animalDetails = new HBox(10);
        HBox ownerDetails = new HBox(10);
        HBox boxDetailes = new HBox(50);
        boxDetailes.setAlignment(Pos.CENTER);
        // add components to HBoxes
        animalDetails.getChildren().addAll(box, breedLabel, breedField, animalNameLabel, animalNameField, animalGenderLabel, animalGenderField, animalColourLabel, animalColourField, animalIssueLabel, animalIssueField, ageLabel, ageField, weightlLabel, weightField);

        ownerDetails.getChildren().addAll(nameLabel, nameField, surnameLabel, surnameField, addressLabel, addressField, postcodeLabel, postcodeField);

        boxDetailes.getChildren().addAll(addButton, storeButton, clearButton);
        // create VBox
        VBox root = new VBox(10);
        root.getChildren().addAll(headingLabel, sectSeparator, patientLabel, animalDetails, sectSeparator2,
                ownerLabel, ownerDetails, sectSeparator3, displayAnimals, sectSeparator4, boxDetailes);
        // create the scene
        Scene scene = new Scene(root, Color.web("#adf79c"));

        // set font of heading
        Font font = new Font("Vedana", 40);
        headingLabel.setFont(font);
        font = new Font("Vedana", 20);
        patientLabel.setFont(font);
        ownerLabel.setFont(font);

        // set alignment of HBoxes
        animalDetails.setAlignment(Pos.CENTER);
        ownerDetails.setAlignment(Pos.CENTER);
        addButton.setAlignment(Pos.CENTER);
        storeButton.setAlignment(Pos.CENTER_RIGHT);
        clearButton.setAlignment(Pos.CENTER);

        // set alignment and Colour of  VBox 
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.EMPTY);
        // set minimum and maximum width of components 

        displayAnimals.setMaxSize(400, 700);
        displayAnimals.appendText(animalList.displayWaitingList());

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        // call private methods for button event handlers
        addButton.setOnAction(e -> addHandler());

        stage.setScene(scene);
        stage.setTitle("Animal Centre");
        stage.show();

        storeButton.setOnAction(e -> storeAnimalList());

        stage.setScene(scene);
        stage.setTitle("Animal Centre");
        stage.show();

        clearButton.setOnAction(e -> clearPatients());

        stage.setScene(scene);
        stage.setTitle("Animal Centre");
        stage.show();
    }

    /*
method to add a Animal
you should be able to create more methods
to remove and search for Animal
and set a Animal in waiting List    
     */
    /**
     *
     */
    private void addHandler() {
        String animalType = box.getValue()==null?"":box.getValue();
        String animalBreed = breedField.getText();
        String animalName = animalNameField.getText();
        String animalGender = animalGenderField.getText();
        String animalColour = animalColourField.getText();
        String animalIssue = animalIssueField.getText();
        String animalAge = ageField.getText();
        String animalWeight = weightField.getText();
        String givenName = nameField.getText();
        String surname = surnameField.getText();
        String address = addressField.getText();
        String postcode = postcodeField.getText();
        String storeMessage;
        // check for errors
        if (animalType.length() == 0 || animalBreed.length() == 0 || !isNumeric(animalAge) || !isNumeric(animalWeight)) {
            displayAnimals.setText("You must enter the correct details of the animal");
        } else if (givenName.length() == 0 || surname.length() == 0) {
            displayAnimals.setText("You must enter both your given name and surname");
        } else // ok to add a Tenant
        {
            Person owner = new Person(givenName, surname, address, postcode);
            Animal animalToAdd = new Animal(animalType, animalBreed, animalName, animalGender, animalColour, animalIssue, Double.parseDouble(animalAge), Double.parseDouble(animalWeight), owner);
            storeMessage = animalList.addAnimal(animalToAdd);
            //clear the fields
            breedField.setText("");
            ageField.setText("");
            animalNameField.setText("");
            animalGenderField.setText("");
            animalColourField.setText("");
            animalIssueField.setText("");
            weightField.setText("");
            nameField.setText("");
            surnameField.setText("");
            addressField.setText("");
            postcodeField.setText("");
            displayAnimals.setText("");
            //displayAnimals.appendText(storeMessage);
            displayAnimals.appendText(animalName + " successfully added");
            displayAnimals.appendText("\n\nThe animal waiting to be seen");
            displayAnimals.appendText(animalList.displayWaitingList());
        }

    }

    /**
     * modified from https://www.baeldung.com/java-check-string-number
     *
     * @param strNum -takes in string to test whether it can be converted to a
     * double
     * @return
     */
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * This section will Serialization the data.
     *
     * @Serialization
     */
    private void storeAnimalList() {
        try {
            FileOutputStream fileOut = new FileOutputStream("./storeAnimalList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animalList);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./storeAnimalList.ser file");
        } catch (IOException myException) {
            myException.printStackTrace();
        }

    }

    /**
     * This section will De-serialization
     *
     * @Deserialization
     */
    private boolean showPatientsList() {
        Object obj;
        try {
            FileInputStream fileIn = new FileInputStream("./storeAnimalList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            //read the information in as a object
            obj = in.readObject();
            //cast the object as an Animal
            animalList = (WaitingList) obj;
            in.close();
            fileIn.close();
            animalList.displayWaitingList();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        } catch (ClassNotFoundException c) {
            System.out.println("AnimalStore class not found");
            c.printStackTrace();
            return false;
        }
    }

    /**
     * This section of the will clear the text.
     */
    private void clearPatients() {
        breedField.setText("");
        ageField.setText("");
        animalNameField.setText("");
        animalGenderField.setText("");
        animalColourField.setText("");
        animalIssueField.setText("");
        weightField.setText("");
        nameField.setText("");
        surnameField.setText("");
        addressField.setText("");
        postcodeField.setText("");
        displayAnimals.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
