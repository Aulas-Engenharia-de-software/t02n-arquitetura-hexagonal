package com.fag.lucasmartins.arquitetura_software;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PessoaControllerAdapterIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCadastrarPessoaValida() throws Exception {
        String body = "{\n" +
                "  \"nomeCompleto\": \"Maria da Silva\",\n" +
                "  \"cpf\": \"12345678901\",\n" +
                "  \"dataNascimento\": \"1990-05-10\",\n" +
                "  \"email\": \"maria@email.com\",\n" +
                "  \"telefone\": \"45999999999\"\n" +
                "}";

        mockMvc.perform(post("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nomeCompleto").value("Maria da Silva"))
                .andExpect(jsonPath("$.cpf").value("12345678901"));
    }

    @Test
    void deveBloquearCadastroQuandoMenorDeIdade() throws Exception {
        String body = "{\n" +
                "  \"nomeCompleto\": \"Joao Menor\",\n" +
                "  \"cpf\": \"12345678901\",\n" +
                "  \"dataNascimento\": \"2012-05-10\",\n" +
                "  \"email\": \"joao@email.com\",\n" +
                "  \"telefone\": \"45999999999\"\n" +
                "}";

        mockMvc.perform(post("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Erro: A pessoa deve ter no mínimo 18 anos."));
    }
}
