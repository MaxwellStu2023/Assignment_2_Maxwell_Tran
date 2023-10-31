package controller.Flights;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.ItemNotFoundException;
import model.Flight;
import model.Flights;

import javax.swing.text.View;


public class ModifyFlightsController extends Controller<Flights> {
    @FXML
    public Button CloseAddButton;
    @FXML
    private TextField AddAirline;
    @FXML
    private TextField AddNumber;
    @FXML
    private TextField AddTakeoff;
    @FXML
    private TextField AddLanding;
    @FXML
    private TextField AddCost;
    @FXML
    public Button AddButton;
    @FXML
    private TextField RemoveTakeoff;
    @FXML
    private TextField RemoveLanding;
    @FXML
    public Button RemoveButton;
    @FXML
    public Button CloseRemoveButton;
    private Flights getFlights(){
        return model;
    }

    private String getAirline(){
        return AddAirline.getText();
    }

    private int getNumber(){
        return Integer.parseInt(AddNumber.getText());
    }

    private String getTakeoff(){
        return AddTakeoff.getText();
    }

    private String getLanding(){
        return AddLanding.getText();
    }

    private double getCost(){
        return Double.parseDouble(AddCost.getText());
    }
    @FXML
    private void handleAddFlight(ActionEvent event){
        try {
            try {
                model.addFlight(new Flight(getAirline(), getNumber(), getLanding(), getTakeoff(), getCost()));
                stage.close();
            } catch (NumberFormatException e){
                ViewLoader.showErrorWindow(new ErrorModel(e, "Enter a Number!"));
            }
        } catch (DuplicateItemException e) {
            ViewLoader.showErrorWindow(new ErrorModel(e, "Duplicate Flight!"));
        }
    }
    public void initialize() {
        if (AddButton != null){
            AddButton.setDisable(true);
        }
        if (AddAirline != null){
            AddAirline.textProperty().addListener(observable -> disableAddButton());
        }
        if (AddLanding != null){
            AddLanding.textProperty().addListener(observable -> disableAddButton());
        }
        if (AddNumber != null){
            AddNumber.textProperty().addListener(observable -> disableAddButton());
        }
        if (AddTakeoff != null){
            AddTakeoff.textProperty().addListener(observable -> disableAddButton());
        }
        if (AddCost != null){
            AddCost.textProperty().addListener(observable -> disableAddButton());
        }
        if (RemoveButton != null){
            RemoveButton.setDisable(true);
        }
        if (RemoveTakeoff != null){
            RemoveTakeoff.textProperty().addListener(observable -> disableRemoveButton());

        }
        if (RemoveLanding != null){
            RemoveLanding.textProperty().addListener(observable -> disableRemoveButton());
        }
    }

    public void disableAddButton(){
        if(!AddAirline.getText().isEmpty() && !AddCost.getText().isEmpty() && !AddTakeoff.getText().isEmpty() && !AddLanding.getText().isEmpty() && !AddNumber.getText().isEmpty()){
        AddButton.setDisable(false);
        }
        else {
            AddButton.setDisable(true);
        }
    }
    @FXML
    public void CloseAddFlight(ActionEvent event) {
        stage.close();
    }
    @FXML
    private void handleRemoveFlight(ActionEvent event) {
        if (model.hasFlight(RemoveTakeoff.getText(), RemoveLanding.getText())) {
            try {
                model.removeFlight(model.getFlight(RemoveTakeoff.getText(), RemoveLanding.getText()));
                stage.close();
            } catch (ItemNotFoundException e) {
                ViewLoader.showErrorWindow(new ErrorModel(e, "Flight Not Found!"));
            }
        }
    }
    public void disableRemoveButton(){
        if(!RemoveTakeoff.getText().isEmpty() && !RemoveLanding.getText().isEmpty()){
            RemoveButton.setDisable(false);
        }
        else {
            RemoveButton.setDisable(true);
        }
    }
    @FXML
    public void CloseRemoveFlight(ActionEvent event) {
        stage.close();
    }
}