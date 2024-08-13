package com.enterprise.jr.controllers;

import com.enterprise.jr.dto.EmployeDTO;
import com.enterprise.jr.services.EmployeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeController {

    @Autowired
    EmployeService service;

    @GetMapping
    public List<EmployeDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public EmployeDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public EmployeDTO insert(@Valid @RequestBody EmployeDTO dto) {
        return service.insert(dto);
    }

    @PutMapping(value = "/{id}")
    public EmployeDTO updateEmploye (@Valid @PathVariable Long id, @RequestBody EmployeDTO dto) {
        return service.updateEmploye(dto, id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }

}
