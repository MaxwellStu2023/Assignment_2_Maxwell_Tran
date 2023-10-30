package controller.Destinations;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Destination;
import model.Destinations;


public class DisplayDestinationsController extends Controller<Destinations> {
    @FXML
    private TableView DestinationsAllTV;
    @FXML
    private TableView DestinationsFilteredTV;
    @FXML
    private TextField Filter;

    private Destinations getDestinations() {
        return model;
    }

    private ObservableList<Destination> getDesinationList() {
        return model.getDestinations();
    }

    @FXML
    private void initialize() {
        if (DestinationsAllTV != null) {
            DestinationsAllTV.setItems(model.getDestinations());
        }
        if (DestinationsFilteredTV != null) {
            Filter.textProperty().addListener(observable -> DestinationsFilteredTV.setItems(filterDestinations()));
        }
    }

    private ObservableList<Destination> filterDestinations(){
        if (Filter.getText() != null || !Filter.getText().isEmpty()){
            model.getFilteredDestinations(Filter.getText());
        }
        return model.getDestinations();
    }
}
