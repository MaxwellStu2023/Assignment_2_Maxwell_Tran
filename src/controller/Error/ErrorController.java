package controller.Error;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Exceptions.ErrorModel;

public class ErrorController extends Controller<ErrorModel> {
    @FXML
    Button closeError;
    @FXML
    Label errorCause;
    public ErrorModel getError(){
        return model;
    }

    public Exception getException(){return model.getException();
    }

    public String getErrorMessage(){
        return model.getMessage();
    }

    @FXML
    private void initialize(){
        errorCause.setText(model.getException().toString());
    }
    public void handleCloseErrorWindow(ActionEvent event){
        stage.close();
    }
}
