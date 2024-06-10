# suppliers-api

API desenvolvida em Java utilizando Spring Boot, com banco de dados PostgreSQL. O projeto está conteinerizado usando Docker, permitindo fácil configuração e execução.

## Pré-requisitos

### Sem Docker

- Java 17
- Maven
- PostgreSQL

### Com Docker

- Docker
- Docker Compose

## Configuração

### Sem Docker

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/Jeferson-Mendes/suppliers-api.git
    cd suppliers-api
    ```

2. **Configure o banco de dados PostgreSQL:**

    Crie um banco de dados PostgreSQL e um usuário. Anote as credenciais para serem usadas no `application.properties`.

3. **Configure o `application.properties`:**

    Abra o arquivo `src/main/resources/application.properties` e configure as propriedades do banco de dados conforme necessário. Inclua:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

4. **Instale as dependências e compile o projeto:**

    ```bash
    mvn clean install
    ```

5. **Execute a aplicação:**

	Utilizando a interface da sua IDE de preferência, ou executando o comando:
    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

### Com o Docker instalado

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/Jeferson-Mendes/suppliers-api.git
    cd suppliers-api

3. **Crie e execute seu aplicativo com o Compose:**

    ```bash
    docker compose up
    ```

    Isso irá construir as imagens Docker e iniciar os contêineres do PostgreSQL e da aplicação Spring Boot.

A aplicação estará disponível em `http://localhost:8080`.

## Estrutura do Projeto

- `src/main/java`: Código fonte Java
- `src/main/resources`: Arquivos de configuração, incluindo `application.properties`
- `Dockerfile`: Definição do contêiner Docker para a aplicação
- `docker-compose.yml`: Configuração do Docker Compose para a aplicação e banco de dados

## Endpoints da API

A API possui os seguintes endpoints:

- `GET /api/supplier?page=0&size=10&searchTerm=`: Lista todos os fornecedores, com paginação e opção de filtragem
- `GET /api/supplier/category/{categoria}?page=0&size=10&`: Lista os fornecedores pela categoria, com paginação
- `GET /api/supplier/{id}`: Busca um fornecedor pelo ID
- `POST /api/supplier`: Cria um novo fornecedor
- `PUT /api/supplier/{id}`: Atualiza um fornecedor existente
- `DELETE /api/supplier/{id}`: Deleta um fornecedor
