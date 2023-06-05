package edu.bo.ucb.sis213.internship.dto;

public class ResponseDto<T>{
    private String code;
    private T response;
    private String errorMessage;
    public ResponseDto() {
    }
    //getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", response=" + response +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}