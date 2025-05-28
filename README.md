# 🎰 Jogo do Bicho - Sistema Completo com Microserviços (API rest)

Este repositório contém um sistema completo do Jogo do Bicho, baseado em arquitetura de microserviços. Cada serviço tem uma responsabilidade bem definida, e a comunicação entre eles é feita via **Open Feign**. GameApp e BetApp utilizam autenticação com **OAuth2** e Spring security.

- > +25 endpoints
- > 24 Tipos de apostas (MILHAR_SECA,
    MILHAR_CERCADA,
    MILHAR_INVERTIDA_SECA,
    MILHAR_INVERTIDA_CERCADA,
    CENTENA_SECA,
    CENTENA_CERCADA,
    CENTENA_INVERTIDA_SECA,
    CENTENA_INVERTIDA_CERCADA,
    DEZENA_SECA,
    DEZENA_CERCADA,
    DEZENA_INVERTIDA_SECA,
    DEZENA_INVERTIDA_CERCADA,
    DUQUE_DE_DEZENA,
    TERNO_DE_DEZENA,
    GRUPO_SECO,
    GRUPO_CERCADO,
    DUPLA_DE_GRUPO_SECO,
    DUPLA_DE_GRUPO_CERCADO,
    TERNO_DE_GRUPO_SECO,
    TERNO_DE_GRUPO_CERCADO,
    PASSE_SECO,
    PASSE_CERCADO,
    PASSE_INVERTIDO_SECO,
    PASSE_INVERTIDO_CERCADO)


---

## 📦 Tecnologias Utilizadas

- ✅ Spring Boot
- 🔐 Spring Security + OAuth2
- ☁️ Spring Cloud Config
- 🎯 Eureka Discovery Server
- 📡 Open Feign
- 🗃️ JPA / Hibernate
- 🛠️ Spring DevTools
- 🔄 ModelMapper
- 🐘 PostgreSQL
- 📦 Maven

---

## 🧩 Estrutura dos Serviços

### 1. **EurekaApp**
> Servidor de registro de serviços (Service Discovery)

- Responsável por registrar e resolver os demais serviços da arquitetura.
- Baseado em **Spring Cloud Netflix Eureka**.

---

### 2. **ConfigApp**
> Servidor de configuração centralizada

- Fornece configurações externas a partir de um repositório Git. (https://github.com/Mizugue/config-repo-BichoMS).
- Utiliza **Spring Cloud Config Server**.

---

### 3. **GameApp**

![uml-jogobicho](https://github.com/user-attachments/assets/82844a43-6445-495d-b73e-2d708268d54f)


> Serviço de gestão das casas de apostas e jogos

- Permite o registro de uma **casa de apostas com as suas odds (banca)**.
- Após o registro, a banca pode **criar jogos**, definidos por uma `dataDeCaptura`, que determina a data de expiração do jogo. Logo, tal atributo vai ser quem possibilitará o resolvimento do jogo pelo ResultApp.

---

### 4. **BetApp**

![uml-apostabicho](https://github.com/user-attachments/assets/59c08752-a201-4e57-9b3d-3b764c33d06c)


> Serviço de gestão dos apostadores e apostas

- Permite o registro de **usuários apostadores** e o registro de apostas.
- Usuários podem criar apostas apenas em **jogos válidos** (com status válido).

---

### 5. **ResultApp**

![uml-resultadobicho](https://github.com/user-attachments/assets/e534dbc6-0c86-423c-9582-080fd609e003)


> Serviço de resolução de jogos

- Identifica **jogos expirados** com base na `dataDeCaptura` e resolve os mesmos.
- Gera um **resultado** contendo 5 números (5 milhares) e um `gameId` que referencia o jogo resolvido.
- Após isso, os jogos são marcados como **resolvidos**.
- - Obs: Seguindo o padrão das federais 😹

---

### 6. **SettlementApp**
> Serviço de correção de apostas

- Permite **corrigir uma aposta específica pelo ID**.
- Também permite corrigir **todas as apostas feitas por um usuário**.
- Para isso, busca a aposta e o resultado associado ao jogo.
- Retorna um objeto de resolvimento com o atributo amount, que indica o valor ganho, calculado com base no valor apostado e na odd da banca.

---

## 🔗 Comunicação entre os Serviços

Todos os serviços comunicam-se exclusivamente via **Open Feign**, garantindo desacoplamento e facilidade de manutenção.

---

## 🧠 Ordem lógica da aplicação

- A banca se registra e, em seguida, cria jogos.
- O usuário se registra e realiza apostas em jogos válidos.
- O operador do serviço de Resultados processa o resultado de todos os jogos expirados (ou seja, não válidos).
- O operador do serviço de Correção resolve as apostas referentes a jogos expirados que já foram resolvidos pelo serviço de Resultados.

---



