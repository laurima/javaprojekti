/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

/**
 *
 * @author Laurin
 */
public class DataUpdates {
    
    String cpufrequency, cpuload, freeram, cdiskfree;

    public DataUpdates(String cpufrequency, String cpuload, String freeram, String cdiskfree) {
        this.cpufrequency = cpufrequency;
        this.cpuload = cpuload;
        this.freeram = freeram;
        this.cdiskfree = cdiskfree;
    }

    public String getCpuload() {
        Cpu cpu = new Cpu();
        this.cpuload = Integer.toString(cpu.getCpuLoad());
        return cpuload;
    }

    public String getCpufrequency() {
        Cpu cpu = new Cpu();
        this.cpufrequency = Long.toString(cpu.getFrequency());
        return cpufrequency;
    }


    public String getFreeram() {
        Ram ram = new Ram();
        this.freeram = Float.toString(ram.getFreeRam());
        return freeram;
    }


    public String getCdiskfree() {
        Disk disk = new Disk();
        this.cdiskfree = Long.toString(disk.getUsableSpace());
        return cdiskfree;
    }
    
    
    
    }//main
    

