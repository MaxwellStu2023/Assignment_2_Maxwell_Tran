package controller.Flights;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Flight;
import model.Flights;

import java.util.Observable;

public class DisplayFlightsController extends Controller<Flights> {

    @FXML
    private TableView FlightsAllTV;
    @FXML
    private TableView FlightsFilteredTV;
    @FXML
    private TextField Filter;

    private Flights getFlights() {
        return model;
    }

    private ObservableList<Flight> getFlight() {
        return model.getFlights();
    }

    @FXML
    private void initialize() {
        if (FlightsAllTV != null) {
            FlightsAllTV.setItems(model.getFlights());
        }
        if (FlightsFilteredTV != null) {
            FlightsFilteredTV.setItems(model.getFilteredFlights(Filter.getText().toLowerCase()));
        }
    }
}
