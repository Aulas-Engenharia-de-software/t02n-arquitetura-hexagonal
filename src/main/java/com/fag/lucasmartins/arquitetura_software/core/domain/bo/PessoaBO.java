package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class PessoaBO {

    private UUID id;
    private String nomeCompleto;
    private String documentoCpf;
    private LocalDate dataNascimento;
    private String emailContato;
    private String telefoneCelular;

   
    public void validarDadosPessoa() {
        validarMaioridade();
        validarCpf();
        validarEmail();
        validarTelefone();
    }

    private void validarMaioridade() {
        if (this.dataNascimento == null || Period.between(this.dataNascimento, LocalDate.now()).getYears() < 18) {
            throw new DomainException("Erro: O cliente deve ter no mínimo 18 anos.");
        }
    }

    private void validarCpf() {
        if (this.documentoCpf == null || this.documentoCpf.length() != 11) {
            throw new DomainException("Erro: O CPF é obrigatório e deve conter 11 dígitos.");
        }
    }

    private void validarEmail() {
        if (this.emailContato == null || !this.emailContato.contains("@")) {
            throw new DomainException("Erro: E-mail obrigatório e deve conter o caractere '@'.");
        }
    }

    private void validarTelefone() {
        if (this.telefoneCelular == null || this.telefoneCelular.length() != 11) {
            throw new DomainException("Erro: O telefone deve possuir exatamente 11 caracteres.");
        }
    }

   
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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