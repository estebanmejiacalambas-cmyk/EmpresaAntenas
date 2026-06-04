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

Sim, utilizamos ferramentas de Inteligência Artificial durante o desenvolvimento deste projeto.

**Ferramentas utilizadas:** ChatGPT (OpenAI) e Claude (Anthropic).

### Como a IA foi utilizada

As ferramentas de IA foram empregadas principalmente como apoio ao aprendizado, à implementação de funcionalidades específicas e à tomada de decisões durante o desenvolvimento do projeto.

#### Implementação e suporte técnico

Grande parte das consultas realizadas envolveu dúvidas relacionadas à implementação de funcionalidades utilizando os conteúdos abordados em sala de aula. Para isso, eram fornecidos à IA:

* O contexto e os objetivos do projeto;
* Trechos do código-fonte já desenvolvidos;
* Slides e materiais disponibilizados pelo professor;
* Requisitos e restrições definidos para o trabalho.

Frequentemente eram utilizados prompts como:

> "Tendo em vista esta ideia de projeto..."
> "Baseie-se exclusivamente no conteúdo presente nestes slides..."
> "Gostaria de ajuda para implementar esta funcionalidade..."

A IA foi utilizada principalmente para auxiliar em tópicos nos quais houve maior dificuldade de implementação, como:

* Collections API;
* Tratamento de exceções;
* Manipulação de arquivos;
* Threads.

Após receber uma solução considerada satisfatória, era comum solicitar uma explicação detalhada do código gerado, incluindo comentários e descrições linha por linha, com o objetivo de compreender o funcionamento da implementação e não apenas utilizá-la.

#### Correção de erros e depuração

Outra utilização importante foi no processo de identificação e correção de erros.

Quando surgiam problemas cujo motivo não era facilmente identificado, eram enviados à IA os trechos relevantes do código juntamente com uma descrição detalhada do comportamento observado. Além de localizar a causa do problema, a IA também era solicitada a propor soluções que exigissem o menor número possível de alterações na estrutura já existente.

Essa preocupação era constantemente reforçada nos prompts, pois alterações excessivas poderiam introduzir novos erros ou comprometer partes do sistema que já estavam funcionando corretamente.

#### Apoio em decisões de design

A IA também foi utilizada como ferramenta de apoio para decisões de design e arquitetura do software.

Nesses casos, eram fornecidos:

* Os slides e materiais das aulas;
* O documento contendo os requisitos do projeto;
* As ideias e alternativas inicialmente consideradas pela equipe.

A partir dessas informações, a IA auxiliava na análise das diferentes opções, sugerindo vantagens, desvantagens e, em alguns casos, apresentando alternativas adicionais. Um exemplo desse tipo de consulta foi a avaliação sobre a necessidade de criar uma classe específica (`NovaAntena`) para representar determinadas funcionalidades do sistema.

As recomendações recebidas serviram como apoio para a tomada de decisões mais fundamentadas durante o desenvolvimento.

#### Apoio na documentação

Por fim, a IA foi utilizada para auxiliar na elaboração e organização deste README.

Inicialmente, foi fornecido à ferramenta o documento de avaliação do projeto para que ela gerasse uma estrutura inicial da documentação. Posteriormente, o conteúdo produzido foi revisado, ajustado e complementado manualmente, de modo a refletir com maior precisão as características do projeto e atender às expectativas da equipe.


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
