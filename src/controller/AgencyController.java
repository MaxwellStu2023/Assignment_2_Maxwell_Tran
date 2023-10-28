package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrator;
import model.Administrators;
import model.Agency;
import model.Exceptions.ErrorModel;
import model.Trip;

import java.io.IOException;

public class AgencyController extends Controller<Agency> {
    @FXML private Button exit;
    @FXML private Button trip;
    @FXML private Button flights;
    @FXML private Button destinations;

    public Administrator getUser(){
        return model.getLoggedInUser();
    }
    @FXML
    private void handleFlights(ActionEvent event){
        try {
            ViewLoader.showStage(model.getFlights(), "/view/", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error"));
        }
    }
    @FXML
    private void handleDestinations(ActionEvent event){
        try {
            ViewLoader.showStage(model.getDestinations(), "/view/", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error"));
        }
    }
    @FXML
    private void handleTrips(ActionEvent event){
        try {
            ViewLoader.showStage(new Trip(model), "/view/", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error"));
        }
    }
    @FXML
    private void handleExit(ActionEvent event){
        try {
            ViewLoader.showStage(model, "/view/", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error"));
        }
    }
    @Override
    public String toString(){
        return "Hi " + getUser().getName() + "welcome to the Prog2 Travel Agency";
    }


}
