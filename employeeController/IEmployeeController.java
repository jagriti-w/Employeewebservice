package com.example.rqchallenge.employees;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public interface IEmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
    @GetMapping()
    ResponseEntity<List<Employee>> getAllEmployees() throws IOException{
        List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/search/{searchString}")
    ResponseEntity<List<Employee>> getEmployeesByNameSearch(@PathVariable String searchString){
		List<Employee> employee = employeeService.getEmployeesByNameSearch(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

    @GetMapping("/highestSalary")
    ResponseEntity<Integer> getHighestSalaryOfEmployees(){
		String result = employeeService.getHighestSalaryOfEmployees();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

    @GetMapping("/topTenHighestEarningEmployeeNames")
    ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames(){
		List<Employee> employee = employeeService.getTopTenHighestEarningEmployeeNames();
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

    @PostMapping()
    ResponseEntity<Employee> createEmployee(@RequestBody Map<String, Object> employeeInput){
		String name = (String) employeeInput.get("name");
		String salary = (String) employeeInput.get("salary");
		String age = (String) employeeInput.get("age");

        Employee newEmployee = new Employee();
        newEmployee.setName(name); 
		newEmployee.setSalary(salary);
		newEmployee.setAge(age);
		newEmployee.setProfileImage(profile_image);
        Employee createdEmployee = employeeService.createEmployee(newEmployee);

		return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteEmployeeById(@PathVariable String id){
		employeeService.deleteEmployeeById(id);
		CustomResponse response = new CustomResponse("successfully! deleted Record");
		return new ResponseEntity<>(createdEmployee, HttpStatus.OK);	
	}

}
