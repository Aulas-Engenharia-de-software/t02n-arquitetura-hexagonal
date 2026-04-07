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

    public void validarCadastro() {
        validarNomeCompleto();
        validarMaioridade();
        validarCpf();
        validarEmail();
        validarTelefone();
    }

    private void validarNomeCompleto() {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new DomainException("Erro: O nome completo é obrigatório.");
        }
    }

    private void validarMaioridade() {
        if (dataNascimento == null) {
            throw new DomainException("Erro: A data de nascimento é obrigatória.");
        }

        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("Erro: A pessoa deve ter no mínimo 18 anos.");
        }
    }

    private void validarCpf() {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new DomainException("Erro: O CPF é obrigatório.");
        }

        String cpfLimpo = cpf.trim();
        if (cpfLimpo.length() != 11) {
            throw new DomainException("Erro: O CPF deve possuir 11 caracteres.");
        }
    }

    private void validarEmail() {
        if (email == null || email.trim().isEmpty()) {
            throw new DomainException("Erro: O e-mail é obrigatório.");
        }

        String emailLimpo = email.trim();
        if (!emailLimpo.contains("@")) {
            throw new DomainException("Erro: O e-mail deve possuir um formato válido.");
        }
    }

    private void validarTelefone() {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new DomainException("Erro: O telefone é obrigatório.");
        }

        String telefoneLimpo = telefone.trim();
        if (telefoneLimpo.length() != 11) {
            throw new DomainException("Erro: O telefone deve possuir 11 caracteres.");
        }
    }

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
