package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public class PessoaRequestDTO {
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String n) { this.nomeCompleto = n; }
    public String getCpf() { return cpf; }
    public void setCpf(String c) { this.cpf = c; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate d) { this.dataNascimento = d; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String t) { this.telefone = t; }
}