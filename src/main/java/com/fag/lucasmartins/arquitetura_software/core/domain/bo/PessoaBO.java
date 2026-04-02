package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {

    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO() {
    }

    public void validarMaioridade() {
        if (dataNascimento == null) {
            throw new DomainException("Data de nascimento é obrigatória.");
        }
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("O cliente deve ter no mínimo 18 anos.");
        }
    }

    public void validarCpf() {
        if (cpf == null || cpf.isBlank()) {
            throw new DomainException("CPF é obrigatório.");
        }
        if (cpf.length() != 11) {
            throw new DomainException("CPF deve ter 11 caracteres.");
        }
    }

    public void validarEmail() {
        if (email == null || email.isBlank()) {
            throw new DomainException("E-mail é obrigatório.");
        }
        if (!email.contains("@")) {
            throw new DomainException("E-mail deve conter '@'.");
        }
    }

    public void validarTelefone() {
        if (telefone == null || telefone.isBlank()) {
            throw new DomainException("Telefone é obrigatório.");
        }
        if (telefone.length() != 11) {
            throw new DomainException("Telefone deve ter 11 caracteres (sem parênteses ou traços).");
        }
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}