package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public class PessoaDTO {
    private String nomeCompleto;
    private String documentoCpf;
    private LocalDate dataNascimento;
    private String emailContato;
    private String telefoneCelular;

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getDocumentoCpf() { return documentoCpf; }
    public void setDocumentoCpf(String documentoCpf) { this.documentoCpf = documentoCpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEmailContato() { return emailContato; }
    public void setEmailContato(String emailContato) { this.emailContato = emailContato; }

    public String getTelefoneCelular() { return telefoneCelular; }
    public void setTelefoneCelular(String telefoneCelular) { this.telefoneCelular = telefoneCelular; }
}