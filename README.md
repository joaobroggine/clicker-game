# 🎮 Job Clicker Game

Um jogo clicker desenvolvido em Java com JavaFX e Spring Boot, onde você começa do zero e trabalha para construir seu império financeiro!

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen)
![JavaFX](https://img.shields.io/badge/JavaFX-21.0.2-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)

## 📋 Sobre o Projeto

**Job Clicker** é um jogo idle/clicker onde você clica para ganhar dinheiro e pode comprar diversos itens que geram renda passiva. O jogo conta com um sistema de conquistas, loja de itens, e até uma funcionalidade de apostas para os jogadores que gostam de arriscar!

### ✨ Características Principais

- 🖱️ **Sistema de Cliques**: Ganhe dinheiro a cada clique
- 🏪 **Loja Completa**: Compre itens que geram renda passiva
- 🏆 **Sistema de Conquistas**: Diversas conquistas para desbloquear
- 🎰 **Sistema de Apostas**: Arrisque seu dinheiro com chance de ganhar o dobro
- 💰 **Renda Passiva**: Itens que geram dinheiro automaticamente
- 🎯 **Progressão**: Desbloqueie novos itens conforme avança

## 🚀 Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal
- **JavaFX 21.0.2**: Framework para interface gráfica
  - javafx-controls
  - javafx-fxml
  - javafx-media
  - javafx-swing
- **Spring Boot 3.5.5**: Framework para gerenciamento de dependências e configuração
- **Lombok 1.18.32**: Redução de código boilerplate
- **Maven**: Gerenciamento de build e dependências

## 📦 Estrutura do Projeto

```
clicker-game/
├── src/main/java/br/com/git/clicker_game/
│   ├── config/           # Configurações do Spring Context
│   ├── core/             # Lógica central do jogo
│   │   ├── AchievementManager.java
│   │   ├── GameManager.java
│   │   └── SoundManager.java
│   ├── model/            # Modelos de dados
│   │   ├── Achievement.java
│   │   ├── Count.java
│   │   └── Inventory.java
│   ├── view/             # Interfaces gráficas
│   │   ├── Interface.java
│   │   ├── Menu.java
│   │   ├── Bet.java
│   │   └── AchievementScreen.java
│   ├── utils/            # Utilitários
│   │   └── DialogUtils.java
│   └── ClickerGameApplication.java
├── pom.xml
└── README.md
```

## 🔧 Instalação e Execução

### Pré-requisitos

- Java 21 ou superior
- Maven 3.x

### Passos para Executar

1. **Clone o repositório**
```bash
git clone https://github.com/joaobroggine/clicker-game.git
cd clicker-game
```

2. **Compile o projeto**
```bash
mvn clean install
```

3. **Execute o jogo**
```bash
mvn spring-boot:run
```

Ou execute diretamente a classe principal:
```bash
java -jar target/clicker-game-0.0.1-SNAPSHOT.jar
```

### Usando Maven Wrapper

Se preferir usar o Maven Wrapper incluído no projeto:

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

## 🎮 Como Jogar

1. **Início**: Clique no botão "Get Money" para ganhar dinheiro
2. **Loja**: Acesse a loja para comprar itens que geram renda passiva
3. **Conquistas**: Verifique seu progresso na tela de conquistas
4. **Apostas**: Após comprar um PC, teste sua sorte no 777 BET
5. **Estratégia**: Equilibre entre comprar geradores de renda e fazer upgrades

## 🎨 Arquitetura do Código

### Padrões Utilizados

- **MVC (Model-View-Controller)**: Separação clara entre modelo, visão e controle
- **Singleton Pattern**: GameManager e AchievementManager
- **Observer Pattern**: Uso de JavaFX Properties para binding reativo
- **Dependency Injection**: Spring Boot para gerenciamento de dependências

### Destaques Técnicos

- **Threading**: Sistema de renda passiva usando threads para atualização em tempo real
- **Data Binding**: Uso de `IntegerProperty` para atualização automática da UI
- **Event Handling**: Gestão de eventos JavaFX para interações do usuário
- **Dialog System**: Utilitário centralizado para mensagens ao jogador

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:

1. Fazer um fork do projeto
2. Criar uma branch para sua feature (`git checkout -b feature/NovaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/NovaFeature`)
5. Abrir um Pull Request
