package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

    public Administrators getAdministrators() {
        return model.getAdministrators();
    }

    private String getUsername() {
        return username.getText();
    }

    private String getPassword() {
        return password.getText();
    }

    private Administrator setAdministrator() {
        try {
            return model.getAdministrators().getAdministrator(getUsername(), getPassword());
        } catch (InvalidCredentialsException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e,"IO Exception Error!"));
        }
        return null;
    }


    @FXML
    private void handleLogin(ActionEvent event) {
        try {
            if (getAdministrators().hasAdministrator(getUsername(), getPassword())) {
                try {
                    Stage agencyStage = new Stage();
                    agencyStage.getIcons().add(new Image("/image/agency_icon.png"));
                    model.setLoggedInUser((setAdministrator()));
                    ViewLoader.showStage(model, "/view/AgencyView.fxml", "Agency", agencyStage);
                } catch (IOException e) {
                    ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error!"));
                    e.printStackTrace();
                }
            }
        }
        catch (InvalidCredentialsException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "Wrong Credentials!"));
            e.printStackTrace();
        }
    }
}


    

