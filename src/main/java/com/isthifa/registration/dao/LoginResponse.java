package com.isthifa.registration.dao;

public class LoginResponse {
    String message;
    boolean status;

    public LoginResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
