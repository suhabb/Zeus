package data_transfer;

import java.util.Map;

public class ApiFailure implements ApiResponse {
    private String errorCode;
    private Map<String, String> fieldErrors;
    private String message;

    public ApiFailure() {
    }

    public ApiFailure(String errorCode, Map<String, String> fieldErrors) {
        this.errorCode = errorCode;
        this.fieldErrors = fieldErrors;
    }

    public ApiFailure(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ApiFailure(String errorCode) {
        this.errorCode = errorCode;
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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

