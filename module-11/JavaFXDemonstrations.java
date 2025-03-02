package com.mycompany.javafx_project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

/*
Truman Forey - 3/2/25 - CSD 402 Assignment 11.2 - Companion Code

This program is a companion piece to the paper written for this
assignment, demonstrating the various functions of JavaFX.
This code is meant to be basic practice and experimentation
with JavaFX in general, and the HBox and VBox CLasses
specifically. This program is not meant to accomplish
anything specific on the user end.
 */
public class JavaFXDemonstrations extends Application {

    @Override
    public void start(Stage stage) {
        var demo1 = new Label("Demo 1");
        var demo2 = new Label("Demo 2");

        //////////////////////// DEMONSTRATION 1 ////////////////////////
        var label_h = new Label("Demonstrating HBox.");
        var label_v = new Label("Demonstrating VBox.");
        
        var label_demo1_1 = new Label("This is a basic example.");
        var label_demo1_2 = new Label("HBoxes and VBoxes can be used together.");
        
        HBox hbox_1 = new HBox();
        VBox vbox_1 = new VBox();
        hbox_1.getChildren().add(demo1);
        hbox_1.getChildren().add(label_h);
        vbox_1.getChildren().add(label_v);

        vbox_1.getChildren().add(label_demo1_1);
        vbox_1.getChildren().add(label_demo1_2);
        
        hbox_1.getChildren().add(new Button("Test"));
        hbox_1.getChildren().add(vbox_1);
        
        Scene demo1_scene = new Scene(hbox_1, 800, 300);
        stage.setScene(demo1_scene);
        stage.show();
        
        //////////////////////// DEMONSTRATION 2 ////////////////////////
        VBox vbox_2 = new VBox(10);
        
        vbox_2.setAlignment(Pos.CENTER);
        vbox_2.getChildren().add(demo2);
        for (int j = 0; j < 6; j++) {
            vbox_2.getChildren().add(new Button(" Item #" + (int)(j + 1)));
        }
        
        Scene demo2_scene = new Scene(vbox_2, 300, 450);
        stage.setScene(demo2_scene);
        stage.show();
        
        //////////////////////// DEMONSTRATION 3 ////////////////////////
        VBox vboxContainer = new VBox();
        vboxContainer.setAlignment(Pos.CENTER);
        
        HBox hboxLane1 = new HBox();
        hboxLane1.setAlignment(Pos.CENTER);
        HBox hboxLane2 = new HBox();
        hboxLane2.setAlignment(Pos.CENTER);
        HBox hboxLane3 = new HBox();
        hboxLane3.setAlignment(Pos.CENTER);
        HBox hboxLane4 = new HBox();
        hboxLane4.setAlignment(Pos.CENTER);
        HBox hboxLane5 = new HBox();
        hboxLane5.setAlignment(Pos.CENTER);
        HBox hboxLane6 = new HBox();
        hboxLane6.setAlignment(Pos.CENTER);
        HBox hboxLane7 = new HBox();
        hboxLane7.setAlignment(Pos.CENTER);
        HBox hboxLane8 = new HBox();
        hboxLane8.setAlignment(Pos.CENTER);
        
        hboxLane1.getChildren().add(new Label("   "));
        hboxLane1.getChildren().add(new Label("   "));
        hboxLane1.getChildren().add(new Label("   "));
        hboxLane1.getChildren().add(new Label("   "));
        hboxLane1.getChildren().add(new Label("+"));
        hboxLane1.getChildren().add(new Label("+"));
        hboxLane1.getChildren().add(new Label("+"));
        hboxLane1.getChildren().add(new Label("   "));
        
        hboxLane2.getChildren().add(new Label("+"));
        hboxLane2.getChildren().add(new Label("+"));
        hboxLane2.getChildren().add(new Label("   "));
        hboxLane2.getChildren().add(new Label("   "));
        hboxLane2.getChildren().add(new Label("+"));
        hboxLane2.getChildren().add(new Label("   "));
        hboxLane2.getChildren().add(new Label("+"));
        hboxLane2.getChildren().add(new Label("   "));
        
        hboxLane3.getChildren().add(new Label("   "));
        hboxLane3.getChildren().add(new Label("+"));
        hboxLane3.getChildren().add(new Label("   "));
        hboxLane3.getChildren().add(new Label("   "));
        hboxLane3.getChildren().add(new Label("+"));
        hboxLane3.getChildren().add(new Label("   "));
        hboxLane3.getChildren().add(new Label("+"));
        hboxLane3.getChildren().add(new Label("   "));
        
        hboxLane4.getChildren().add(new Label("   "));
        hboxLane4.getChildren().add(new Label("+"));
        hboxLane4.getChildren().add(new Label("   "));
        hboxLane4.getChildren().add(new Label("   "));
        hboxLane4.getChildren().add(new Label("+"));
        hboxLane4.getChildren().add(new Label("   "));
        hboxLane4.getChildren().add(new Label("+"));
        hboxLane4.getChildren().add(new Label("+"));
        
        hboxLane5.getChildren().add(new Label("   "));
        hboxLane5.getChildren().add(new Label("+"));
        hboxLane5.getChildren().add(new Label("+"));
        hboxLane5.getChildren().add(new Label("   "));
        hboxLane5.getChildren().add(new Label("+"));
        hboxLane5.getChildren().add(new Label("   "));
        hboxLane5.getChildren().add(new Label("   "));
        hboxLane5.getChildren().add(new Label("   "));
        
        hboxLane6.getChildren().add(new Label("   "));
        hboxLane6.getChildren().add(new Label("   "));
        hboxLane6.getChildren().add(new Label("+"));
        hboxLane6.getChildren().add(new Label("   "));
        hboxLane6.getChildren().add(new Label("+"));
        hboxLane6.getChildren().add(new Label("   "));
        hboxLane6.getChildren().add(new Label("   "));
        hboxLane6.getChildren().add(new Label("   "));
        
        hboxLane7.getChildren().add(new Label("   "));
        hboxLane7.getChildren().add(new Label("   "));
        hboxLane7.getChildren().add(new Label("+"));
        hboxLane7.getChildren().add(new Label("+"));
        hboxLane7.getChildren().add(new Label("+"));
        hboxLane7.getChildren().add(new Label("   "));
        hboxLane7.getChildren().add(new Label("   "));
        hboxLane7.getChildren().add(new Label("   "));
        
        hboxLane8.getChildren().add(new Label("   "));
        hboxLane8.getChildren().add(new Label("   "));
        hboxLane8.getChildren().add(new Label("   "));
        hboxLane8.getChildren().add(new Label("   "));
        hboxLane8.getChildren().add(new Label("   "));
        hboxLane8.getChildren().add(new Label("   "));
        hboxLane8.getChildren().add(new Label("   "));
        hboxLane8.getChildren().add(new Label("   "));
        
        vboxContainer.getChildren().add(hboxLane1);
        vboxContainer.getChildren().add(hboxLane2);
        vboxContainer.getChildren().add(hboxLane3);
        vboxContainer.getChildren().add(hboxLane4);
        vboxContainer.getChildren().add(hboxLane5);
        vboxContainer.getChildren().add(hboxLane6);
        vboxContainer.getChildren().add(hboxLane7);
        vboxContainer.getChildren().add(hboxLane8);

        Scene demo3_scene = new Scene(vboxContainer, 600, 600);
        stage.setScene(demo3_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}