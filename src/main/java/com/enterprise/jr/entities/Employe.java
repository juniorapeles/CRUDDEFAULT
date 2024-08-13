package com.enterprise.jr.entities;

import com.enterprise.jr.dto.EmployeDTO;
import jakarta.persistence.*;

@Table(name = "tb_employe")
@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;
    private String password;
    private String email;


    public Employe() {
    }

    public Employe(EmployeDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
    }

    public Employe(Long id, String name, String cpf, String password, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
