package controller.Destinations;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Destination;
import model.Destinations;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.ItemNotFoundException;
import model.Flight;
import model.Flights;

public class ModifyDestinationsController extends Controller<Destinations> {
    @FXML
    public Button CloseAddButton;
    @FXML
    private TextField AddName;
    @FXML
    private TextField AddCountry;
    @FXML
    private Button AddButton;
    @FXML
    private TextField RemoveName;
    @FXML
    private TextField RemoveCountry;
    @FXML
    public Button RemoveButton;
    @FXML
    public Button CloseRemoveButton;
    private Destinations getDestinations(){
        return model;
    }

    private String getName(){
        return AddName.getText();
    }

    private String getCountry(){ return AddCountry.getText();
    }

    @FXML
    private void handleAddDestination(ActionEvent event){
        try {
            model.addDestination(new Destination(getName(), getCountry()));
            stage.close();
        } catch (DuplicateItemException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "Duplicate Flight"));
        }
    }
    public void initialize() {
        if (AddButton != null){
            AddButton.setDisable(true);
        }
        if (AddName != null){
            AddName.textProperty().addListener(observable -> disableAddButton());
        }
        if (AddCountry != null){
            AddCountry.textProperty().addListener(observable -> disableAddButton());
        }
        if (RemoveButton != null){
            RemoveButton.setDisable(true);
        }
        if (RemoveName != null){
            RemoveName.textProperty().addListener(observable -> disableRemoveButton());

        }
        if (RemoveCountry != null){
            RemoveCountry.textProperty().addListener(observable -> disableRemoveButton());
        }
    }

    public void disableAddButton(){
        if(!AddName.getText().isEmpty() && !AddCountry.getText().isEmpty()){
            AddButton.setDisable(false);
        }
        else {
            AddButton.setDisable(true);
        }
    }
    @FXML
    public void CloseAddDestination(ActionEvent event) {
        stage.close();
    }
    @FXML
    private void handleRemoveDestination(ActionEvent event) {
        if (model.hasDestination(RemoveName.getText(), RemoveCountry.getText())) {
            try {
                model.removeDestination(model.destination(RemoveName.getText(), RemoveCountry.getText()));
                stage.close();
            } catch (ItemNotFoundException e) {
                ViewLoader.showErrorWindow(new ErrorModel(e, "Flight Not Found"));
            }
        }
    }
    public void disableRemoveButton(){
        if(!RemoveName.getText().isEmpty() && !RemoveCountry.getText().isEmpty()){
            RemoveButton.setDisable(false);
        }
        else {
            RemoveButton.setDisable(true);
        }
    }
    @FXML
    public void CloseRemoveDestination(ActionEvent event) {
        stage.close();
    }
}

