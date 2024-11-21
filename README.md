# Sesi Store - Sistema de Carrinho de Compras
## Descrição
Sesi Store é um sistema web desenvolvido em Spring Boot para gerenciar produtos, carrinhos de compras e usuários.
Ele foi desenvolvido como ferramenta de apoio aos estudos dos alunos do curso de TDS-NEM do Colégio SESI-Maringá.
O projeto permite que cada usuário cadastrado tenha seu próprio carrinho de compras, podendo adicionar, atualizar e remover produtos. 
A interface foi projetada para ser responsiva e intuitiva, utilizando Thymeleaf e o framework CSS Bootstrap.

## Funcionalidades
* Exibe todos os produtos cadastrados, incluindo suas fotos, nomes e preços.
* Permite adicionar produtos ao carrinho de compras.

### Carrinho de Compras:
* Exibe apenas os itens do usuário logado.
* Permite atualizar a quantidade de produtos.
* Possibilidade de remover itens do carrinho.
* Calcula e exibe o valor total do carrinho.

### Gerenciamento de Usuários:
* Cadastro de novos usuários com validação de dados.
* Login seguro com senha criptografada.

### Administração de Produtos:
* CRUD completo para produtos (somente administradores).

### Autenticação e Autorização:
* Implementação de segurança com Spring Security.
* Diferenciação de permissões entre usuários comuns e administradores.

### Tecnologias Utilizadas
#### Backend
* Java 21
* Spring Boot 3.4
* Spring MVC
* Spring Data JPA
* Spring Security
* H2 Database (para testes)
* MySQL (para produção)

#### Frontend
* Thymeleaf (Template Engine)
* Bootstrap 4 (Framework CSS)

### Configuração do Ambiente
#### Pré-requisitos
* Java 21+
* Maven 3.8+
* MySQL (ou H2 para testes)

### Configuração do Banco de Dados
Configure o banco de dados no arquivo application.properties:
#### Para MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/minha_loja
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

#### Para H2 (teste):
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
Execute o script SQL (se necessário) para criar as tabelas no banco.


## Rotas Principais
### Usuários
* /usuarios/novo: Cadastro de novo usuário.
* /usuarios/login: Página de login.

### Produtos
* /produtos: Listagem e gerenciamento de produtos (somente administradores).

### Carrinho
* /carrinho: Exibe os itens do carrinho do usuário logado.
* /carrinho/adicionar: Adiciona produtos ao carrinho.
* /carrinho/atualizar: Atualiza a quantidade de itens no carrinho.
* /carrinho/remover: Remove itens do carrinho.

# To-Do
## Melhorias no Frontend
- [ ] Adicionar responsividade total para dispositivos móveis e tablets.
- [ ] Criar uma página de perfil do usuário:
- [ ] Permitir que o usuário atualize nome, email e senha.
- [ ] Mostrar o histórico de pedidos realizados.
- [ ] Implementar uma página para detalhes do produto, mostrando:
- [ ] Descrição detalhada.
- [ ] Disponibilidade em estoque.
- [ ] Avaliações de outros usuários (ver abaixo).
- [ ]  Melhorar o design da página inicial:
- Adicionar seções de destaque para promoções ou categorias específicas.
- Usar carrosséis ou sliders para exibir produtos em destaque.
- Personalizar mensagens de erro e validação no frontend.

## Outras Funcionalidades
- [ ] Implementar o sistema de pedidos:
- [ ] Criar uma página para finalizar compra.
- [ ] Gerar pedidos a partir do carrinho.
- [ ] Salvar histórico de pedidos no banco de dados.
- [ ] Enviar email de confirmação para o usuário após a compra.
 
## Implementar avaliações de produtos:
- [ ] Permitir que usuários logados avaliem produtos.
- [ ] Exibir média de avaliações e comentários na página do produto.
- [ ] Adicionar suporte para upload de imagens no cadastro de produtos.
- [ ] Criar uma página de busca:
- [ ] Permitir pesquisar produtos por nome ou categoria.
- [ ] Adicionar filtros (preço, avaliação, etc.).
 
## Implementar categorias de produtos:
- [ ] Criar CRUD para categorias (somente administradores).
- [ ] Associar produtos a categorias.
- [ ] Permitir navegação por categoria na página inicial.

## Segurança
 - [ ] Configurar autenticação JWT para maior segurança em APIs REST (se necessário no futuro).
 - [ ] Implementar limites de tentativas de login para prevenir ataques de força bruta.
 - [ ] Adicionar autenticação multifator (MFA) opcional para usuários.
 - [ ] Proteger rotas administrativas com permissões baseadas em papéis (Role-Based Access Control).
 - [ ] Revisar e configurar regras de CSRF (Cross-Site Request Forgery).

## Melhorias no Backend
 - [ ] Refatorar o código para garantir a aplicação de princípios SOLID.
 - [ ] Implementar validações personalizadas para campos de entrada no backend.
 - [ ] Adicionar testes unitários para serviços e controladores:
 - [ ] Testes para CRUD de produtos.
 - [ ] Testes para funcionalidade de login.
 - [ ] Testes para operações no carrinho de compras.
 - [ ] Criar testes de integração para fluxo de pedidos e carrinho.
 - [ ] Adicionar suporte para logs detalhados usando frameworks como Logback ou SLF4J.
 - [ ] Configurar envio de emails com Spring Mail para notificações (confirmações de pedido, redefinição de senha, etc.).
## Melhorar a performance das consultas ao banco de dados:
 - [ ] Implementar cache para consultas frequentes usando Spring Cache ou Redis.
 - [ ] Otimizar índices no banco de dados para melhorar consultas relacionadas a carrinhos e pedidos.

## Melhorias na Infraestrutura
### Configurar um ambiente de produção:
- [ ] Usar um servidor web como Apache ou Nginx para hospedar a aplicação.
- [ ] Configurar um banco de dados MySQL em um servidor dedicado.
- [ ] Criar um arquivo Docker para containerizar o projeto.
- [ ]  Configurar um pipeline de CI/CD usando ferramentas como GitHub Actions ou Jenkins.
- [ ]  Implementar monitoramento do servidor com ferramentas como Prometheus ou Grafana.
- [ ]  Automatizar backups do banco de dados.

## Experiência do Usuário
- [ ]  Adicionar notificações ou mensagens de feedback (ex.: "Produto adicionado ao carrinho").
- [ ]  Permitir que usuários favoritem produtos para uma lista de desejos.
- [ ]  Exibir um resumo do carrinho no menu principal ou no rodapé.
- [ ]  Criar um painel administrativo para gerenciar:
** Usuários.
** Produtos.
** Pedidos.

## Escalabilidade e Expansão
- [ ]  Criar uma API REST para permitir integração com aplicativos móveis.
- [ ]  Internacionalizar o sistema (i18n):
- [ ] Adicionar suporte para múltiplos idiomas (ex.: português e inglês).
- [ ] Permitir troca de moeda (ex.: R$, US$).
- [ ]  Adicionar um sistema de vouchers/cupom de desconto.
- [ ]  Integrar com serviços de pagamento como PagSeguro, Stripe ou PayPal.
- [ ]  Integrar com serviços de entrega (ex.: correios, transportadoras).


# Contribuição
Sinta-se à vontade para contribuir com melhorias, relatando problemas ou enviando pull requests.

## Licença
Este projeto está licenciado sob a MIT License.
