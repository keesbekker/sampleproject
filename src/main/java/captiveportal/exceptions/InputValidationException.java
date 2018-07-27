package captiveportal.exceptions;

public class InputValidationException extends RuntimeException {

    private String exceptionMsg;

    public InputValidationException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
    public String getExceptionMsg(){
        return this.exceptionMsg;
    }
    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
