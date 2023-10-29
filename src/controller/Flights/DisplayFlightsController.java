package controller.Flights;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Flight;
import model.Flights;

import java.util.Observable;

public class DisplayFlightsController extends Controller<Flights> {

    private Flights getFlights(){
        return model;
    }
}
