/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg2020130001.nicholas.inventori;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXML_DataController implements Initializable {

    @FXML
    private MenuItem MenuPlayerStatus;
    @FXML
    private MenuItem MenuPlayerEquipment;
    @FXML
    private MenuItem MenuInventory;
    @FXML
    private MenuItem MenuEquipment;
    @FXML
    private MenuItem MenuBack;
    @FXML
    private TableView<Player_Status_Model> TableData;
    @FXML
    private Button ButtonFirst;
    @FXML
    private Button ButtonBefore;
    @FXML
    private Button ButtonAfter;
    @FXML
    private Button ButtonLast;
    @FXML
    private Button ButtonErase;
    @FXML
    private Button ButtonEdit;
    @FXML
    private Button ButtonAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showData();
    }    

    public void showData() {
        ObservableList<Player_Status_Model> data = FXMLDocumentController.dtplayerstatus.Load();
        if (data != null) {
            TableData.getColumns().clear();
            TableData.getItems().clear();
            TableColumn col = new TableColumn("Player_ID"); //nama kolom
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Playerid")); //nama yg di model
            TableData.getColumns().addAll(col);
            col = new TableColumn("Plyaer_Equip_ID");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Playerequipid"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Name");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("nama"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Strength");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Strength"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Intelligence");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Intelligence"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Vitality");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Vitality"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Agility");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Agility"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Dexterity");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Dexterity"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Lucky");
            col.setCellValueFactory(new PropertyValueFactory<Player_Status_Model, String>("Lucky"));
            TableData.getColumns().addAll(col);
            TableData.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            //TableData.getScene().getWindow().hide();
        }
    }
    
    @FXML
    private void PlayerStatusKlik(ActionEvent event) {
        showData();
    }

    @FXML
    private void PlayerEquipmentKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DataPlayerEquipment.fxml"));
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
    private void InventoryKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DataInventory.fxml"));
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
    private void EquipmentKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DataEquipment.fxml"));
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
    private void BackKlik(ActionEvent event) {
        ButtonAdd.getScene().getWindow().hide();
    }

    @FXML
    private void FirstKlik(ActionEvent event) {
        TableData.getSelectionModel().selectFirst();
        TableData.requestFocus();
    }

    @FXML
    private void BeforeKlik(ActionEvent event) {
        TableData.getSelectionModel().selectAboveCell();
        TableData.requestFocus();
    }

    @FXML
    private void AfterKlik(ActionEvent event) {
        TableData.getSelectionModel().selectBelowCell();
        TableData.requestFocus();
    }

    @FXML
    private void LastKlik(ActionEvent event) {
        TableData.getSelectionModel().selectLast();
        TableData.requestFocus();
    }

    @FXML
    private void EraseKlik(ActionEvent event) {
        Player_Status_Model s = new Player_Status_Model();
        s = TableData.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtplayerstatus.delete(s.getPlayerid())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showData();
            FirstKlik(event);
        }
    }

    @FXML
    private void EditKlik(ActionEvent event) {
        Player_Status_Model s = new Player_Status_Model();
        s = TableData.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Input_Player_Status.fxml"));
            Parent root = (Parent) loader.load();
            FXML_Input_Player_StatusController isidt = (FXML_Input_Player_StatusController) loader.getController();
            isidt.execute(s);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
        FirstKlik(event);
    }

    @FXML
    private void AddKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Input_Player_Status.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showData();
        FirstKlik(event);
    }
    
}
