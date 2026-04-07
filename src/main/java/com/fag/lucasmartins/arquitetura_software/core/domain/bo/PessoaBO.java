package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

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

    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        validar(); 
    }

    private void validar() {
        if (this.cpf == null || this.cpf.length() != 11) {
            throw new RuntimeException("CPF deve ter 11 dígitos.");
        }
        if (this.telefone == null || this.telefone.length() != 11) {
            throw new RuntimeException("Telefone deve ter 11 dígitos.");
        }
        if (this.email == null || !this.email.contains("@")) {
            throw new RuntimeException("E-mail inválido.");
        }
        if (this.dataNascimento == null || Period.between(this.dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new RuntimeException("Cliente deve ser maior de 18 anos.");
        }
    }

    
    public UUID getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
}