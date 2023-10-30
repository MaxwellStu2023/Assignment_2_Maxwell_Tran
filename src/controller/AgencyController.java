package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Administrator;
import model.Administrators;
import model.Agency;
import model.Exceptions.ErrorModel;
import model.Trip;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class AgencyController extends Controller<Agency> {
    @FXML private Button exit;
    @FXML private Button trip;
    @FXML private Button flights;
    @FXML private Button destinations;
    @FXML private Label Heading;

    public final Agency getAgency(){
        return model;
    }
    public Administrator getUser(){
        return model.getLoggedInUser();
    }
    @FXML
    private void handleFlights(ActionEvent event){
        try {
            ViewLoader.showStage(model.getFlights(), "/view/FLights/ExploreFlightsView.fxml", "Flights", new Stage());
        } catch (IOException ex) {
            ex.printStackTrace();
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error"));
        }
    }
    @FXML
    private void handleDestinations(ActionEvent event){
        try {
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/ExploreDestinationsView.fxml", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error"));
        }
    }
    @FXML
    private void handleTrips(ActionEvent event){
        try {
            ViewLoader.showStage(new Trip(model), "/view/Trip/BookTripView.fxml", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error"));
        }
    }
    @FXML
    private void handleExit(ActionEvent event){
        Platform.exit();
    }

//    @FXML
//    public void initialize(){
//        if (Heading != null){
//            Heading.setText("Hi " + getUser().getName() + "welcome to the Prog2 Travel Agency");
//        }
//    }


}
