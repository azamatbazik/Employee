package kz.dar.academy.backend.employeecoreapi.controller;

import jakarta.validation.Valid;
import kz.dar.academy.backend.employeecoreapi.model.EmployeeModel;
import kz.dar.academy.backend.employeecoreapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeModel employeeModel) {
        employeeService.createEmployee(employeeModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeModel getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable String employeeId,
                                                     @Valid @RequestBody EmployeeModel employeeModel) {
        employeeService.updateEmployeeById(employeeId, employeeModel);
        return new ResponseEntity<String>("Successfully updated", HttpStatus.OK);
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeByUd(@PathVariable String employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<String>("Successfully deleted" , HttpStatus.OK);
    }
}
