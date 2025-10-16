-- Migration: V1__criar_tabelas.sql
-- Responsável por criar as tabelas iniciais do projeto HealthBet


-- Migration: V2__carga_inicial.sql
-- Inserção de usuários iniciais para teste

INSERT INTO users (name, email, phone, birthdate)
VALUES
('Pedro Almeida', 'pedro@email.com', '11999999999', '2000-05-21'),
('Maria Souza', 'maria@email.com', '11988888888', '1998-11-03');
