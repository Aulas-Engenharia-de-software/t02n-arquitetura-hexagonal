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

    // ================= VALIDAÇÕES =================

    public void validarMaioridade() {
        if (dataNascimento == null ||
                Period.between(dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new DomainException("Pessoa deve ser maior de 18 anos.");
        }
    }

    public void validarCPF() {
        if (cpf == null || cpf.length() != 11) {
            throw new DomainException("CPF inválido.");
        }
    }

    public void validarEmail() {
        if (email == null || !email.contains("@")) {
            throw new DomainException("Email inválido.");
        }
    }

    public void validarTelefone() {
        if (telefone == null || telefone.length() != 11) {
            throw new DomainException("Telefone inválido.");
        }
    }

    public void validarDadosPessoa() {
        validarMaioridade();
        validarCPF();
        validarEmail();
        validarTelefone();
    }

    // ================= GETTERS E SETTERS =================

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}