/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pkg2020130001.nicholas.inventori;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button ButtonCharacter;
    @FXML
    private Button ButtonEquip;
    @FXML
    private Button ButtonInventory;
    @FXML
    private Button ButtonQuit;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CharacterKlik(ActionEvent event) {
    }

    @FXML
    private void EquipKlik(ActionEvent event) {
    }

    @FXML
    private void InventoryKlik(ActionEvent event) {
    }

    @FXML
    private void QuitKlik(ActionEvent event) {
        System.exit(0);
    }
    
}
