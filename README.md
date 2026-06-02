# AntenaTech — Sistema de Vendas de Antenas

Projeto Final – NP2 | C06 – Programação Orientada a Objetos  
Prof. Christopher Lima

## Integrantes

- Dalmo Ney Vieira Neto  
- Enderson Augusto Rodrigues Santos  
- Esteban Mejía Calambas  
- Pedro de Souza Labastie  
- Rafael Yohanam Castellari de Figueiredo  

## Descrição

Sistema de vendas de antenas desenvolvido em Java. O cliente visualiza o catálogo, seleciona produtos, configura antenas direcionais, monta um carrinho e finaliza a compra. O recibo é exibido no terminal e salvo em arquivo. Um monitor de estoque roda em segundo plano alertando sobre produtos com baixo estoque.

## Diagrama UML
Disponível no arquivo `uml.pdf` na raiz do repositório.
## Uso de Inteligência Artificial

Sim, utilizamos IA no desenvolvimento deste projeto.

**Ferramentas:** ChatGPT (OpenAI) e Claude (Anthropic)

**Como foi utilizada:**
- Auxílio na implementação de partes específicas do código: Collections API, tratamento de exceções, manipulação de arquivos e threads
- Consultas sobre decisões de design, como avaliar se era necessário criar uma classe separada `NovaAntena`
- Apoio na escrita deste README

## 🏗️ Estrutura do Projeto

```
AntenaTech/
│
├── Main.java                        # Ponto de entrada da aplicação
│
├── Menu/
│   └── Menu.java                    # Fluxo principal: apresentação, cadastro e compra
│
├── Produto/
│   ├── Produto.java                 # Classe abstrata base de todos os produtos
│   └── Antena/
│       ├── Antena.java              # Classe abstrata que herda de Produto
│       ├── Direcional.java          # Interface para antenas direcionais
│       └── Antenas/
│           ├── Monopolo.java
│           ├── Dipolo.java          # Herda de Monopolo (composição de dois braços)
│           ├── Corneta.java
│           ├── Patch.java           # Implementa Direcional
│           ├── Yagi.java            # Implementa Direcional
│           └── Parabolica.java      # Implementa Direcional, usa Corneta como feed
│
├── Estoque/
│   ├── Estoque.java                 # Gerencia o catálogo de produtos
│   └── MonitorEstoque.java          # Thread de monitoramento de estoque baixo
│
├── Carrinho/
│   ├── Carrinho.java                # Agrupa encomendas de um cliente
│   └── Encomenda.java               # Representa um item adicionado ao carrinho
│
└── Arquivo/
    └── GerenciadorArquivo.java      # Leitura/escrita de arquivos (catálogo e compras)
```
