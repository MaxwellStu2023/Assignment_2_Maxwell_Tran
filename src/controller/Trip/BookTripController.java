package controller.Trip;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.InsufficientDestinationsException;
import model.Trip;

import java.io.IOException;

public class BookTripController extends Controller<Trip> {
    @FXML
    Button AddDestination;
    @FXML
    Button RemoveDestination;
    @FXML
    Button AddConnectingFlight;
    @FXML
    Button ViewTrip;
    @FXML
    Button TripExit;

    @FXML
    private void handleAddTripDestination(ActionEvent event) {
        try {
            ViewLoader.showStage(model, "/view/Destinations/AddDestinationView.fxml", "Add a Destination", new Stage());
        } catch (IOException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }

    @FXML
    private void handleRemoveTripDestination(ActionEvent event) {
        try {
            ViewLoader.showStage(model, "/view/Destinations/RemoveDestinationView.fxml", "Remove a Destination", new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }

    @FXML
    private void handleAddConnectingFlight(ActionEvent event) {
        try {
            model.addConnectingFlights();
        } catch (DuplicateItemException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "Duplicate Flights"));
        } catch (InsufficientDestinationsException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "Insufficient amount of Destinations"));
        }
    }

    @FXML
    private void handleViewTrip(ActionEvent event) {
        try {
            ViewLoader.showStage(model, "/view/Trip/DisplayTripView.fxml", "View Trip", new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }

    @FXML
    private void handleTripExit(ActionEvent event) {
        stage.close();
    }

}
