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

    private String contato;

    private String telefone;

    // 🔹 Validação de CPF
    public void validarCpf() {
        if (this.cpf == null || this.cpf.isBlank()) {
            throw new DomainException("Erro: CPF é obrigatório.");
        }

        if (this.cpf.length() != 11) {
            throw new DomainException("Erro: CPF deve conter 11 caracteres.");
        }

        if (!this.cpf.matches("\\d{11}")) {
            throw new DomainException("Erro: CPF deve conter apenas números.");
        }
    }

    // 🔹 Validação de maioridade
    public void validarMaioridade() {
        if (this.dataNascimento == null) {
            throw new DomainException("Erro: Data de nascimento é obrigatória.");
        }

        int idade = Period.between(this.dataNascimento, LocalDate.now()).getYears();

        if (idade < 18) {
            throw new DomainException("Erro: Cliente deve ser maior de 18 anos.");
        }
    }

    // 🔹 Validação de contato
    public void validarContato() {
        if (this.contato == null || this.contato.isBlank()) {
            throw new DomainException("Erro: Email é obrigatório.");
        }

        if (!this.contato.contains("@")) {
            throw new DomainException("Erro: Email inválido.");
        }
    }

    // 🔹 Validação de telefone
    public void validarTelefone() {
        if (this.telefone == null || this.telefone.isBlank()) {
            throw new DomainException("Erro: Telefone é obrigatório.");
        }

        if (this.telefone.length() != 11) {
            throw new DomainException("Erro: Telefone deve conter 11 caracteres.");
        }

        if (!this.telefone.matches("\\d{11}")) {
            throw new DomainException("Erro: Telefone deve conter apenas números.");
        }
    }

    // GETTERS E SETTERS

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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}