package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

import java.time.LocalDate;
import java.time.Period;

public class PessoaBO {

    public void validar(PessoaDTO pessoa) {
        if (pessoa.getNomeCompleto() == null || pessoa.getNomeCompleto().isBlank()) {
            throw new DomainException("Nome completo é obrigatório");
        }

        if (pessoa.getCpf() == null || pessoa.getCpf().length() != 11) {
            throw new DomainException("CPF deve ter 11 caracteres");
        }

        if (pessoa.getDataNascimento() == null) {
            throw new DomainException("Data de nascimento é obrigatória");
        }

        int idade = Period.between(pessoa.getDataNascimento(), LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("Pessoa deve ser maior de idade");
        }

        if (pessoa.getEmail() == null || !pessoa.getEmail().contains("@")) {
            throw new DomainException("Email inválido");
        }

        if (pessoa.getTelefone() == null || pessoa.getTelefone().isBlank()) {
            throw new DomainException("Telefone é obrigatório");
        }
    }
}