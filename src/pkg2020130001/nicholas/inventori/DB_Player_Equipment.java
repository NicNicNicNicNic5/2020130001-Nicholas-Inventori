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
public class DB_Player_Equipment {
int p = 0;
    private Player_Equipment_Model dt = new Player_Equipment_Model();

    public Player_Equipment_Model getPlayerEquipmentModel() {
        return (dt);
    }

    public void setPlayerEquipmentModel(Player_Equipment_Model s) {
        dt = s;
    }

    public ObservableList<Player_Equipment_Model> Load() {
        try {
            ObservableList<Player_Equipment_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Player_Equip_ID, Inventory_ID, Main_Weapon, Sub_Weapon, Armor, Glove, Shoe from player_equipment");
            int i = 1;
            while (rs.next()) {
                Player_Equipment_Model d = new Player_Equipment_Model();
                d.setPlayerequipid(rs.getString("Player_Equip_ID"));
                d.setInventoryid(rs.getString("Inventory_ID"));
                d.setMainweapon(rs.getString("Main_Weapon"));
                d.setSubweapon(rs.getString("Sub_Weapon"));
                d.setArmor(rs.getString("Armor"));
                d.setGlove(rs.getString("Glove"));
                d.setShoe(rs.getString("Shoe"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from player_equipment where Player_Equip_ID = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into player_equipment (Player_Equip_ID, Inventory_ID, Main_Weapon, Sub_Weapon, Armor, Glove, Shoe) values (?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getPlayerEquipmentModel().getPlayerequipid());
            con.preparedStatement.setString(2, getPlayerEquipmentModel().getInventoryid());
            con.preparedStatement.setString(3, getPlayerEquipmentModel().getMainweapon());
            con.preparedStatement.setString(4, getPlayerEquipmentModel().getSubweapon());
            con.preparedStatement.setString(5, getPlayerEquipmentModel().getArmor());
            con.preparedStatement.setString(6, getPlayerEquipmentModel().getGlove());
            con.preparedStatement.setString(7, getPlayerEquipmentModel().getShoe());
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from player_equipment where Player_Equip_ID = ? ");
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
                    "update player_equipment set Main_Weapon = ?, Sub_Weapon = ?, Armor = ?, Glove = ?, Shoe = ?  where  Player_Equip_ID = ? and Inventory_ID = ?; ");
            con.preparedStatement.setString(1, getPlayerEquipmentModel().getMainweapon());
            con.preparedStatement.setString(2, getPlayerEquipmentModel().getSubweapon());
            con.preparedStatement.setString(3, getPlayerEquipmentModel().getArmor());
            con.preparedStatement.setString(4, getPlayerEquipmentModel().getGlove());
            con.preparedStatement.setString(5, getPlayerEquipmentModel().getShoe());
            con.preparedStatement.setString(6, getPlayerEquipmentModel().getPlayerequipid());
            con.preparedStatement.setString(7, getPlayerEquipmentModel().getInventoryid());
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
    
    public ObservableList<Player_Equipment_Model> LookUp(String fld, String dt) {
        try {
            ObservableList<Player_Equipment_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Player_Equip_ID, Inventory_ID, Main_Weapon, Sub_Weapon, Armor, Glove, Shoe from player_equipment where " + fld + " like '%" + dt + "%'");
            int i = 1;
            while (rs.next()) {
                Player_Equipment_Model d = new Player_Equipment_Model();
                d.setPlayerequipid(rs.getString("Player_Equip_ID"));
                d.setInventoryid(rs.getString("Inventory_ID"));
                d.setMainweapon(rs.getString("Main_Weapon"));
                d.setSubweapon(rs.getString("Sub_Weapon"));
                d.setArmor(rs.getString("Armor"));
                d.setGlove(rs.getString("Glove"));
                d.setShoe(rs.getString("Shoe"));
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
