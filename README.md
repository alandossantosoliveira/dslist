# DSList
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/alandossantosoliveira/dslist/blob/main/LICENSE) 

# Sobre o projeto

https://dslist-production-67c8.up.railway.app/games

DSList é uma aplicação back end web construída durante um evento da **Semana DevSuperior**, evento organizado pela [DevSuperior](https://devsuperior.com "Site da DevSuperior").

A aplicação consiste em uma lista qualquer de games, onde esses games tem categorias (dominio/lists). Na tela onde é listado os games é possível alterar a posição dos games. Por exemplo, o quarto game da lista de jogos "Jogos de plataforma" (/lists/2/games) é o "Cuphead". Posso movê-lo de uma posição para outra na lista num front end que clica e arrasta o item.

## Modelo conceitual
![Modelo Conceitual](https://github.com/acenelio/assets/raw/main/sds1/modelo-conceitual.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
  
## Implantação em produção
- Back end: Railway
- Banco de dados: Postgresql

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/alandossantosoliveira/dslist

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Alan dos Santos Oliveira

https://www.linkedin.com/in/alan-oliveira-b914b213a/
