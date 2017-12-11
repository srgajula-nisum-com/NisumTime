package com.nisum.mytime.service;

import java.util.List;

import com.nisum.mytime.exception.handler.MyTimeException;
import com.nisum.mytime.model.EmpLoginData;
import com.nisum.mytime.model.EmployeeRoles;

public interface UserService {

	List<EmpLoginData> fetchEmployeeDataBasedOnEmpId(long id) throws MyTimeException;

	Boolean fetchEmployeesData() throws MyTimeException;

	List<EmpLoginData> employeeLoginsBasedOnDate(long id, String fromDate, String toDate) throws MyTimeException;

	List<EmployeeRoles> getEmployeeRoles() throws MyTimeException;

	EmployeeRoles assigingEmployeeRole(EmployeeRoles employeeRoles) throws MyTimeException;
	
	String generatePdfReport(long id, String fromDate, String toDate) throws MyTimeException;
	
	EmployeeRoles getEmployeesRole(String emailId);
	
	void deleteEmployee(EmployeeRoles employeeRoles);

}
