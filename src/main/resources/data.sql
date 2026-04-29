-- Seed data para testes

INSERT INTO tb_pessoa (id, nome_completo, cpf, data_nascimento, email, telefone)
VALUES (1, 'Cliente Teste', '12345678901', '1990-01-15', 'cliente@teste.com', '41999999999');

INSERT INTO tb_produto (id, nome, estoque, preco, preco_final)
VALUES (1, 'Produto A', 100, 29.90, 29.90);

INSERT INTO tb_produto (id, nome, estoque, preco, preco_final)
VALUES (2, 'Produto B', 50, 49.90, 49.90);
