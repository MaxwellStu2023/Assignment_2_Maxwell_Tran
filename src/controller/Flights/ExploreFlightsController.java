package controller.Flights;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Exceptions.ErrorModel;
import model.Flights;

import java.io.IOException;

public class ExploreFlightsController extends Controller<Flights> {
    @FXML
    Button ViewAllFlights;
    @FXML
    Button ViewFilterFlights;
    @FXML
    Button AddFlight;
    @FXML
    Button RemoveFlight;
    @FXML
    Button FlightExit;

    @FXML
    private void handleFlightAllView(ActionEvent event) {
        try {
            ViewLoader.showStage(model, "/view/Flights/DisplayFlightsView.fxml", "View All Flights", new Stage());
        } catch (IOException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }

    @FXML
    private void handleFlightFilterView(ActionEvent event) {
        try {
            ViewLoader.showStage(model, "/view/Flights/DisplayFilteredFlightsView.fxml", "View Filtered Flights", new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }

    @FXML
    private void handleFlightAdd(ActionEvent event) {
        try {
            ViewLoader.showStage(model, "/view/Flights/AddFlightView.fxml", "Add Flight", new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }

    @FXML
    private void handleFlightRemove(ActionEvent event) {
        try {
            ViewLoader.showStage(model, "/view/Flights/RemoveFlightView.fxml", "Remove Flight", new Stage());
        } catch (IOException e) {
            e.printStackTrace();
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }

    @FXML
    private void handleFlightExit(ActionEvent event) {
        stage.close();
        }
}




