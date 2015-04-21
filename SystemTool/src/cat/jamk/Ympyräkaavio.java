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

    public Ympyräkaavio() {
    }
    
    


    
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Kokeilu"); //Nimeää kaavion
        stage.setWidth(500); //asettaa leveyden
        stage.setHeight(500);//asettaa korkeudenn
        
        
        
                
               
       /* final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Cpu");

        ((Group) scene.getRoot()).getChildren().add(chart);
                
        stage.setScene(scene);
        stage.show();
               */
    }
    
    public void addData(){
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
       );
                
               
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Cpu");
        Processes processes = new Processes();
        String result[] = new String[processes.countProcesses()];
        String usage[] = new String[processes.countProcesses()];
        result = processes.getProcesses();

        for (int i = 0; i < processes.getProcesses().length; i++) {
        usage[i] = processes.getProcessMemUsage(result[i]);
        } 
        for (int k = 0; k<processes.getProcesses().length; k++) {
        pieChartData.add(new PieChart.Data(result[k], Double.parseDouble(usage[k])));
        }
    }
}
