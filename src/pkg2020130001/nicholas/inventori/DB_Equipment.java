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
public class DB_Equipment {

    private Equipment_Model dt = new Equipment_Model();

    public Equipment_Model getEquipment_Model() {
        return (dt);
    }

    public void setEquipment_Model(Equipment_Model s) {
        dt = s;
    }
    
    public ObservableList<Equipment_Model> Load() {
        try {
            ObservableList<Equipment_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Equipment_ID, Inventory_ID, Name, Strength, Intelligence, Vitality, Agility, Dexterity, Lucky, Enhancement from equipment");
            int i = 1;
            while (rs.next()) {
                Equipment_Model d = new Equipment_Model();
                d.setEquipmentid(rs.getString("Equipment_ID"));
                d.setInventoryid(rs.getString("Inventory_ID"));
                d.setName(rs.getString("Name"));
                d.setStrength(rs.getInt("Strength"));
                d.setIntelligence(rs.getInt("Intelligence"));
                d.setVitality(rs.getInt("Agility"));
                d.setAgility(rs.getInt("Agility"));
                d.setDexterity(rs.getInt("Dexterity"));
                d.setLucky(rs.getInt("Lucky"));
                d.setEnhancement(rs.getString("Enhancement"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from equipment where Equipment_ID = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into equipment (Equipment_ID, Inventory_ID, Name, Strength, Intelligence, Vitality, Agility, Dexterity, Lucky, Enhancement) values (?,?,?,?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getEquipment_Model().getEquipmentid());
            con.preparedStatement.setString(2, getEquipment_Model().getInventoryid());
            con.preparedStatement.setString(3, getEquipment_Model().getName());
            con.preparedStatement.setInt(4, getEquipment_Model().getStrength());
            con.preparedStatement.setInt(5, getEquipment_Model().getIntelligence());
            con.preparedStatement.setInt(6, getEquipment_Model().getVitality());
            con.preparedStatement.setInt(7, getEquipment_Model().getAgility());
            con.preparedStatement.setInt(8, getEquipment_Model().getDexterity());
            con.preparedStatement.setInt(9, getEquipment_Model().getLucky());
            con.preparedStatement.setString(10, getEquipment_Model().getEnhancement());
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
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from equipment where Equipment_ID = ? ");
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
                    "update equipment set Name = ?, Strength = ?, Intelligence = ?, Vitality = ?, Agility = ?, Dexterity = ?, Lucky = ?, Enhancement = ? where  Equipment_ID = ? and Inventory_ID = ?; ");
            con.preparedStatement.setString(1, getEquipment_Model().getName());
            con.preparedStatement.setInt(2, getEquipment_Model().getStrength());
            con.preparedStatement.setInt(3, getEquipment_Model().getIntelligence());
            con.preparedStatement.setInt(4, getEquipment_Model().getVitality());
            con.preparedStatement.setInt(5, getEquipment_Model().getAgility());
            con.preparedStatement.setInt(6, getEquipment_Model().getDexterity());
            con.preparedStatement.setInt(7, getEquipment_Model().getLucky());
            con.preparedStatement.setString(8, getEquipment_Model().getEnhancement());
            con.preparedStatement.setString(9, getEquipment_Model().getEquipmentid());
            con.preparedStatement.setString(10, getEquipment_Model().getInventoryid());
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
    
    public ObservableList<Equipment_Model> LookUp(String fld, String dt) {
        try {
            ObservableList<Equipment_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Equipment_ID, Inventory_ID, Name, Strength, Intelligence, Vitality, Agility, Dexterity, Lucky, Enhancement from equipment where " + fld + " like '%" + dt + "%'");
            int i = 1;
            while (rs.next()) {
                Equipment_Model d = new Equipment_Model();
                d.setEquipmentid(rs.getString("Equipment_ID"));
                d.setInventoryid(rs.getString("Inventory_ID"));
                d.setName(rs.getString("Name"));
                d.setStrength(rs.getInt("Strength"));
                d.setIntelligence(rs.getInt("Intellligence"));
                d.setVitality(rs.getInt("Vitality"));
                d.setAgility(rs.getInt("Agility"));
                d.setDexterity(rs.getInt("Dexterity"));
                d.setLucky(rs.getInt("Lucky"));
                d.setEnhancement(rs.getString("Enhancement"));
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
