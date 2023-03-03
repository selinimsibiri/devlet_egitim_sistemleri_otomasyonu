package com.example.proje2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnectionClass {
    public static Connection databaseLink;

    public static Connection getConnection(){
        String databaseName = "demoo";
        String databaseUser = "root";
        String databasePassword = "12345";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }

    public static ObservableList<okulListe> getDataUsers(){
        Connection con = getConnection();
        ObservableList<okulListe> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("select * from liseler_db");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new okulListe(Integer.parseInt(rs.getString("id")),rs.getString("isim"),rs.getString("konum"),rs.getString("mudur"),Integer.parseInt(rs.getString("notOrtalama"))));
                int lastId = (Integer.parseInt(rs.getString("id")));
            }
        }
        catch (Exception e){
        }

        return list;
    }
    public static ObservableList<ogretmenler> getDataUsers(String brans){
        Connection con = getConnection();
        ObservableList<ogretmenler> alist = FXCollections.observableArrayList();
        try {
            System.out.println("brans = "+brans);
            PreparedStatement ps = con.prepareStatement("select * from ogretmenler_db where brans = '"+brans+"'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                    alist.add(new ogretmenler(rs.getString("isim"), rs.getString("soyisim"), rs.getString("tc"), rs.getString("brans")));
                }
        }
        catch (Exception e){
        }

        return alist;
    }
}
