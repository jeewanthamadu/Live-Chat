package controller.client;

import com.jfoenix.controls.JFXTextArea;
import controller.Data;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.ConnectionUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class UserFormController {


    public AnchorPane userFormPane;
    public JFXTextArea chatPane;
    public TextField txtMsgField;
    public String userName;
    PrintWriter printWriter;
    Socket socket = null;

    public void initialize() throws IOException {
        userName = Data.userName;
        System.out.println("userName is : " + userName);
        socket = new Socket(ConnectionUtil.host, ConnectionUtil.port);
        chatPane.appendText("Connected... \n");
        printWriter = new PrintWriter(socket.getOutputStream());
        TaskReadThread task = new TaskReadThread(socket, this);
        Thread thread = new Thread(task);
        thread.start();

    }

    public void btnSent(ActionEvent actionEvent) throws IOException {
        printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(userName + " : " + txtMsgField.getText());
        printWriter.flush();
        txtMsgField.clear();
        txtMsgField.requestFocus();
    }

    public void btnCamera(ActionEvent actionEvent) {
    }

    public void btnEmoji(ActionEvent actionEvent) {
    }
}
