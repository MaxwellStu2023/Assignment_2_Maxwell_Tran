package controller.Destinations;


import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    @FXML
    Button CloseViewAllDestinations;
    @FXML
    Button CloseViewFilteredDestinations;

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
            Filter.textProperty().addListener(observable -> DestinationsFilteredTV.setItems(filterDestinations(Filter.getText())));
        }
    }

    public ObservableList<Destination> filterDestinations(String country) {
        return model.getDestinations().filtered(observable -> observable.getName().toLowerCase().contains(country.toLowerCase()) || observable.getCountry().toLowerCase().contains(country.toLowerCase()));
    }

    @FXML
    private void handleCloseDestinationsView(){
        stage.close();
    }
}