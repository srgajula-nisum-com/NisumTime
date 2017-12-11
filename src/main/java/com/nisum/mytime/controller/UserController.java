package com.nisum.mytime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.mytime.exception.handler.MyTimeException;
import com.nisum.mytime.model.EmployeeRoles;
import com.nisum.mytime.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "employee/{emailId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRoles> getEmployeeRole(@PathVariable("emailId") String emailId)
			throws MyTimeException {
		EmployeeRoles employeesRole = userService.getEmployeesRole(emailId);
		return new ResponseEntity<>(employeesRole, HttpStatus.OK);
	}

	@RequestMapping(value = "/employeesDataSave", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> employeesDataSave() throws MyTimeException {
		Boolean result = userService.fetchEmployeesData();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/assigingEmployeeRole", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> assigingEmployeeRole(@RequestBody EmployeeRoles employeeRoles) throws MyTimeException {
		EmployeeRoles employeeRole = userService.assigingEmployeeRole(employeeRoles);
		return new ResponseEntity<>(employeeRole.getId(), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteEmployee(@RequestBody EmployeeRoles employeeRoles) throws MyTimeException {
		userService.deleteEmployee(employeeRoles);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	@RequestMapping(value = "/getUserRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeRoles>> getUserRoles() throws MyTimeException {
		List<EmployeeRoles> employeesRoles = userService.getEmployeeRoles();
		return new ResponseEntity<>(employeesRoles, HttpStatus.OK);
	}

}