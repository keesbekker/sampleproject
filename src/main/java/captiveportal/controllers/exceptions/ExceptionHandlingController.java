package captiveportal.controllers.exceptions;

import captiveportal.exceptions.InputValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(InputValidationException.class)
    public String errorPAgeInputValidationException() {
        return "error-input-validation";
    }

}
