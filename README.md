# 🎰 Jogo do Bicho - Sistema Completo com Microserviços (API rest)

Este repositório contém um sistema completo do Jogo do Bicho, baseado em arquitetura de microserviços. Cada serviço tem uma responsabilidade bem definida, e a comunicação entre eles é feita via **Open Feign**. GameApp e BetApp utilizam autenticação com **OAuth2** e Spring security.

- > +25 endpoints
- > 24 Tipos de apostas com toda uma lógica de correção e validação implementada para cada uma delas (MILHAR_SECA,
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
- 🗺️ Spring Cloud Gateway

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

## 🔑 Guia dos caminhos (endpoints)

ConfigApp [8888]
- [GET] /{$service}/default : Captura configuração especifica daquele serviço

EurekaApp [8761]
- [GET] / : Painel do Eureka com serviços registrados

GameApp [1000]
- [POST] /api/jogo/oauth2/token?username={{username}}&password={{password}}&grant_type=password : Autenticação para receber JWT
- [POST] /api/jogo/house/register : Registra uma nova casa de aposta
- [POST/AUTH] /api/jogo/ : Cria um novo jogo
- [GET/AUTH] /api/jogo/house/games : Busca meus jogos (atrelados a minha banca)
- [POST/AUTH] /api/jogo/house/odds : Permite alterar as minhas odds 
- [GET/AUTH] /api/jogo/house/me : Exibe informações sobre mim (banca)
- [GET] /api/jogo/ : Exibe todos os jogos ja criados
- [GET] /api/jogo/{id} : Exibe jogo pelo id
- [GET] /api/jogo/data-ex : Exibe todos os jogos ja expirados (inválidos)
- [GET] /api/jogo/data-com : Exibe todos os jogos ainda válidos
- [GET] /api/jogo/house : Exibe todas as casas ja registradas 
- [GET] /api/jogo/house/calculate-amount?username={{username}}&betType={{betType}}&amount={{amount}} : Busca a banca de nome (user), puxa a odd do seu BetType e 
retorna o produto de amount * odd. Assim, simulando quanto ganharia caso apostasse nessa banca determinada quantia

BetApp [1002]
- [POST] /api/aposta/oauth2/token?username={{username}}&password={{password}}&grant_type=password : Autenticação para receber JWT
- [POST] /api/aposta/register : Registra um novo usuário
- [GET/AUTH] /api/aposta/me : Exibe informações sobre mim (user)
- [POST/AUTH] /api/aposta/ : Cria uma nova aposta
- [GET/AUTH/APIKEY] /api/aposta/api/bet/{id} : Busca aposta pelo id
- [GET/AUTH/APIKEY] /api/aposta/api/bet : Busca todas as apostas já realizadas 
- [GET/AUTH/APIKEY] /api/aposta/api/bet/user/{username} : Busca todas as apostas já realizadas por determinado usuário

ResultApp [1001]
- [POST] /api/resultado/ : Resolve todos os jogos expirados que ainda nao foram resolvidos
- [GET] /api/resultado/ : Busca todos os resultados
- [GET] /api/resultado/{id} : Busca todos os resultados pelo Id do jogo  

SettlementApp [1003] 
- [POST] /api/correcao/bet/{id} : Faz a correção pelo id da aposta
- [POST] /api/correcao/bet/user/{username} : Faz a correção de todas as apostas ja realizadas pelo usuário especificado

---

## ⚠️ Aviso

Este projeto é apenas para fins educacionais. O uso deste sistema para fins reais pode violar leis locais. Não me responsabilizo por qualquer uso indevido 😹

