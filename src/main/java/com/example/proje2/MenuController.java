package com.example.proje2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MenuController {

    @FXML
    private Label cikisyap;
    @FXML
    private Button menu_ogretmenislemleri;

    @FXML
    private Button menu_okulislemleri;

    @FXML
    private Button menu_personelislemleri;

    DatabaseConnectionClass connectNow = new DatabaseConnectionClass();
    Connection connectDB = connectNow.getConnection();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void onCikisYapButtonClicked(MouseEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("login-screen.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void onOkulIslemleriButtonClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle("Okul İşlemleri");
            stage.setScene(new Scene(root, 400, 500));
            stage.showAndWait();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    void onOgretmenIslemleriButtonClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ogretmen-islemleri-screen.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle("Ogretmen İşlemleri");
            stage.setScene(new Scene(root, 400, 500));
            stage.showAndWait();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
