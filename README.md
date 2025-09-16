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
- Flyway (migrations)
- H2 (dev) / PostgreSQL (prod)
- Jakarta Validation

## Requisitos
- JDK 17+
- Maven

## Como rodar (dev com H2)
1. `mvn clean package`
2. `mvn spring-boot:run` ou executar a classe `ApiApplication`
3. A API ficará disponível em `http://localhost:8080`
4. H2 console: `http://localhost:8080/h2-console` (jdbc url: `jdbc:h2:mem:healthbet`)

## Endpoints
- `POST /users` — criar usuário
- `GET /users` — listar usuários
- `GET /users/{id}` — buscar por id
- `PUT /users/{id}` — atualizar
- `DELETE /users/{id}` — excluir

## Exemplo de requisições (curl)

Criar:
```bash
curl -X POST http://localhost:8080/users \
 -H "Content-Type: application/json" \
 -d '{"name":"João Silva", "email":"joao@example.com","phone":"11999999999","birthdate":"1990-05-10"}'
