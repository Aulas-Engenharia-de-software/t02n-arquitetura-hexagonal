package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PessoaBOTest {

    @Test
    void deveCadastrarPessoaValida() {
        PessoaBO pessoa = pessoaValida();

        assertDoesNotThrow(pessoa::prepararCadastro);
        assertNotNull(pessoa.getId());
    }

    @Test
    void deveBloquearQuandoMenorDeIdade() {
        PessoaBO pessoa = pessoaValida();
        pessoa.setDataNascimento(LocalDate.now().minusYears(17));

        assertThrows(DomainException.class, pessoa::prepararCadastro);
    }

    @Test
    void deveBloquearQuandoCpfInvalido() {
        PessoaBO pessoa = pessoaValida();
        pessoa.setCpf("12345");

        assertThrows(DomainException.class, pessoa::prepararCadastro);
    }

    @Test
    void deveBloquearQuandoTelefoneInvalido() {
        PessoaBO pessoa = pessoaValida();
        pessoa.setTelefone("4499999");

        assertThrows(DomainException.class, pessoa::prepararCadastro);
    }

    @Test
    void deveBloquearQuandoEmailInvalido() {
        PessoaBO pessoa = pessoaValida();
        pessoa.setEmail("emailinvalido.com");

        assertThrows(DomainException.class, pessoa::prepararCadastro);
    }

    private PessoaBO pessoaValida() {
        PessoaBO pessoa = new PessoaBO();
        pessoa.setNomeCompleto("Lucas Martins");
        pessoa.setCpf("12345678901");
        pessoa.setDataNascimento(LocalDate.now().minusYears(20));
        pessoa.setEmail("lucas@email.com");
        pessoa.setTelefone("44999998888");
        return pessoa;
    }
}