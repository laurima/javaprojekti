/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Laurin
 */
public class CpuChart {
    
    Processes process = new Processes();
    
    List<String> list = new ArrayList<String>();
    int processcounter = process.countProcesses()+5;
    String result[] = new String[process.countProcesses()+5];
    int processusage[] = new int[process.countProcesses()+5];
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();   

    public CpuChart() {
    }

    public ObservableList<PieChart.Data> getPieChartData() {
        getCpuChartData();
        return pieChartData;
    }

    
    
    public void getCpuChartData(){
        for (int i = 0; i < this.processcounter; i++){
            pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data(result[i], this.processusage[i])
            );
                    }
    }
    
    public void updateProcessesList() {
        Processes processes = new Processes();       
        
        
        for (int i = 0; i < this.processcounter; i++) {
        this.result[i] = processes.getProcesses()[i];
        }
        for (int i = 0; i < processes.getProcesses().length; i++) {
        this.processusage[i] = Integer.valueOf(processes.getProcessMemUsage(this.result[i]));  
        }

        for (int g = 0; g < this.processcounter; g++) {
            this.list.add(this.processusage[g],this.result[g]);
        }
        
        }  
}

