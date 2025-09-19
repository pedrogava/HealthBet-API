# HealthBet-API
- Pedro Gava / RM 551043
- Fernanda Kaory / RM 551104
- Pedro Menezes / RM 97432
- Anny Dias / RM 98295
- Henrique Lima / RM 551528

API REST simples para gerenciamento de usuários do projeto HealthBet.

## Tecnologias
- Java 17+
- Spring Boot
- Spring Data JPA
- Jakarta Validation

## Requisitos
- JDK 17+
- Maven

## How to Run
1. `mvn clean package`
2. `mvn spring-boot:run` ou executar a classe `ApiApplication`
3. A API ficará disponível em `http://localhost:8080/users`


## Endpoints
- `POST /users` — criar usuário
- `GET /users` — listar usuários
- `GET /users/{id}` — buscar por id
- `PUT /users/{id}` — atualizar
- `DELETE /users/{id}` — excluir

## Exemplo de teste

Criar:
{
    "name":"João Silva",
    "email":"joao@example.com",
    "phone":"11999999999",
    "birthdate":"1990-05-10"
}
