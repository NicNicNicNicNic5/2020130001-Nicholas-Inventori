/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pkg2020130001.nicholas.inventori;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    int p = 0;
    public static DB_Player_Status dtplayerstatus = new DB_Player_Status();
    public static DB_Player_Equipment dtplayerequipment = new DB_Player_Equipment();
    public static DB_Inventory dtinventory = new DB_Inventory();
    public static DB_Equipment dtequipment = new DB_Equipment();
    
    private Label label;
    @FXML
    private Label LabelQuit;
    @FXML
    private Label LabelData;
    @FXML
    private Label LabelDemo;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LabelQuitKlik(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void LabelDataKlik(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Data.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void LabelDemoKlik(MouseEvent event) {
        
    }
    
}
