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
public class FXML_DataInventoryController implements Initializable {

    @FXML
    private Button ButtonAdd;
    @FXML
    private Button ButtonEdit;
    @FXML
    private Button ButtonErase;
    @FXML
    private Button ButtonLast;
    @FXML
    private Button ButtonAfter;
    @FXML
    private Button ButtonBefore;
    @FXML
    private Button ButtonFirst;
    @FXML
    private TableView<Inventory_Model> TableData;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showData();
    }    
    
    public void showData() {
        ObservableList<Inventory_Model> data = FXMLDocumentController.dtinventory.Load();
        if (data != null) {
            TableData.getColumns().clear();
            TableData.getItems().clear();
            TableColumn col = new TableColumn("Inventory_ID");
            col.setCellValueFactory(new PropertyValueFactory<Inventory_Model, String>("inventoryid"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Equipment_ID");
            col.setCellValueFactory(new PropertyValueFactory<Inventory_Model, String>("equipmentid"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Possession");
            col.setCellValueFactory(new PropertyValueFactory<Inventory_Model, String>("possession"));
            TableData.getColumns().addAll(col);
            col = new TableColumn("Place");
            col.setCellValueFactory(new PropertyValueFactory<Inventory_Model, String>("place"));
            TableData.getColumns().addAll(col);
            TableData.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            TableData.getScene().getWindow().hide();
        }
    }

    @FXML
    private void AddKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Input_Inventory.fxml"));
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

    @FXML
    private void EditKlik(ActionEvent event) {
        Inventory_Model s = new Inventory_Model();
        s = TableData.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Input_Inventory.fxml"));
            Parent root = (Parent) loader.load();
            FXML_Input_InventoryController isidt = (FXML_Input_InventoryController) loader.getController();
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
    private void EraseKlik(ActionEvent event) {
        Inventory_Model s = new Inventory_Model();
        s = TableData.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtinventory.delete(s.getInventoryid())) {
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
    private void LastKlik(ActionEvent event) {
        TableData.getSelectionModel().selectLast();
        TableData.requestFocus();
    }

    @FXML
    private void AfterKlik(ActionEvent event) {
        TableData.getSelectionModel().selectBelowCell();
        TableData.requestFocus();
    }

    @FXML
    private void BeforeKlik(ActionEvent event) {
        TableData.getSelectionModel().selectAboveCell();
        TableData.requestFocus();
    }

    @FXML
    private void FirstKlik(ActionEvent event) {
        TableData.getSelectionModel().selectFirst();
        TableData.requestFocus();
    }

    @FXML
    private void PlayerStatusKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DataPlayerStatus.fxml"));
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
        showData();
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
    
}
