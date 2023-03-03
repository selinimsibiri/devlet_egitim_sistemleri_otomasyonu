package com.example.proje2;

import  com.example.proje2.ogretmenler;
import  com.example.proje2.calisanlar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ogretmenIslemleriController implements Initializable {

    @FXML
    private ComboBox<String> brans_combobox;

    @FXML
    private TableColumn<ogretmenler, String> cb_isim;
    @FXML
    private Label labell;

    @FXML
    private TableColumn<ogretmenler, String> cb_soyisim;

    @FXML
    private TableView<ogretmenler> og_table;
    @FXML
    private TableColumn<ogretmenler, String> cb_tc;
    @FXML
    private Label og_brans;
    @FXML
    private Button but;
    @FXML
    private Label og_isim;

    @FXML
    private Label og_soyisim;

    @FXML
    private Button og_tc_arat;

    @FXML
    private TextField og_tc_input;

    ObservableList<String> bransListe = FXCollections.observableArrayList("edebiyat","fizik","kimya","biyoloji","matematik","din","tarih","felsefe");
    ObservableList<ogretmenler> listOg;


    DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
    Connection connectDB = connectNow.getConnection();

    public void comboAction(ActionEvent event) {

        System.out.println(brans_combobox.getValue());
        String  brans = brans_combobox.getValue();
        System.out.println("comboaction oldu");
        labell.setText(brans);
    }
    @FXML
    public void deneme(ActionEvent event) {
//        brans_combobox.setValue("Öğretmenler");
        brans_combobox.setItems(bransListe);
        String brans;

        brans = labell.getText();
        listOg = DatabaseConnectionClass.getDataUsers(brans);

        cb_tc.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTc()));
        cb_isim.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIsim()));
        cb_soyisim.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSoyisim()));


        og_table.setItems(listOg);
    }

    @Override
    public void initialize(URL url, ResourceBundle rs){
        brans_combobox.setValue("Branş Seçiniz");
        brans_combobox.setItems(bransListe);
    }

    @FXML
    protected void onOgTcAratButtonClick() {
        isimal();
        soyisimal();
        bransal();
    }
    @FXML
    protected void isimal() {

        DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT isim FROM ogretmenler_db WHERE tc = " + og_tc_input.getText();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                og_isim.setText(queryOutput.getString("isim"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void soyisimal() {

        DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT soyisim FROM ogretmenler_db WHERE tc = " + og_tc_input.getText();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                og_soyisim.setText(queryOutput.getString("soyisim"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void bransal() {

        DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "SELECT brans FROM ogretmenler_db WHERE tc = " + og_tc_input.getText();

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                og_brans.setText(queryOutput.getString("brans"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}