package controller.Error;


import au.edu.uts.ap.javafx.Controller;
import model.Exceptions.ErrorModel;

public class ErrorController extends Controller<ErrorModel> {

    public ErrorModel getError(){
        return model;
    }

    public Exception getException(){
        return model.getException();
    }

    public String getErrorMessage(){
        return model.getMessage();
    }
}
