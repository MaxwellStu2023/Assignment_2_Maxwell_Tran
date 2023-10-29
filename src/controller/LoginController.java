package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Administrator;
import model.Administrators;
import model.Agency;
import model.Exceptions.ErrorModel;
import model.Exceptions.InvalidCredentialsException;

import javax.swing.*;
import javax.swing.text.View;
import java.io.IOException;

public class LoginController extends Controller<Agency> {
    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public Agency getAgency() {
        return model;
    }

    public Administrators getAdministrators(){
        return model.getAdministrators();
    }

    private String getUsername() {
        return username.getText();
    }

    private String getPassword() {
        return password.getText();
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        try {
            if (getAdministrators().hasAdministrator(getUsername(), getPassword())) {
                try {
                    ViewLoader.showStage(model, "/view/AgencyView.fxml", "Agency", new Stage());
                } catch (IOException e) {
                    ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
                }
            }
        }
        catch (InvalidCredentialsException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "Wrong Credentials"));
        }
    }
}


    

