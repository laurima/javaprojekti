/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author lauri
 */
public class ProjektiGui extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // Default sulkemisoperaatio, tappaa threadit ikkunan sulkiessa        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {                
                System.exit(0);
            }
        });
    
        // Käyttäjän lisääminen
        userRegister();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLProjectGui.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
        // Threads
        VisualizationThread visual = new VisualizationThread("Visualization");
        AnalyzingThread analytics = new AnalyzingThread("Analyzation");
                
        visual.start();
        analytics.start();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    

    // Tsekataan onko käyttäjä jo databasessa ja jos ei niin lisätään.
    private void userRegister() {
        MysqlHandler handler = new MysqlHandler();        
        if (handler.isConnection()) {
            Network nw = new Network();
            if (!(nw.getMacAddress().equals(""))) {
                if (!(handler.isUserInDB(nw.getMacAddress()))) {
                    OperatingSystem os = new OperatingSystem();
                    handler.insertNewUser(nw.getMacAddress(), nw.getComputerName(), os.getUsername(), os.getUserCountry(), os.getUserLanguage());
                }
            }
        }
    }
}
