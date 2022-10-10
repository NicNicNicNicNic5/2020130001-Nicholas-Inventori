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
public class FXML_Input_Player_EquipmentController implements Initializable {
int p = 0;
    @FXML
    private TextField text_PlayerEquipID;
    @FXML
    private TextField text_InventoryID;
    @FXML
    private TextField text_SubWeapon;
    @FXML
    private TextField text_MainWeapon;
    @FXML
    private TextField text_Armor;
    @FXML
    private TextField text_Glove;
    @FXML
    private TextField text_Shoe;
    @FXML
    private Button ButtonCreate;
    @FXML
    private Button ButtonReset;
    @FXML
    private Button ButtonBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    boolean editdata = false;

    public void execute(Player_Equipment_Model d) {
        if (!d.getPlayerequipid().isEmpty()) {
            editdata = true;
            text_PlayerEquipID.setText(d.getPlayerequipid());
            text_InventoryID.setText(d.getInventoryid());
            text_MainWeapon.setText(d.getMainweapon());
            text_SubWeapon.setText(d.getSubweapon());
            text_Armor.setText(d.getArmor());
            text_Glove.setText(d.getGlove());
            text_Shoe.setText(d.getShoe());
            text_PlayerEquipID.setEditable(false);
            text_PlayerEquipID.requestFocus();
        }
    }

    @FXML
    private void CreateKlik(ActionEvent event) {
        Player_Equipment_Model s = new Player_Equipment_Model();
        s.setPlayerequipid(text_PlayerEquipID.getText());
        s.setInventoryid(text_InventoryID.getText());
        s.setMainweapon(text_MainWeapon.getText());
        s.setSubweapon(text_SubWeapon.getText());
        s.setArmor(text_Armor.getText());
        s.setGlove(text_Glove.getText());
        s.setShoe(text_Shoe.getText());
        FXMLDocumentController.dtplayerequipment.setPlayerEquipmentModel(s);
        if (editdata) {
            if (FXMLDocumentController.dtplayerequipment.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                text_PlayerEquipID.setEditable(true);
                ResetKlik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtplayerequipment.validasi(s.getPlayerequipid()) <= 0) {
            if (FXMLDocumentController.dtplayerequipment.insert()) {
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
            text_PlayerEquipID.requestFocus();
        }
    }

    @FXML
    private void ResetKlik(ActionEvent event) {
        text_PlayerEquipID.setText("");
        text_InventoryID.setText("");
        text_MainWeapon.setText("");
        text_SubWeapon.setText("");
        text_Armor.setText("");
        text_Glove.setText("");
        text_Shoe.setText("");
        text_PlayerEquipID.requestFocus();
    }

    @FXML
    private void BackKlik(ActionEvent event) {
        ButtonBack.getScene().getWindow().hide();
    }
    
}
