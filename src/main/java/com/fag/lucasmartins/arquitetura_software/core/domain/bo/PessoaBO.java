package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

import java.time.LocalDate;
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

    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        validar();
    }

    public void validar() {
        validarMaioridade();
        validarCpf();
        validarTelefone();
        validarEmail();
    }

    private void validarMaioridade() {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now().minusYears(18))) {
            throw new DomainException("Erro: O cliente deve ter no mínimo 18 anos.");
        }
    }

    private void validarCpf() {
        if (cpf == null || cpf.length() != 11) {
            throw new DomainException("Erro: O CPF deve ter exatamente 11 caracteres.");
        }
    }

    private void validarTelefone() {
        if (telefone == null || telefone.length() != 11) {
            throw new DomainException("Erro: O telefone deve ter exatamente 11 caracteres.");
        }
    }

    private void validarEmail() {
        if (email == null || !email.contains("@")) {
            throw new DomainException("Erro: O e-mail deve conter '@'.");
        }
    }

    // Getters and Setters
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