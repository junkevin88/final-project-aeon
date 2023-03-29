package com.aeon.finpro.service.impl;

import com.aeon.finpro.dto.EmployeeModel;
import com.aeon.finpro.entity.Employee;
import com.aeon.finpro.entity.EmployeeDetail;
import com.aeon.finpro.repository.EmployeeDetailRepo;
import com.aeon.finpro.repository.EmployeeRepo;
import com.aeon.finpro.service.EmployeeService;
import com.aeon.finpro.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private Response response;
    @Autowired
    private EmployeeDetailRepo employeeDetailRepo;

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

            return new ResponseEntity<Map>(response.resSuccess(employee, "Sukses", 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

}
