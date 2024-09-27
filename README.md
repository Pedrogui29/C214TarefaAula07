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

## Configuração do Pipeline

O pipeline está configurado para rodar automaticamente no GitHub Actions sempre que houver um push na branch main. E possui as seguintes etapas:

- **Testes**: Executa os testes do projeto
- **Build**: Empacota o projeto em um arquivo .jar após a execução dos testes.
- **Notificação por Email**: Envia um email com o status do pipeline (sucesso ou falha) usando um script em Python.

As etapas de Build e Notificação são executadas em paralelo após a etapa de Testes.

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
