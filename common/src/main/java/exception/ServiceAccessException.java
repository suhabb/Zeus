package exception;

import java.util.Map;

public class ServiceAccessException extends RuntimeException {
    private String errorCode;
    private Map<String, String> fieldErrors;

    public ServiceAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceAccessException(String errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceAccessException(String errorCode, Map<String, String> fieldErrors) {
        this.errorCode = errorCode;
        this.fieldErrors = fieldErrors;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, String> getFieldErrors() {
        return this.fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
