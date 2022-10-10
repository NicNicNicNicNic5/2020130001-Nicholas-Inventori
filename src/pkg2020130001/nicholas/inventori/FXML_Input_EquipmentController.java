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
public class FXML_Input_EquipmentController implements Initializable {
int p = 0;
    @FXML
    private Button ButtonBack;
    @FXML
    private Button ButtonReset;
    @FXML
    private Button ButtonCreate;
    @FXML
    private TextField text_Dexterity;
    @FXML
    private TextField text_Agility;
    @FXML
    private TextField text_Vitality;
    @FXML
    private TextField text_Strength;
    @FXML
    private TextField text_Intelligence;
    @FXML
    private TextField text_InventoryID;
    @FXML
    private TextField text_EquipmentID;
    @FXML
    private TextField text_Name;
    @FXML
    private TextField text_Lucky;
    @FXML
    private TextField text_Enhancement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    boolean editdata = false;

    public void execute(Equipment_Model d) {
        if (!d.getEquipmentid().isEmpty()) {
            editdata = true;
            text_EquipmentID.setText(d.getEquipmentid());
            text_InventoryID.setText(d.getInventoryid());
            text_Name.setText(d.getName());
            text_Strength.setText(String.valueOf(d.getStrength()));
            text_Intelligence.setText(String.valueOf(d.getIntelligence()));
            text_Vitality.setText(String.valueOf(d.getVitality()));
            text_Agility.setText(String.valueOf(d.getAgility()));
            text_Dexterity.setText(String.valueOf(d.getDexterity()));
            text_Lucky.setText(String.valueOf(d.getLucky()));
            text_Enhancement.setText(d.getEnhancement());
            text_EquipmentID.setEditable(false);
            text_EquipmentID.requestFocus();
        }
    }

    @FXML
    private void BackKlik(ActionEvent event) {
        ButtonBack.getScene().getWindow().hide();
    }

    @FXML
    private void ResetKlik(ActionEvent event) {
        text_EquipmentID.setText("");
        text_InventoryID.setText("");
        text_Name.setText("");
        text_Strength.setText("");
        text_Intelligence.setText("");
        text_Vitality.setText("");
        text_Agility.setText("");
        text_Dexterity.setText("");
        text_Lucky.setText("");
        text_Enhancement.setText("");
        text_EquipmentID.requestFocus();
    }

    @FXML
    private void CreateKlik(ActionEvent event) {
        Equipment_Model s = new Equipment_Model();
        s.setEquipmentid(text_EquipmentID.getText());
        s.setInventoryid(text_InventoryID.getText());
        s.setName(text_Name.getText());
        s.setStrength(Integer.parseInt(text_Strength.getText()));
        s.setIntelligence(Integer.parseInt(text_Intelligence.getText()));
        s.setVitality(Integer.parseInt(text_Vitality.getText()));
        s.setAgility(Integer.parseInt(text_Agility.getText()));
        s.setDexterity(Integer.parseInt(text_Dexterity.getText()));
        s.setLucky(Integer.parseInt(text_Lucky.getText()));
        s.setEnhancement(text_Enhancement.getText());
        FXMLDocumentController.dtequipment.setEquipment_Model(s);
        if (editdata) {
            if (FXMLDocumentController.dtequipment.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                text_EquipmentID.setEditable(true);
                ResetKlik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtequipment.validasi(s.getEquipmentid()) <= 0) {
            if (FXMLDocumentController.dtequipment.insert()) {
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
            text_EquipmentID.requestFocus();
        }
    }

}
