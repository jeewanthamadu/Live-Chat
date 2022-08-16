package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginFormPane;
    public JFXTextField txtUserName;
    public String userName;
    private double xOffset = 0;
    private double yOffset = 0;


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        userName = txtUserName.getText().isEmpty() ? "Unknown" : txtUserName.getText();
        Data.userName = userName;
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT); //Use For Boarder TRANSPARENT
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        stage.setMinWidth(440);
        stage.setMinHeight(769);
        stage.setMaxWidth(440);
        stage.setMaxHeight(769);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        loginFormPane.getScene().getWindow().hide();
    }

}

