/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package pkg2020130001.nicholas.inventori;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class koneksi {

    public Connection dbKoneksi; //ini apa dbKoneksi
    public Statement statement;
    public PreparedStatement preparedStatement;

    public koneksi() {
        this.dbKoneksi = null; //ini apa  dbKoneksi
    }

    public void bukaKoneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbKoneksi = DriverManager.getConnection( //ini apa dbKoneksi
                    "jdbc:mysql://localhost:3306/inventory?user=root&password=09876");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tutupKoneksi() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbKoneksi != null) { //ini apa  dbKoneksi
                dbKoneksi.close(); //ini apa  dbKoneksi
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
