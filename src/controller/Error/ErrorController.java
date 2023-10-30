package controller.Error;


import au.edu.uts.ap.javafx.Controller;
import model.Exceptions.ErrorModel;

public class ErrorController extends Controller<ErrorModel> {

    private ErrorModel getError(){
        return model;
    }

    private Exception getException(){
        return model.getException();
    }

    private String getErrorMessage(){
        return model.getMessage();
    }
}
