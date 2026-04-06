package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class PessoaBO {

    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        validarMaioridade(dataNascimento);
        validarCPF(cpf);
        validarEmail(email);
        validarTelefone(telefone);

        this.id = id != null ? id : UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    private void validarMaioridade(LocalDate dataNascimento) {
        if (Period.between(dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new DomainException("Idade mínima de 18 anos não atendida");
        }
    }

    private void validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new DomainException("CPF deve conter 11 dígitos");
        }
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new DomainException("E-mail inválido");
        }
    }

    private void validarTelefone(String telefone) {
        if (telefone == null || telefone.length() != 11) {
            throw new DomainException("Telefone deve conter 11 dígitos");
        }
    }

    // Getters
    public UUID getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
}