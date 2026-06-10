# Sistema ERP em Java

Este projeto consiste no desenvolvimento de um sistema ERP (Enterprise Resource Planning) voltado para a gestão comercial de uma empresa. O sistema foi desenvolvido em Java com foco na aplicação dos principais conceitos de Programação Orientada a Objetos.

O objetivo do projeto é simular o funcionamento de um ambiente empresarial, integrando diferentes setores administrativos em uma única aplicação, como controle de usuários, estoque, produtos, vendas, compras, financeiro e relatórios.

## Objetivo

O sistema tem como objetivo centralizar e organizar informações comerciais de uma empresa, permitindo maior controle sobre operações internas e facilitando a integração entre os módulos do sistema.

Entre os principais objetivos do projeto estão:

- Aplicar conceitos de Programação Orientada a Objetos;
- Organizar o sistema em classes com responsabilidades específicas;
- Simular o funcionamento básico de um ERP comercial;
- Controlar produtos, estoque, vendas, compras e movimentações financeiras;
- Gerar relatórios administrativos;
- Trabalhar com armazenamento de dados em memória utilizando estruturas como HashMap.

## Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- Git
- GitHub
- Interface via console
- UML para modelagem do sistema

## Principais Funcionalidades

O sistema foi planejado para possuir os seguintes módulos:

| Módulo | Funcionalidade |
|---|---|
| Usuários | Cadastro, autenticação e controle de permissões |
| Produtos | Cadastro e gerenciamento de produtos |
| Estoque | Controle de entrada, saída e consulta de produtos |
| Vendas | Registro de vendas e cálculo de valor total |
| Compras | Registro de compras e atualização de estoque |
| Financeiro | Controle de receitas, despesas e saldo |
| Relatórios | Emissão de relatórios de vendas, estoque e financeiro |

## Funcionalidades do Sistema

O ERP possui funcionalidades como:

- Login e autenticação de usuários;
- Cadastro de usuários com diferentes perfis;
- Controle de permissões para gerente e funcionário;
- Cadastro de produtos alimentícios, eletrônicos e de limpeza;
- Atualização de preços e quantidades em estoque;
- Verificação de validade para produtos alimentícios;
- Registro de vendas;
- Cálculo automático de subtotal e valor total da venda;
- Baixa automática de produtos no estoque após uma venda;
- Registro de compras de fornecedores;
- Aprovação de compras pelo gerente;
- Registro de receitas e despesas;
- Associação entre vendas e movimentações financeiras;
- Geração de relatórios administrativos;
- Busca de registros por ID.

> Observação: algumas funcionalidades podem estar em desenvolvimento ou podem ter sido alteradas conforme a versão atual do código.

## Conceitos de Programação Orientada a Objetos Aplicados

Durante o desenvolvimento do projeto foram aplicados diversos conceitos de POO, incluindo:

### Encapsulamento

Os atributos das classes são protegidos e acessados por meio de métodos específicos, como getters e setters. Isso evita alterações indevidas nos dados internos dos objetos.

### Herança

A herança foi utilizada para reaproveitar atributos e métodos entre classes semelhantes.

Exemplos:

- `Usuario` → `Gerente` e `Funcionario`
- `Produto` → `ProdutoAlimenticio`, `ProdutoEletronico` e `ProdutoLimpeza`
- `Relatorio` → `RelatorioVenda`, `RelatorioFinanceiro` e `RelatorioEstoque`

### Abstração

Classes abstratas foram utilizadas para representar estruturas genéricas do sistema, como usuários, produtos e relatórios.

### Polimorfismo

O polimorfismo permite que subclasses implementem comportamentos específicos, mantendo uma estrutura comum entre objetos relacionados.

### Composição

A composição aparece na relação entre `Venda` e `ItemVenda`, pois uma venda pode possuir vários itens associados.

### Agregação

A agregação aparece em módulos como `Estoque` e `Financeiro`, que trabalham com produtos, receitas e despesas sem depender totalmente da existência desses objetos.

## Principais Classes do Projeto

O sistema foi planejado com uma estrutura modular. Entre as principais classes estão:

| Classe | Responsabilidade |
|---|---|
| `Usuario` | Representa os usuários do sistema |
| `Gerente` | Usuário com permissões administrativas |
| `Funcionario` | Usuário responsável por operações comerciais |
| `Produto` | Classe base para os produtos |
| `ProdutoAlimenticio` | Produto com controle de validade |
| `ProdutoEletronico` | Produto com informações como fabricante, garantia e voltagem |
| `ProdutoLimpeza` | Produto relacionado ao setor de limpeza |
| `Estoque` | Gerencia os produtos disponíveis |
| `Venda` | Registra operações de venda |
| `ItemVenda` | Representa cada item dentro de uma venda |
| `Compra` | Registra compras realizadas com fornecedores |
| `Financeiro` | Controla receitas, despesas e saldo |
| `Receita` | Representa entradas financeiras |
| `Despesa` | Representa saídas financeiras |
| `Relatorio` | Classe base para relatórios |
| `RelatorioVenda` | Relatório relacionado às vendas |
| `RelatorioFinanceiro` | Relatório relacionado ao setor financeiro |
| `RelatorioEstoque` | Relatório relacionado ao estoque |

## Fluxo Geral do Sistema

O funcionamento do sistema começa com a autenticação do usuário. Após o login, o sistema verifica o perfil do usuário e libera as funcionalidades correspondentes.

Funcionários podem realizar operações como consulta de produtos e registro de vendas. Gerentes possuem permissões mais amplas, como aprovação de compras, análise financeira e emissão de relatórios.

Quando uma venda é finalizada, o sistema atualiza automaticamente o estoque e registra a movimentação financeira correspondente. Da mesma forma, quando uma compra é aprovada, o estoque é atualizado com os produtos adquiridos.

## Estrutura Esperada do Projeto

A estrutura do projeto pode variar conforme a organização dos arquivos, mas uma estrutura recomendada seria:

```text
Projeto_java_TPAE/
├── src/
│   ├── Main.java
│   ├── Usuario.java
│   ├── Gerente.java
│   ├── Funcionario.java
│   ├── Produto.java
│   ├── ProdutoAlimenticio.java
│   ├── ProdutoEletronico.java
│   ├── ProdutoLimpeza.java
│   ├── Estoque.java
│   ├── Venda.java
│   ├── ItemVenda.java
│   ├── Compra.java
│   ├── Financeiro.java
│   ├── Receita.java
│   ├── Despesa.java
│   └── Relatorio.java
└── README.md
