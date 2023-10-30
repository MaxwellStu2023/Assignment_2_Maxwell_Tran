package controller.Flights;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    @FXML private Button CloseViewAllFlights;
    @FXML private  Button CloseViewFilteredFlights;

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
            Filter.textProperty().addListener(observable -> FlightsFilteredTV.setItems(filterFlights(Filter.getText())));
        }
    }

    public ObservableList<Flight> filterFlights(String country) {
        if (country.isEmpty()) {
            return model.getFlights();
        } else {
            return model.getFlights().filtered(observalbe -> observalbe.getLanding().toLowerCase().contains(country.toLowerCase()) || observalbe.getTakeoff().toLowerCase().contains(country.toLowerCase()));
        }
    }
    @FXML
    private void handleCloseFlightView(ActionEvent event){
        stage.close();
    }
}
