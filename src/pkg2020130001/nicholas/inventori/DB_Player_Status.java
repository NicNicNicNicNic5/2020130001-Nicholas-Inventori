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
public class DB_Player_Status {

    private Player_Status_Model dt = new Player_Status_Model();

    public Player_Status_Model getPlayer_Status_Model() {
        return (dt);
    }

    public void setPlayer_Status_Model(Player_Status_Model s) {
        dt = s;
    }

    public ObservableList<Player_Status_Model> Load() {
        try {
            ObservableList<Player_Status_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Player_ID, Player_Equip_ID, Name, Strength, Intelligence, Vitality, Agility, Dexterity, Lucky from player_status");
            int i = 1;
            while (rs.next()) {
                Player_Status_Model d = new Player_Status_Model();
                d.setPlayerid(rs.getString("Player_ID"));
                d.setPlayerequipid(rs.getString("Player_Equip_ID"));
                d.setNama(rs.getString("Name"));
                d.setStrength(Integer.parseInt(rs.getString("Strength")));
                d.setIntelligence(Integer.parseInt(rs.getString("Intelligence")));
                d.setVitality(Integer.parseInt(rs.getString("Vitality")));
                d.setAgility(Integer.parseInt(rs.getString("Agility")));
                d.setDexterity(Integer.parseInt(rs.getString("Dexterity")));
                d.setLucky(Integer.parseInt(rs.getString("Lucky")));
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
            con.statement = con.dbKoneksi.createStatement(); //ERROR
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from player_status where Player_ID = '" + nomor + "'");

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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into player_status (Player_ID, Player_Equip_ID, Name, Strength, Intelligence, Vitality, Agility, Dexterity, Lucky) values (?,?,?,?,?,?,?,?,?)");
            con.preparedStatement.setString(1, getPlayer_Status_Model().getPlayerid());
            con.preparedStatement.setString(2, getPlayer_Status_Model().getPlayerequipid());
            con.preparedStatement.setString(3, getPlayer_Status_Model().getNama());
            con.preparedStatement.setInt(4, getPlayer_Status_Model().getStrength());
            con.preparedStatement.setInt(5, getPlayer_Status_Model().getIntelligence());
            con.preparedStatement.setInt(6, getPlayer_Status_Model().getVitality());
            con.preparedStatement.setInt(7, getPlayer_Status_Model().getAgility());
            con.preparedStatement.setInt(8, getPlayer_Status_Model().getDexterity());
            con.preparedStatement.setInt(9, getPlayer_Status_Model().getLucky());
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from player_status where Player_ID  = ? ");
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
                    "update player_status set Name = ?, Strength = ?, Intelligence = ?, Vitality = ?, Agility = ?, Dexterity = ?, Lucky = ?  where  Player_ID = ? and Player_Equip_ID = ?; ");
            con.preparedStatement.setString(1, getPlayer_Status_Model().getNama());
            con.preparedStatement.setInt(2, getPlayer_Status_Model().getStrength());
            con.preparedStatement.setInt(3, getPlayer_Status_Model().getIntelligence());
            con.preparedStatement.setInt(4, getPlayer_Status_Model().getVitality());
            con.preparedStatement.setInt(5, getPlayer_Status_Model().getAgility());
            con.preparedStatement.setInt(6, getPlayer_Status_Model().getDexterity());
            con.preparedStatement.setInt(7, getPlayer_Status_Model().getLucky());
            con.preparedStatement.setString(8, getPlayer_Status_Model().getPlayerid());
            con.preparedStatement.setString(9, getPlayer_Status_Model().getPlayerequipid());
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

    public ObservableList<Player_Status_Model> LookUp(String fld, String dt) {
        try {
            ObservableList<Player_Status_Model> tableData = FXCollections.observableArrayList();
            koneksi con = new koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select Player_ID, Player_Equip_ID, Name, Strength, Intelligence, Vitality, Agility, Dexterity, Lucky from player_status where " + fld + " like '%" + dt + "%'");
            int i = 1;
            while (rs.next()) {
                Player_Status_Model d = new Player_Status_Model();
                d.setPlayerid(rs.getString("Player_ID"));
                d.setPlayerequipid(rs.getString("Player_Equip_ID"));
                d.setNama(rs.getString("Name"));
                d.setStrength(rs.getInt("Strength"));
                d.setIntelligence(rs.getInt("Intelligence"));
                d.setVitality(rs.getInt("Vitality"));
                d.setAgility(rs.getInt("Agility"));
                d.setDexterity(rs.getInt("Dexterity"));
                d.setLucky(rs.getInt("Lucky"));
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

    }
}
