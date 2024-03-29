package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
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
    @FXML private Label heading;

    public final Agency getAgency(){
        return model;
    }

//    public Administrator getUser() {
//            return model.getLoggedInUser();
//        }
    @FXML
    private void initialize(){
    heading.setText("Hi " + model.getLoggedInUser().getName() +  ", welcome to the Prog2 Travel Agency");
    }

    @FXML
    private void handleFlights(ActionEvent event){
        try {
            Stage flightStage = new Stage();
            flightStage.getIcons().add(new Image("/image/flights_icon.png"));
            ViewLoader.showStage(model.getFlights(), "/view/FLights/ExploreFlightsView.fxml", "Flights", flightStage);
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error!"));
        }
    }
    @FXML
    private void handleDestinations(ActionEvent event){
        try {
            Stage destinationsStage = new Stage();
            destinationsStage.getIcons().add(new Image("/image/destinations_icon.png"));
            ViewLoader.showStage(model.getDestinations(), "/view/Destinations/ExploreDestinationsView.fxml", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error!"));
        }
    }
    @FXML
    private void handleTrips(ActionEvent event){
        try {
            Stage tripStage = new Stage();
            tripStage.getIcons().add(new Image("/image/trip_icon.png"));
            ViewLoader.showStage(new Trip(model), "/view/Trip/BookTripView.fxml", "Flights", new Stage());
        } catch (IOException ex) {
            ViewLoader.showErrorWindow(new ErrorModel(ex,"IO Exception Error!"));
        }
    }
    @FXML
    private void handleExit(ActionEvent event){
        Platform.exit();
    }
}