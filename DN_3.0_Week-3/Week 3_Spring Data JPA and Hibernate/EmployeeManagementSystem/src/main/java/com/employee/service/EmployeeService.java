package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
    
    private Session session;

    public void saveEmployees(List<Employee> employees) {
        Transaction transaction = session.beginTransaction();
        int batchSize = 30;
        for (int i = 0; i < employees.size(); i++) {
            session.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }
        }
        transaction.commit();
    }
}
