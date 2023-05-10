package com.khube.main.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeeErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus status;
    private List errors;

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(LocalDateTime timestamp, String message, HttpStatus status, List errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
        this.timestamp = timestamp;
    }
    public EmployeeErrorResponse(LocalDateTime timestamp, HttpStatus status, String message, List errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
        this.timestamp = timestamp;
    }

        public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setHttpStatus(HttpStatus status) {
        this.status = status;
    }

    public List getErrors() {
        return errors;
    }

    public void setErrors(List errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EmployeeErrorResponse{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", errors=" + errors +
                '}';
    }
}
