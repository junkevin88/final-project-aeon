package com.aeon.finpro.service.impl;

import com.aeon.finpro.dto.EmployeeModel;
import com.aeon.finpro.entity.Account;
import com.aeon.finpro.entity.Employee;
import com.aeon.finpro.entity.EmployeeDetail;
import com.aeon.finpro.repository.AccountRepo;
import com.aeon.finpro.repository.EmployeeDetailRepo;
import com.aeon.finpro.repository.EmployeeRepo;
import com.aeon.finpro.service.EmployeeService;
import com.aeon.finpro.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Response response;
    @Autowired
    private EmployeeDetailRepo employeeDetailRepo;
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public ResponseEntity<Map> insertEmployee(EmployeeModel employeeModel) {
        try {
            if (employeeModel.getName() == null) {
                return new ResponseEntity<Map>(response.clientError("Name is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getNik() == null) {
                return new ResponseEntity<Map>(response.clientError("NIK is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getNpwp() == null) {
                return new ResponseEntity<Map>(response.clientError("NPWP is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getDob() == null) {
                return new ResponseEntity<Map>(response.clientError("Date of Birth is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getGender() == null) {
                return new ResponseEntity<Map>(response.clientError("Gender is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAddress() == null) {
                return new ResponseEntity<Map>(response.clientError("Address is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getStatus() == null) {
                return new ResponseEntity<Map>(response.clientError("Status is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAccountName() == null) {
                return new ResponseEntity<Map>(response.clientError("Account name is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAccountNumber() == null) {
                return new ResponseEntity<Map>(response.clientError("Account number is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAccountType() == null) {
                return new ResponseEntity<Map>(response.clientError("Account type is required"), HttpStatus.BAD_REQUEST);
            }


            Employee employee = new Employee();
            employee.setName(employeeModel.getName());
            employee.setStatus(employeeModel.getStatus());
            employee.setAddress(employeeModel.getAddress());
            employee.setDob(employeeModel.getDob());
            employee.setGender(employeeModel.getGender());


            EmployeeDetail employeeDetail = new EmployeeDetail();
            employeeDetail.setNik(employeeModel.getNik());
            employeeDetail.setNpwp(employeeModel.getNpwp());
            employeeRepo.save(employee);
            employeeDetail.setEmployee(employee);
            employeeDetailRepo.save(employeeDetail);

            Account account = new Account();
            account.setEmployee(employee);
            account.setAccountNumber(employeeModel.getAccountNumber());
            account.setName(employeeModel.getAccountName());
            account.setAccountType(employeeModel.getAccountType());
            accountRepo.save(account);

            return new ResponseEntity<Map>(response.resSuccess(employee, "Success insert employee", 201), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map> updateEmployee(EmployeeModel employeeModel) {
        try {
            if (employeeModel.getName() == null) {
                return new ResponseEntity<Map>(response.clientError("Name is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getNik() == null) {
                return new ResponseEntity<Map>(response.clientError("NIK is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getNpwp() == null) {
                return new ResponseEntity<Map>(response.clientError("NPWP is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getDob() == null) {
                return new ResponseEntity<Map>(response.clientError("Date of Birth is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getGender() == null) {
                return new ResponseEntity<Map>(response.clientError("Gender is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAddress() == null) {
                return new ResponseEntity<Map>(response.clientError("Address is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getStatus() == null) {
                return new ResponseEntity<Map>(response.clientError("Status is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getId() == null) {
                return new ResponseEntity<Map>(response.clientError("ID is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAccountName() == null) {
                return new ResponseEntity<Map>(response.clientError("Account name is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAccountNumber() == null) {
                return new ResponseEntity<Map>(response.clientError("Account number is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeModel.getAccountType() == null) {
                return new ResponseEntity<Map>(response.clientError("Account type is required"), HttpStatus.BAD_REQUEST);
            }

            Employee employee = employeeRepo.getById(employeeModel.getId());
            if (employee == null) {
                return new ResponseEntity<Map>(response.clientError("Employee not found"), HttpStatus.BAD_REQUEST);
            }

            employee.setName(employeeModel.getName());
            employee.setStatus(employeeModel.getStatus());
            employee.setAddress(employeeModel.getAddress());
            employee.setDob(employeeModel.getDob());
            employee.setGender(employeeModel.getGender());


            EmployeeDetail employeeDetail = employeeDetailRepo.findByEmployeeId(employeeModel.getId());
            if (employeeDetail == null) {
                return new ResponseEntity<Map>(response.clientError("Employee Detail not found"), HttpStatus.BAD_REQUEST);
            }
            employeeDetail.setNik(employeeModel.getNik());
            employeeDetail.setNpwp(employeeModel.getNpwp());
            employeeRepo.save(employee);
            employeeDetail.setEmployee(employee);
            employeeDetailRepo.save(employeeDetail);

            Account account = accountRepo.findByEmployeeId(employeeModel.getId());
            if (account == null) {
                return new ResponseEntity<Map>(response.clientError("Account not found"), HttpStatus.BAD_REQUEST);
            }
            account.setEmployee(employee);
            account.setAccountNumber(employeeModel.getAccountNumber());
            account.setName(employeeModel.getAccountName());
            account.setAccountType(employeeModel.getAccountType());
            accountRepo.save(account);

            return new ResponseEntity<Map>(response.resSuccess(employee, "Success update employee", 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map> getEmployeeById(UUID id) {
        try {
            Optional<Employee> employee = employeeRepo.findById(id);
            if (employee == null) {
                return new ResponseEntity<Map>(response.clientError("Employee not found"), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Map>(response.resSuccess(employee, "Succes get employee", 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
