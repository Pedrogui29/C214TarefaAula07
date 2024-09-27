# CI/CD Pipeline com GitHub Actions

## Descrição

Este projeto exemplifica a implementação de um pipeline de CI/CD usando **GitHub Actions**. O sistema gerencia notificações por meio de diferentes serviços (email e SMS), utilizando de injeção de dependências e testes. Além disso, o pipeline automatiza a execução de testes, o build e a notificação por email sobre o status do pipeline. Este projeto possui mais de 10 cenários de teste cobrindo diferentes casos de sucesso e falha, e Script em Python para envio de email.

## Alunos

- Pedro Guilherme Fernandes Oliveira
- Lucas Mendes Ribeiro do Couto

## Pré-requisitos

- **Java 19**: Para rodar o projeto e os testes.
- **Maven**: Para construir o projeto e rodar os testes.
- **GitHub Secrets** configurados para o envio de email:
  - `EMAIL_TO_NOTIFY`: Email do destinatário.
  - `EMAIL_USERNAME`: Email remetente (por exemplo, Gmail).
  - `EMAIL_PASSWORD`: Senha de aplicativo do Gmail ou de outro provedor SMTP.

## Como Rodar o Projeto Localmente

1. Clone o repositório e vá até o diretório do projeto:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
2. Instale as Dependências
   ```bash
   mvn install
3. Execute os testes
   ```bash
   mvn test
