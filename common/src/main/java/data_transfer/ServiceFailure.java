package data_transfer;

public class ServiceFailure implements ServiceResponse {
    private String message;

    public ServiceFailure() {
    }

    public ServiceFailure(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
