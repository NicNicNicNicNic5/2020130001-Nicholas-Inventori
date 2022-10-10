/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg2020130001.nicholas.inventori;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXML_Input_InventoryController implements Initializable {
int p = 0;
    @FXML
    private Button ButtonBack;
    @FXML
    private Button ButtonReset;
    @FXML
    private Button ButtonCreate;
    @FXML
    private TextField text_Possession;
    @FXML
    private TextField text_Place;
    @FXML
    private TextField text_EquipmentID;
    @FXML
    private TextField text_InventoryID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    boolean editdata = false;

    public void execute(Inventory_Model d) {
        if (!d.getInventoryid().isEmpty()) {
            editdata = true;
            text_InventoryID.setText(d.getInventoryid());
            text_EquipmentID.setText(d.getEquipmentid());
            text_Possession.setText(String.valueOf(d.getPossession()));
            text_Place.setText(String.valueOf(d.getPlace()));
            text_InventoryID.setEditable(false);
            text_InventoryID.requestFocus();
        }
    }

    @FXML
    private void BackKlik(ActionEvent event) {
        ButtonBack.getScene().getWindow().hide();
    }

    @FXML
    private void ResetKlik(ActionEvent event) {
        text_InventoryID.setText("");
        text_EquipmentID.setText("");
        text_Possession.setText("");
        text_Place.setText("");
        text_InventoryID.requestFocus();
    }

    @FXML
    private void CreateKlik(ActionEvent event) {
        Inventory_Model s = new Inventory_Model();
        s.setInventoryid(text_InventoryID.getText());
        s.setEquipmentid(text_EquipmentID.getText());
        s.setPossession(Integer.parseInt(text_Possession.getText()));
        s.setPlace(Integer.parseInt(text_Place.getText()));
        FXMLDocumentController.dtinventory.setInventory_Model(s);
        if (editdata) {
            if (FXMLDocumentController.dtinventory.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                text_InventoryID.setEditable(true);
                ResetKlik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtinventory.validasi(s.getInventoryid()) <= 0) {
            if (FXMLDocumentController.dtinventory.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                ResetKlik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            text_InventoryID.requestFocus();
        }
    }
    
}
