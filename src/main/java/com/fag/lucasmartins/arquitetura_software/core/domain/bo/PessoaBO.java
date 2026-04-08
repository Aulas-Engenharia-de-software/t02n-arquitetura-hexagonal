package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {
    private final UUID id;
    private final String nomeCompleto;
    private final String cpf;
    private final LocalDate dataNascimento;
    private final String email;
    private final String telefone;

   
    public PessoaBO(String nomeCompleto, String cpf, LocalDate dataNascimento,
                    String email, String telefone) {
        this(UUID.randomUUID(), nomeCompleto, cpf, dataNascimento, email, telefone);
    }

    // Construtor para reidratação (vindo do banco)
    public PessoaBO(UUID id, String nomeCompleto, String cpf, LocalDate dataNascimento,
                    String email, String telefone) {
        this.id = id;
        this.nomeCompleto = validarNome(nomeCompleto);
        this.cpf = validarCpf(cpf);
        this.dataNascimento = validarIdade(dataNascimento);
        this.email = validarEmail(email);
        this.telefone = validarTelefone(telefone);
    }

    // Getters
    public UUID getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }

    // Validações (regras de negócio)
    private String validarNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new DomainException("Nome completo é obrigatório");
        return nome;
    }

    private String validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+"))
            throw new DomainException("CPF deve conter exatamente 11 dígitos numéricos");
        return cpf;
    }

    private LocalDate validarIdade(LocalDate dataNasc) {
        if (dataNasc == null)
            throw new DomainException("Data de nascimento é obrigatória");
        int idade = Period.between(dataNasc, LocalDate.now()).getYears();
        if (idade < 18)
            throw new DomainException("Idade mínima de 18 anos não atendida");
        return dataNasc;
    }

    private String validarEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new DomainException("E-mail inválido (deve conter '@')");
        return email;
    }

    private String validarTelefone(String telefone) {
        if (telefone == null || telefone.length() != 11 || !telefone.matches("\\d+"))
            throw new DomainException("Telefone deve conter exatamente 11 dígitos numéricos");
        return telefone;
    }
}