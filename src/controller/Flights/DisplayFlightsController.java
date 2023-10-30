package controller.Flights;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Flight;
import model.Flights;

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
            Filter.textProperty().addListener(observable -> FlightsFilteredTV.setItems(filterFlights()));
        }
    }

    private ObservableList<Flight> filterFlights(){
        if (Filter.getText() != null || !Filter.getText().isEmpty()){
            model.getFilteredFlights(Filter.getText());
        }
            return model.getFlights();
        }
}
