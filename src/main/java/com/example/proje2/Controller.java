package com.example.proje2;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


import java.sql.*;

public class Controller implements Initializable {
    @FXML
    private TextField isimgir;
    @FXML
    private TableView<okulListe> table_okullar;
    @FXML
    private TableColumn<okulListe,Integer> col_id;
    @FXML
    private TableColumn<okulListe,String> col_isim;
    @FXML
    private TableColumn<okulListe,String> col_konum;
    @FXML
    private TableColumn<okulListe,String> col_mudur;
    @FXML
    private TableColumn<okulListe,Integer> col_notort;
    @FXML
    private TextField konumgir;
    @FXML
    private TextField mudurgir;
    @FXML
    private TextField notortgir;
    @FXML
    private Button okulekle;
    @FXML
    private Button goster;
    @FXML
    private Label okulili;
    @FXML
    private Label okulisim;
    @FXML
    private Label okulmudur;
    @FXML
    private Label okulnotort;
    @FXML
    private TextField welcomeText;

    DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
    Connection connectDB = connectNow.getConnection();

    ObservableList<okulListe> listM;
    int index = -1;
    PreparedStatement pst = null;


    @Override
    public void initialize(URL url, ResourceBundle rs){
        col_id.setCellValueFactory(new PropertyValueFactory<okulListe,Integer>("id"));
        col_isim.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIsim()));
        col_konum.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKonum()));
        col_mudur.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMudur()));
        col_notort.setCellValueFactory(new PropertyValueFactory<okulListe,Integer>("notOrt"));

        listM = DatabaseConnectionClass.getDataUsers();
        table_okullar.setItems(listM);


    }

    @FXML
    protected void onHelloButtonClick() {
    isimal();
    konumal();
    mudural();
    notortal();
    }
    @FXML
    protected void okulKaydetButonu() {

        String isim = isimgir.getText();
        String konum = konumgir.getText();
        String mudur = mudurgir.getText();
        String notOrt = (okulnotort.getText());
        int notOrta = Integer.parseInt(notOrt);

        String sql = "INSERT INTO liseler_db (isim, konum, mudur,notOrtalama, sinif1,sinif2,sinif3,sinif4) VALUES (?,?,?,?,9,10,11,12)";

        try {
            pst = connectDB.prepareStatement(sql);
            pst.setString(1,isim);
            pst.setString(2,konum);
            pst.setString(3,mudur);
            pst.setString(4,notOrt);
            int i = pst.executeUpdate();
            if (i==1){
                System.out.println("Data insert successfully completed.");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

        //String connectQuery = "INSERT INTO liseler_db (isim, konum, mudur, sinif1,sinif2,sinif3,sinif4,notOrtalama) VALUES (,, , 9,10,11,12,73)";


    protected void isimal() {

        DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT isim FROM liseler_db WHERE id =" +Integer.parseInt(welcomeText.getText());

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                okulisim.setText(queryOutput.getString("isim"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void konumal() {

        DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT konum FROM liseler_db WHERE id =" +Integer.parseInt(welcomeText.getText());

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                okulili.setText(queryOutput.getString("konum"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void mudural() {

        DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT mudur FROM liseler_db WHERE id =" +Integer.parseInt(welcomeText.getText());

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                okulmudur.setText(queryOutput.getString("mudur"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void notortal() {

        DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT notOrtalama FROM liseler_db WHERE id =" +Integer.parseInt(welcomeText.getText());

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                okulnotort.setText(queryOutput.getString("notOrtalama"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}