# 🎰 Jogo do Bicho - Sistema de Correção com Microserviços

Este repositório contém um sistema completo do Jogo do Bicho, baseado em arquitetura de microserviços. Cada serviço tem uma responsabilidade bem definida, e a comunicação entre eles é feita via **Open Feign**. GameApp e BetApp utilizam autenticação com **OAuth2** e Spring security.

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
> Serviço de gestão das casas de apostas e jogos

- Permite o registro de uma **casa de apostas com as suas odds (banca)**.
- Após o registro, a banca pode **criar jogos**, definidos por uma `dataDeCaptura`, que determina a data de expiração do jogo. Logo, tal atributo vai ser quem possibilitará o resolvimento do jogo pelo ResultApp.

---

### 4. **BetApp**
> Serviço de gestão dos apostadores e apostas

- Permite o registro de **usuários apostadores** e o registro de apostas.
- Usuários podem criar apostas apenas em **jogos válidos** (com status válido).

---

### 5. **ResultApp**
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



