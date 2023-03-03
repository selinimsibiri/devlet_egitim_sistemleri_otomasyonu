package com.example.proje2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class KayitOlController{

    @FXML
    private Label deneme;

    @FXML
    private Button girisyapbutton;

    @FXML
    private TextField kayit_isim;

    @FXML
    private TextField kayit_sifre;

    @FXML
    private TextField kayit_soyisim;

    @FXML
    private TextField kayit_tc;

    @FXML
    private Button kayitolbutton;

    DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
    Connection connectDB = connectNow.getConnection();
    PreparedStatement pst = null;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void onKayitOlButtonClicked(ActionEvent event) {
        String kisim = kayit_isim.getText();
        String ktc = kayit_tc.getText();
        String ksifre = kayit_sifre.getText();
        String ksoyisim = kayit_soyisim.getText();

        String sql = "INSERT INTO yetkili_kullanicilar (yk_isim, yk_soyisim, yk_tc,yk_sifre) VALUES (?,?,?,?)";
        System.out.println(kayit_isim.getText());
        try {
            if(kayit_isim.getText() == null){
                System.out.println("1asdasdasdasdad");
            }else{
                pst = connectDB.prepareStatement(sql);
                pst.setString(1,kisim);
                pst.setString(2,ksoyisim);
                pst.setString(3,ktc);
                pst.setString(4,ksifre);
                int i = pst.executeUpdate();
                if (i==1){
                    System.out.println("Data insert successfully completed.");
                }
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onLoginButtonClicked(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-screen.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}