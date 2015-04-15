/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

/**
 *
 * @author User
 */
public class Ympyräkaavio extends Application {
    
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Kokeilu"); //Nimeää kaavion
        stage.setWidth(500); //asettaa leveyden
        stage.setHeight(500);//asettaa korkeudenn
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("1", 13), //Nimeää lohkon ja asettaa määrän.
                new PieChart.Data("2", 25),
                new PieChart.Data("3", 10),
                new PieChart.Data("4", 22),
                new PieChart.Data("5", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Kokeilu");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
