package controller.Destinations;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Administrator;
import model.Administrators;
import model.Agency;
import model.Destinations;
import model.Exceptions.ErrorModel;

import java.io.IOException;


public class ExploreDestinationsController extends Controller<Destinations> {
    @FXML
    Button ViewAllDestinations;
    @FXML
    Button ViewFilterDestinations;
    @FXML
    Button AddDestination;
    @FXML
    Button RemoveDestination;
    @FXML
    Button DestinationExit;

    public Agency getAgency(){
        return model.getAgency();
    }
    @FXML
    public void handleDestinationAllView(){
        try {
            ViewLoader.showStage(model, "/view/Destinations/DisplayDestinationsView.fxml", "All Destinations", new Stage());
        } catch (IOException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }
    @FXML
    public void handleDestinationFilterView(){
        try {
            ViewLoader.showStage(model, "/view/Destinations/DisplayFilteredDestinationsView.fxml", "Filtered Destinations", new Stage());
        } catch (IOException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }
    @FXML
    public void handleDestinationAdd(){
        try {
            ViewLoader.showStage(model, "/view/Destinations/AddDestinationView.fxml", "Add Destination", new Stage());
        } catch (IOException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }
    @FXML
    public void handleDestinationRemove(){
        try {
            ViewLoader.showStage(model, "/view/Destinations/RemoveDestinationView.fxml", "Remove Destination", new Stage());
        } catch (IOException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "IO Exception Error"));
        }
    }
    @FXML
    public void handleDestinationExit(){
        stage.close();
    }
   
}
