package com.khube.main.controller;

import com.khube.main.entity.Employee;
import com.khube.main.response.EmployeeResponse;
import com.khube.main.service.EmployeeService;
import com.khube.main.util.SwaggerConfigValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequestMapping("/employee/api")
@RestController
@Api(tags = {"Employee Controller"})
@ApiResponses( value = {
        @ApiResponse(message = SwaggerConfigValue.OK, code = 200),
        @ApiResponse(message = SwaggerConfigValue.CREATED, code = 201),
        @ApiResponse(message = SwaggerConfigValue.FORBIDDEN, code = 404),
        @ApiResponse(message = SwaggerConfigValue.NOTFOUND, code = 400),
        @ApiResponse(message = SwaggerConfigValue.UNAUTHORIZED, code = 401),
        @ApiResponse(message = SwaggerConfigValue.INTERNALSERVERERROR, code = 500)
})
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = SwaggerConfigValue.VALUE1, response = EmployeeResponse.class)
    @PostMapping(value = "/employees")
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody Employee employee){
        EmployeeResponse employeeResponse = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE2, response = List.class)
    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeResponse>> getEmployees(){
        List<EmployeeResponse> employeeResponses = employeeService.getEmployees();
        return new ResponseEntity<>(employeeResponses, HttpStatus.OK);
    }

    @ApiOperation(value = SwaggerConfigValue.VALUE3, response = Optional.class)
    @GetMapping(value = "/employees/{empId}")
    public ResponseEntity<Optional<EmployeeResponse>> getEmployeeByEmpId(@PathVariable Integer empId){
        Optional<EmployeeResponse> employeeResponse = employeeService.getEmployeeByEmpId(empId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
}
