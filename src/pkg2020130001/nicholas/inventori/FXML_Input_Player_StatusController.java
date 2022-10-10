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
public class FXML_Input_Player_StatusController implements Initializable {

    @FXML
    private TextField text_name;
    @FXML
    private TextField text_dexterity;
    @FXML
    private TextField text_agility;
    @FXML
    private TextField text_intelligence;
    @FXML
    private TextField text_vitality;
    @FXML
    private TextField text_strength;
    @FXML
    private Button button_create;
    @FXML
    private Button button_reset;
    @FXML
    private Button button_back;
    @FXML
    private TextField text_player_id;
    @FXML
    private TextField text_player_equip_id;
    @FXML
    private TextField text_lucky;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    boolean editdata = false;

    public void execute(Player_Status_Model d) {
        if (!d.getPlayerid().isEmpty()) {
            editdata = true;
            text_player_id.setText(d.getPlayerid());
            text_player_equip_id.setText(d.getPlayerequipid());
            text_name.setText(d.getNama());
            text_strength.setText(String.valueOf(d.getStrength()));
            text_intelligence.setText(String.valueOf(d.getIntelligence()));
            text_vitality.setText(String.valueOf(d.getVitality()));
            text_agility.setText(String.valueOf(d.getAgility()));
            text_dexterity.setText(String.valueOf(d.getDexterity()));
            text_lucky.setText(String.valueOf(d.getLucky()));
            text_player_id.setEditable(false);
            text_player_equip_id.setEditable(false);
            text_player_id.requestFocus();
        }
    }

    @FXML
    private void button_create_klik(ActionEvent event) {
        Player_Status_Model s = new Player_Status_Model();
        s.setPlayerid(text_player_id.getText());
        s.setPlayerequipid(text_player_equip_id.getText());
        s.setNama(text_name.getText());
        s.setStrength(Integer.parseInt(text_strength.getText()));
        s.setIntelligence(Integer.parseInt(text_intelligence.getText()));
        s.setVitality(Integer.parseInt(text_vitality.getText()));
        s.setAgility(Integer.parseInt(text_agility.getText()));
        s.setDexterity(Integer.parseInt(text_dexterity.getText()));
        s.setLucky(Integer.parseInt(text_lucky.getText()));
        //System.out.print("\n" + s.getPlayerid() + "\n"); //test
        FXMLDocumentController.dtplayerstatus.setPlayer_Status_Model(s);
        //System.out.print(FXMLDocumentController.dtplayerstatus.validasi("test")); //test
        if (editdata) {
            if (FXMLDocumentController.dtplayerstatus.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                text_player_id.setEditable(true);
                button_reset_klik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtplayerstatus.validasi(s.getPlayerid()) <= 0) 
        {
            if (FXMLDocumentController.dtplayerstatus.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                button_reset_klik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            text_player_id.requestFocus();
        }
    }

    @FXML
    private void button_reset_klik(ActionEvent event) {
        text_player_id.setText("");
        text_player_equip_id.setText("");
        text_name.setText("");
        text_strength.setText("");
        text_intelligence.setText("");
        text_vitality.setText("");
        text_agility.setText("");
        text_dexterity.setText("");
        text_lucky.setText("");
        text_player_id.requestFocus();
    }

    @FXML
    private void button_back_klik(ActionEvent event) {
        button_back.getScene().getWindow().hide();
    }

}
