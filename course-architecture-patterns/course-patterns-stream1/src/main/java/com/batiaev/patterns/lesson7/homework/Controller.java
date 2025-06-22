package com.batiaev.patterns.lesson7.homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Application implements Initializable {

    private Person person;


    public Button getButton;
    public Button showButton;
    public TextField nameField;
    public Text welcomeLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        person = new Person();
        getButton.setOnAction(e -> person.setName(nameField.getText()));
        showButton.setOnAction(e -> welcomeLabel.setText("Welcome " + person.getName()));
    }
}

