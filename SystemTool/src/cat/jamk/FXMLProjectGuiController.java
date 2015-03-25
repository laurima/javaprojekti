/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.jamk;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author lauri
 */
public class FXMLProjectGuiController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleButtonActionHome(ActionEvent event) {
        System.out.println("Etusivu!");
        label.setText("Hello World!");
    }
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("Sivu2!");
        label.setText("Hello World!");
    }
    @FXML
    private void handleButtonAction3(ActionEvent event) {
        System.out.println("sivu3!");
        label.setText("Hello World!");
    }
    
}
