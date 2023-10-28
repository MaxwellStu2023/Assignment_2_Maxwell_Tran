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

public class LoginController extends Controller<Administrators> {
    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public Administrators getAdministrator() {
        return model;
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
            if (model.hasAdministrator(getUsername(), getPassword())) {
                try {
                    ViewLoader.showStage(model, "/view/AgencyView.fxml", "Agency", new Stage());
                } catch (IOException e) {
                    ViewLoader.showErrorWindow(new ErrorModel(e,"IO Exception Error"));
                }
            }
        } catch (InvalidCredentialsException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "Wrong Credentials"));
        }
    }
}

    // public void openAgency(ActionEvent e) {
    //     ViewLoader.showStage(new Agency(), "/view.AgencyView.fxml", new Stage());
    // }
    

