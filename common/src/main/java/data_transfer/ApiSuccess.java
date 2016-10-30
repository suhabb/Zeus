package data_transfer;

public class ApiSuccess implements ApiResponse {
    private Boolean status;
    private String successText;
    private Long id;

    public ApiSuccess() {
    }

    public ApiSuccess(Boolean status) {
        this.status = status;
    }

    public ApiSuccess(Boolean status, Long id) {
        this.status = status;
        this.id = id;
    }

    public ApiSuccess(Boolean status, String successText) {
        this.status = status;
        this.successText = successText;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSuccessText() {
        return this.successText;
    }

    public void setSuccessText(String successText) {
        this.successText = successText;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
