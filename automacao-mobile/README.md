# Automação Mobile com Java, Selenium, Cucumber e Appium

Este projeto tem como objetivo realizar testes automatizados de uma aplicação móvel utilizando **Java**, **Selenium**, **Cucumber** e **Appium**. A solução é construída utilizando o Maven para gerenciamento de dependências e execução dos testes.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para a criação dos testes.
- **Selenium**: Framework utilizado para automação de navegadores. Embora o foco principal seja a automação mobile com Appium, o Selenium é utilizado para facilitar a integração com os testes no ambiente web.
- **Appium**: Framework para automação de testes em dispositivos móveis (Android e iOS).
- **Cucumber**: Framework para testes BDD (Behavior Driven Development), utilizado para escrever os testes em um formato legível.
- **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
- **Allure**: Ferramenta para geração de relatórios bonitos e interativos dos testes realizados.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

automacao-mobile/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── automacao/
│ │ │ ├── pages/
│ │ │ └── steps/
│ │ └── resources/
│ │ └── features/
│ └── test/
│ ├── java/
│ │ └── com/
│ │ └── automacao/
│ └── resources/
│ └── testng.xml
└── pom.xml

### Descrição dos Diretórios

- **src/main/java/com/automacao/pages**: Contém as classes de página do projeto, representando as telas e componentes da aplicação.
- **src/main/java/com/automacao/steps**: Contém os passos do Cucumber, que implementam os cenários de testes.
- **src/main/resources/features**: Contém os arquivos `.feature`, onde os cenários de testes são descritos em linguagem Gherkin.
- **src/test/resources/testng.xml**: Arquivo de configuração para o TestNG.

## Configuração do Projeto

### Pré-requisitos

1. **Java**: Versão 23 ou superior instalada.
2. **Maven**: Para gerenciar dependências e build.
3. **Android Studio**: Para configurar o ambiente Android e executar testes em dispositivos reais ou emuladores.
4. **Appium**: Certifique-se de que o Appium está instalado e configurado corretamente.

### Instalação

## Configuração do Dispositivo ou Emulador

Para executar os testes em um dispositivo Android ou emulador, é necessário configurar o WebDriverManager para gerenciar o driver do dispositivo. O WebDriverManager automaticamente fará o download do driver correto para o dispositivo Android ou emulador que você deseja usar para os testes.

### Configuração no WebDriverManager

1. **Emulador**: Certifique-se de que o emulador Android está configurado corretamente no **Android Studio** e que o dispositivo está em execução.
2. **Dispositivo Real**: Se você estiver utilizando um dispositivo físico, conecte-o via USB e permita a depuração USB no dispositivo.
3. **Configuração no código**: O WebDriverManager pode ser configurado para utilizar o driver do dispositivo da seguinte forma:

Certifique-se de que o emulador Android está configurado para rodar de forma headless. Você pode iniciar um emulador Android sem interface gráfica com o comando:

```bash
emulator -avd <nome_do_avd> -no-window
```

## Instalando as Dependências

Dentro do diretório do projeto, execute o comando Maven para instalar as dependências:

```bash
mvn clean install
```

## Executando os Testes

Certifique-se de que o emulador Android está configurado para rodar de forma headless. Você pode iniciar um emulador Android sem interface gráfica com o comando:

```bash
emulator -avd <nome_do_avd> -no-window
```

Abra o servidor do appium com o comando:

```bash
appium
```

Para executar os testes, use o seguinte comando Maven:

```bash
mvn test
```

## Relatórios

Os relatórios dos testes podem ser visualizados após a execução, usando o Allure. Para gerar e visualizar o relatório, execute:

```bash
mvn allure:serve
```

## Dependências no pom.xml

As principais dependências do projeto incluem:

Cucumber: Para testes BDD.
Selenium: Para integração com o navegador.
Appium: Para automação de testes em dispositivos móveis.
Allure: Para relatórios interativos.
WebDriver Manager: Para gerenciar os drivers do navegador automaticamente.
