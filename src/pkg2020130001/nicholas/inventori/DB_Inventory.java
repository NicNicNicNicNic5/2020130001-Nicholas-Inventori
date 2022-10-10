/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */ 
package pkg2020130001.nicholas.inventori;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class DB_Inventory {
int p = 0;
    private Inventory_Model dt = new Inventory_Model();

    public Inventory_Model getInventory_Model() {
        return (dt);
    }

    public void setInventory_Model(Inventory_Model s) {
        dt = s;
    }

    public ObservableList<Inventory_Model> Load() {
        try {
            ObservableList<Inventory_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Inventory_ID, Equipment_ID, Possession, Place from inventory");
            int i = 1;
            while (rs.next()) {
                Inventory_Model d = new Inventory_Model();
                d.setInventoryid(rs.getString("Inventory_ID"));
                d.setEquipmentid(rs.getString("Equipment_ID"));
                d.setPossession(rs.getInt("Possession"));
                d.setPlace(rs.getInt("Place"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validasi(String nomor) {
        int val = 0;
        try {
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from inventory where Inventory_ID = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        koneksi con = new koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into inventory (Inventory_ID, Equipment_ID, Possession, Place) values (?,?,?,?)");
            con.preparedStatement.setString(1, getInventory_Model().getInventoryid());
            con.preparedStatement.setString(2, getInventory_Model().getEquipmentid());
            con.preparedStatement.setInt(3, getInventory_Model().getPossession());
            con.preparedStatement.setInt(4, getInventory_Model().getPlace());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean delete(String nomor) {
        boolean berhasil = false;
        koneksi con = new koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from inventory where Inventory_ID  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        koneksi con = new koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update inventory set Possession = ?, Place = ?  where  Inventory_ID = ? and Equipment_ID = ?; ");
            con.preparedStatement.setInt(1, getInventory_Model().getPossession());
            con.preparedStatement.setInt(2, getInventory_Model().getPlace());
            con.preparedStatement.setString(3, getInventory_Model().getInventoryid());
            con.preparedStatement.setString(4, getInventory_Model().getEquipmentid());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
    
    public ObservableList<Inventory_Model> LookUp(String fld, String dt) {
        try {
            ObservableList<Inventory_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Inventory_ID, Equipment_ID, Possession, Place from inventory where " + fld + " like '%" + dt + "%'");
            int i = 1;
            while (rs.next()) {
                Inventory_Model d = new Inventory_Model();
                d.setInventoryid(rs.getString("Inventory_ID"));
                d.setEquipmentid(rs.getString("Equipment_ID"));
                d.setPossession(rs.getInt("Possession"));
                d.setPlace(rs.getInt("Place"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) {
        // TODO code application logic here
    }
}
