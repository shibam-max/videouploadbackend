package com.shibam.videolibrarybackend.exception;




public class ResourceNotFoundException extends RuntimeException {

    private boolean status;
    private String message;

    public ResourceNotFoundException() {
        super();
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

    public ResourceNotFoundException(boolean status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
