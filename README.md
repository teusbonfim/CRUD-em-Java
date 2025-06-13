# Sistema CRUD em Java (Desktop)

Este projeto é uma aplicação desktop simples desenvolvida em **Java** utilizando **Swing** para a interface gráfica e **MySQL** como banco de dados relacional. O objetivo é implementar um sistema completo de **Cadastro, Leitura, Atualização e Remoção (CRUD)** de clientes, aplicando os princípios da **programação orientada a objetos**.

## Objetivo

Desenvolver uma aplicação funcional, intuitiva e local para gerenciamento de dados de clientes, permitindo ao usuário:

- Adicionar novos clientes
- Visualizar todos os clientes cadastrados
- Atualizar dados de clientes existentes
- Remover clientes do banco de dados

## Tecnologias Utilizadas

- **Java SE**
- **Swing (javax.swing)**
- **MySQL**
- **JDBC (Java Database Connectivity)**
- **Eclipse IDE**

## Estrutura do Projeto

```

/SistemaCRUDJava
├── model/
│   └── Cliente.java
├── dao/
│   └── ClienteDAO.java
├── util/
│   └── Conexao.java
└── view/
└── TelaCliente.java

````

## Funcionalidades da Interface (TelaCliente)

- Campos para inserir `ID`, `Nome` e `Email`
- Botões de:
  - `Buscar Cliente`
  - `Adicionar Cliente`
  - `Atualizar Cliente`
  - `Remover Cliente`
- Lista com todos os clientes
- Preenchimento automático ao digitar um ID válido

## Banco de Dados

Banco: `sistema_crud`
Usuário: `root`
Senha: `Yondaime85@` 
Tabela: `clientes`

```sql
CREATE DATABASE IF NOT EXISTS sistema_crud;

USE sistema_crud;

DROP TABLE IF EXISTS clientes;

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);
````

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/CRUD-em-Java.git
   ```

2. Importe o projeto no Eclipse:

   * `File → Import → Existing Projects into Workspace`

3. Certifique-se de que:

   * O MySQL está rodando
   * O banco `sistema_crud` foi criado e a tabela `clientes` está pronta
   * A classe `Conexao.java` contém suas credenciais corretas de acesso

4. Execute a classe `view.TelaCliente.java`.

## Requisitos

* Java JDK 8 ou superior
* MySQL Server
* Eclipse IDE (ou outra IDE Java)
* Driver JDBC do MySQL (mysql-connector-java)

## 👥 Autores

* **Emilly Lima da Paz** – 242970012
* **Guilherme Trombini** – 242976502
* **Henrique Barreto** – 240879912
* **João Victor Felipe** – 242375692
* **Livia Conti Ferreira** – 242973102
* **Lucas das Neves** – 241831382
* **Mateus Bastos** – 240419922
* **Mateus Bonfim** – 241797152

---

## 📚 Licença

Projeto acadêmico sem fins comerciais, desenvolvido para fins didáticos e de prática em Java Desktop com integração a banco de dados.
