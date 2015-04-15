/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Vaakakaavio extends Application {
     final static String austria = "Austria"; //Nimetään osiot
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";
    final static String japan="Japan";
 
    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample"); //ikkunan nimi
        final NumberAxis xAxis = new NumberAxis(); //määritellään x ja ykselit
        final CategoryAxis yAxis = new CategoryAxis(); //määritellään x ja ykselit
        final BarChart<Number,String> bc = 
            new BarChart<>(xAxis,yAxis);
        bc.setTitle("Country Summary"); // kaavion otsikko
        xAxis.setLabel("Value");  //asteikon nimi
        xAxis.setTickLabelRotation(90); //rotaatio
        yAxis.setLabel("Country");  //sivuotsikko  
 
        XYChart.Series series1 = new XYChart.Series(); //uusi osa
        series1.setName("2003");     //osan nimi  
        series1.getData().add(new XYChart.Data(25601.34, austria)); //pylvään nimi ja arvo
        series1.getData().add(new XYChart.Data(20148.82, brazil));//pylvään nimi ja arvo
        series1.getData().add(new XYChart.Data(10000, france));//pylvään nimi ja arvo
        series1.getData().add(new XYChart.Data(35407.15, italy));//pylvään nimi ja arvo
        series1.getData().add(new XYChart.Data(12000, usa)); //pylvään nimi ja arvo
         series1.getData().add(new XYChart.Data(16000, japan));  //pylvään nimi ja arvo
      
      
       
        
        
        XYChart.Series series2 = new XYChart.Series(); //toinen osa
        series2.setName("2004"); //osan nimi
        series2.getData().add(new XYChart.Data(57401.85, austria)); //pylvään nimi ja arvo
        series2.getData().add(new XYChart.Data(41941.19, brazil));//pylvään nimi ja arvo
        series2.getData().add(new XYChart.Data(45263.37, france));//pylvään nimi ja arvo
        series2.getData().add(new XYChart.Data(117320.16, italy));//pylvään nimi ja arvo
        series2.getData().add(new XYChart.Data(14845.27, usa)); //pylvään nimi ja arvo
         series2.getData().add(new XYChart.Data(15000, japan));  //pylvään nimi ja arvo
      
        
        XYChart.Series series3 = new XYChart.Series(); //kolmas osa
        series3.setName("2005"); //osan nimi
        series3.getData().add(new XYChart.Data(45000.65, austria)); //pylvään nimi ja arvo
        series3.getData().add(new XYChart.Data(44835.76, brazil));//pylvään nimi ja arvo
        series3.getData().add(new XYChart.Data(18722.18, france));//pylvään nimi ja arvo
        series3.getData().add(new XYChart.Data(17557.31, italy));//pylvään nimi ja arvo
        series3.getData().add(new XYChart.Data(92633.68, usa));  //pylvään nimi ja arvo
           series3.getData().add(new XYChart.Data(16000, japan));  //pylvään nimi ja arvo
      
        
        Scene scene  = new Scene(bc,800,600); //määrittää koon
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
    
