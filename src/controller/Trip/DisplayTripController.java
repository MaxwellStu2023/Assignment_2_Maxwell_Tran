package controller.Trip;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Itinery;
import model.Trip;

import java.util.List;

public class DisplayTripController extends Controller<Trip> {
    @FXML
    ListView<Itinery> TripList;

    @FXML
    Button CloseTripView;
    private Trip getTrip(){
        return model;
    }

    public void initialize(){
        TripList.setItems(model.getItinery());
    }

    @FXML
    private void handleCloseTripView(ActionEvent event){
        stage.close();
    }
}
