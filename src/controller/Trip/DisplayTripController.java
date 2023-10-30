package controller.Trip;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Itinery;
import model.Trip;

import java.util.List;

public class DisplayTripController extends Controller<Trip> {
    @FXML
    ListView<Itinery> TripList;

    private Trip getTrip(){
        return model;
    }

    public void initialize(){
        TripList.setItems(model.getItinery());
    }

}
