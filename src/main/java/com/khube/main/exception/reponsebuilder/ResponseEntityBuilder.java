package com.khube.main.exception.reponsebuilder;

import com.khube.main.exception.response.EmployeeErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(EmployeeErrorResponse apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
