package com.enterprise.jr.services;

import com.enterprise.jr.dto.EmployeDTO;
import com.enterprise.jr.entities.Employe;
import com.enterprise.jr.repositories.EmployeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeService {

    @Autowired
    EmployeRepository repository;

    @Transactional
    public List<EmployeDTO> findAll() {
        List<Employe> entitys = repository.findAll();
        return entitys.stream().map(EmployeDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public EmployeDTO findById(Long id ) {
        Optional<Employe> obj = repository.findById(id);
        Employe entity = obj.orElseThrow(() -> new RuntimeException("id not found "+ id));
        return new EmployeDTO(entity);
    }

    public EmployeDTO updateEmploye (EmployeDTO dto, Long id){
        try{
            Employe entity = repository.getReferenceById(id);
            entity.setCpf(dto.getCpf());
            entity.setName(dto.getName());
            entity.setPassword(dto.getPassword());
            entity.setEmail(dto.getEmail());
            repository.save(entity);
            return new EmployeDTO(entity);
        }catch (RuntimeException e) {
            throw new RuntimeException("id not found" + id);
        }
    }

    public EmployeDTO insert (EmployeDTO dto) {
        Employe entity = new Employe(dto);
        repository.save(entity);
        return new EmployeDTO(entity);
    }

    public String deleteById (Long id){
            Optional<Employe> obj = repository.findById(id);
            Employe entity = obj.orElseThrow(() -> new RuntimeException("id not found "+ id));
            repository.deleteById(id);
            return "Employee deleted";
    }

}
