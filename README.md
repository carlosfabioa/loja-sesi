#Sesi Store - Sistema de Carrinho de Compras
Descrição
Sesi Store é um sistema web desenvolvido em Spring Boot para gerenciar produtos, carrinhos de compras e usuários.
Ele foi desenvolvido como ferramenta de apoio aos estudos dos alunos do curso de TDS-NEM do Colégio SESI-Maringá.
O projeto permite que cada usuário cadastrado tenha seu próprio carrinho de compras, podendo adicionar, atualizar e remover produtos. 
A interface foi projetada para ser responsiva e intuitiva, utilizando Thymeleaf e o framework CSS Bootstrap.

Funcionalidades
Página inicial (Home):

Exibe todos os produtos cadastrados, incluindo suas fotos, nomes e preços.
Permite adicionar produtos ao carrinho de compras.
Carrinho de Compras:

Exibe apenas os itens do usuário logado.
Permite atualizar a quantidade de produtos.
Possibilidade de remover itens do carrinho.
Calcula e exibe o valor total do carrinho.
Gerenciamento de Usuários:

Cadastro de novos usuários com validação de dados.
Login seguro com senha criptografada.
Administração de Produtos:

CRUD completo para produtos (somente administradores).
Autenticação e Autorização:

Implementação de segurança com Spring Security.
Diferenciação de permissões entre usuários comuns e administradores.
Tecnologias Utilizadas
Backend
Java 17
Spring Boot 3.4
Spring MVC
Spring Data JPA
Spring Security
H2 Database (para testes)
MySQL (para produção)
Frontend
Thymeleaf (Template Engine)
Bootstrap 4 (Framework CSS)
Configuração do Ambiente
Pré-requisitos
Java 17+
Maven 3.8+
MySQL (ou H2 para testes)
Configuração do Banco de Dados
Configure o banco de dados no arquivo application.properties:

Para MySQL:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/minha_loja
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
Para H2 (teste):

properties
Copy code
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
Execute o script SQL (se necessário) para criar as tabelas no banco.

Executando o Projeto
Clone o repositório:

bash
Copy code
git clone https://github.com/seu-usuario/minha-loja.git
Navegue até o diretório do projeto:

bash
Copy code
cd minha-loja
Compile e execute o projeto:

bash
Copy code
mvn spring-boot:run
Acesse a aplicação em:

arduino
Copy code
http://localhost:8080
Rotas Principais
Usuários
/usuarios/novo: Cadastro de novo usuário.
/usuarios/login: Página de login.
Produtos
/produtos: Listagem e gerenciamento de produtos (somente administradores).
Carrinho
/carrinho: Exibe os itens do carrinho do usuário logado.
/carrinho/adicionar: Adiciona produtos ao carrinho.
/carrinho/atualizar: Atualiza a quantidade de itens no carrinho.
/carrinho/remover: Remove itens do carrinho.
Design da Interface
Cores
Cinza Claro, Preto e Branco.
Componentes
Navbar responsiva com links para:
Home
Carrinho
Logout
Grade de produtos exibida com imagens, nomes, preços e botões "Adicionar ao Carrinho".
Rodapé fixado na parte inferior da página.
To-Do
 Implementar testes unitários.
 Melhorar o design das páginas de gerenciamento de produtos.
 Adicionar suporte para upload de imagens.
 Internacionalização (i18n).
Contribuição
Sinta-se à vontade para contribuir com melhorias, relatando problemas ou enviando pull requests. 💡

Autor
Carlos
Professor e desenvolvedor, apaixonado por ensinar tecnologia e criar sistemas inovadores.
Licença
Este projeto está licenciado sob a MIT License.
