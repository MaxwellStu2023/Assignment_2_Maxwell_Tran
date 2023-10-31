package controller.Trip;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import model.Destination;
import model.Exceptions.ErrorModel;
import model.Itinery;
import model.Trip;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class DisplayTripController extends Controller<Trip> {
    @FXML
    ListView<Itinery> TripList;
    @FXML
    Button CloseTripView;
    @FXML
    Button ViewIndividual;
    private Trip getTrip(){
        return model;
    }

    public void initialize(){
        TripList.setItems(model.getItinery());
        TripList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TripList.getSelectionModel().selectedItemProperty().addListener(observable -> getCurrent());

    }

    @FXML
    private void handleCloseTripView(ActionEvent event){
        stage.close();
    }

    public ObservableList<Itinery> getCurrent(){
        return TripList.getSelectionModel().getSelectedItems();

    }
    @FXML
    private void handleViewIndividual(ActionEvent event){
            if (getCurrent().contains(model.getDestinations())) {
                try {
                    System.out.println("Hello World");
                    ViewLoader.showStage(model.getDestinations(), "/view/Destinations/DisplayDestinationView.fxml", "View Individual Destinations", new Stage());
                } catch (IOException e) {
                    ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error!"));
                }
            }
            else if (getCurrent().contains(model.getFlights())) {
                try {
                    System.out.println("Hello World");
                    ViewLoader.showStage(model.getFlights(), "/view/Flights/DisplayFlightsView.fxml", "View Individual Flights", new Stage());
                } catch (IOException e) {
                    ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error!"));
                }
            }
        }
}
