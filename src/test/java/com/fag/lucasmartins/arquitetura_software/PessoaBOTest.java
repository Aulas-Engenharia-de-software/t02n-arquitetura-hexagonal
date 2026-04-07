package com.fag.lucasmartins.arquitetura_software;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PessoaBOTest {

    @Test
    void deveCriarPessoaValida() {
        UUID id = UUID.randomUUID();
        PessoaBO pessoa = new PessoaBO(id, "João Silva", "12345678901", LocalDate.of(1990, 1, 1), "joao@example.com", "11987654321");

        assertEquals(id, pessoa.getId());
        assertEquals("João Silva", pessoa.getNomeCompleto());
        assertEquals("12345678901", pessoa.getCpf());
        assertEquals(LocalDate.of(1990, 1, 1), pessoa.getDataNascimento());
        assertEquals("joao@example.com", pessoa.getEmail());
        assertEquals("11987654321", pessoa.getTelefone());
    }

    @Test
    void deveLancarExcecaoParaMenorDeIdade() {
        DomainException exception = assertThrows(DomainException.class, () -> {
            new PessoaBO(UUID.randomUUID(), "Maria Silva", "12345678901", LocalDate.of(2010, 1, 1), "maria@example.com", "11987654321");
        });
        assertEquals("Erro: O cliente deve ter no mínimo 18 anos.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoParaCpfInvalido() {
        DomainException exception = assertThrows(DomainException.class, () -> {
            new PessoaBO(UUID.randomUUID(), "Pedro Silva", "123", LocalDate.of(1990, 1, 1), "pedro@example.com", "11987654321");
        });
        assertEquals("Erro: O CPF deve ter exatamente 11 caracteres.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoParaEmailInvalido() {
        DomainException exception = assertThrows(DomainException.class, () -> {
            new PessoaBO(UUID.randomUUID(), "Ana Silva", "12345678901", LocalDate.of(1990, 1, 1), "anaexample.com", "11987654321");
        });
        assertEquals("Erro: O e-mail deve conter '@'.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoParaTelefoneInvalido() {
        DomainException exception = assertThrows(DomainException.class, () -> {
            new PessoaBO(UUID.randomUUID(), "Carlos Silva", "12345678901", LocalDate.of(1990, 1, 1), "carlos@example.com", "119876543");
        });
        assertEquals("Erro: O telefone deve ter exatamente 11 caracteres.", exception.getMessage());
    }
}