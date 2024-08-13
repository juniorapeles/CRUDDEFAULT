package com.enterprise.jr.dto;

import com.enterprise.jr.entities.Employe;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeDTO {

    private Long id;
    private String name;
    private String cpf;
    private String password;

    @Email(message = "O Email deve ser válido")
    @NotBlank(message = "this field is not blank ")
    private String email;

    public EmployeDTO() {
    }

    public EmployeDTO(Long id, String name, String cpf, String password, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
    }

    public EmployeDTO(Employe employe) {
        this.id = employe.getId();
        this.name = employe.getName();
        this.cpf = employe.getCpf();
        this.password = employe.getPassword();
        this.email = employe.getEmail();
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
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
