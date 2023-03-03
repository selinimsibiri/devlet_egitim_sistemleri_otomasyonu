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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class loginScreenController {

    @FXML
    private Button login_giris;
    @FXML
    private Label deneme;
    @FXML
    private Button login_kayitol;

    @FXML
    private TextField login_sifre;

    @FXML
    private TextField login_tc;
    @FXML
    private Label hataligiris;


    DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
    Connection connectDB = connectNow.getConnection();
    private Stage stage,stage1;
    private Scene scene,scene1;
    @FXML
    protected void onLoginButtonClicked(ActionEvent event) {

        String girilen_tc = login_tc.getText();
        String girilen_sifre = login_sifre.getText();
        int controller = 0;

        String sql = "SELECT * from yetkili_kullanicilar where yk_tc='"+girilen_tc + "'and yk_sifre='" + girilen_sifre+"'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql);

            while(queryOutput.next()){
                controller = 1;
                deneme.setText(queryOutput.getString("yk_tc"));
            }
            if (controller==0){
                hataligiris.setText("Hatalı bilgi girdiniz.");
            }
            else{
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void onKayitOlButtonClicked(ActionEvent event) {

        try {
            Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("kayit-ol-view.fxml")));
            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene1 = new Scene(root1);
            stage1.setScene(scene1);
            stage1.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
