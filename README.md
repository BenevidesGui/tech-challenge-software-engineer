# Insurance API

API responsável pelo cálculo de seguros baseada em regras de estratégia.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Bean Validation (Jakarta Validation)
- Springdoc OpenAPI (Swagger)
- JUnit 5
- Mockito
- JaCoCo

---

## 📌 Funcionalidades

- Cálculo de seguro baseado no valor do veículo
- Aplicação de estratégias de negócio (Strategy Pattern)
- Validação de entrada com Bean Validation
- Tratamento global de exceções
- API documentada com Swagger

---

## 📥 Endpoint principal

### POST /insurance

Calcula o valor do seguro para um cliente.

### RequestBody Test

```json
{
  "customer": {
    "name": "João",
    "document": "123.456.789-10",
    "birthday": "1990-07-10",
    "location": "SP",
    "vehicle_value": 50000
  }
}
```
---
## 📚 Swagger (Documentação da API)

A documentação interativa da API pode ser acessada através do Swagger UI:

👉 http://localhost:8080/swagger-ui/index.html



---
## 🧪 Testes
- Testes unitários para as estratégias de cálculo
- Testes de integração para o endpoint de cálculo de seguro
- Cobertura de testes com JaCoCo
- Testes de validação de entrada e tratamento de erros
- Testes de casos de borda para diferentes faixas de valor do veículo
- Testes de performance para garantir resposta rápida mesmo com regras complexas
- Testes de segurança para validar a proteção contra entradas maliciosas

### 📂 Gerar o relatório

```
mvn clean test
```


Após rodar os testes, abra o arquivo gerado:

target/site/jacoco/index.html

---
## 📂 Estrutura do projeto

```src
├── main
│   ├── java
│   │   └── com.example.insuranceapi
│   │       ├── controller
│   │       ├── service
│   │       ├── strategy
│   │       ├── model
│   │       └── exception
│   └── resources
│       └── application.properties
└── test
    ├── java
    │   └── com.example
    │       ├── controller
    │       ├── service
    │       ├── strategy
    │       └── exception
    └── resources
```
---
## 🧱 Arquitetura

A aplicação segue uma arquitetura em camadas:

- Controller → entrada da API
- Service → regra de negócio
- Strategy → regras de cálculo de seguro
- Exception Handler → tratamento global de erros

---
## Design Patterns Utilizados
- Strategy Pattern: Para encapsular as diferentes estratégias de cálculo de seguro com base no valor do veículo.

---
## 📈 Métricas de Qualidade
- Cobertura de testes: 100%
- Logging: Implementado para rastreamento de erros e monitoramento
- Tratamento de erros: Global com mensagens claras para o cliente
- Documentação: Completa e atualizada com Swagger