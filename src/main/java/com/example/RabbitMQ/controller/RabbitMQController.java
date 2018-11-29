package com.example.RabbitMQ.controller;

import com.example.RabbitMQ.model.Employee;
import com.example.RabbitMQ.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example-rabbitmq")
public class RabbitMQController {

    @Autowired
    RabbitMQService rabbitMQService;


    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMQService.send(emp);

        return "Successfully";
    }

}
