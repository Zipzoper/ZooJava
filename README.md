# ZooJava
Sistema de Simulação de Zoológico em Java

[📝 Proposta Inicial do Projeto Final – Programação Orientada a Objetos.pdf](https://github.com/user-attachments/files/22803651/Proposta.Inicial.do.Projeto.Final.Programacao.Orientada.a.Objetos.pdf)


# 🦁 ZooJava

Sistema de simulação de zoológico em Java — Projeto de Programação Orientada a Objetos.

## 👥 Integrantes
- CAIO HENRIQUE ALMEIDA DE OLIVEIRA / 00000853054
- LUIZ HENRIQUE DE MOURA MENEZES MIRANDA CAMELLO / 00000852839  
- PEDRO HENRIQUE DE ARAÚJO MEDEIROS / 00000853094

Repositório: [https://github.com/Zipzoper/ZooJava](https://github.com/Zipzoper/ZooJava)

---

ZooJava é um sistema simples de simulação de zoológico em Java, baseado no padrão MVC, com menu interativo em modo texto.

## 🚀 Execução

1. Clone o repositório: git clone https://github.com/Zipzoper/ZooJava.git


2. Abra em uma IDE Java (Eclipse, IntelliJ ou VS Code).


3. Execute br/com/zoojava/view/Main.java e use o menu para interagir com o zoológico.

4. Utilize os números para navegar pelo menu

## 🧩 Estrutura de Pacotes

model → classes dos animais e suas ações.

controller → lógica do zoológico.

view → interface de texto (menu).

util → utilitários de entrada e apoio.


Protótipo inicial baseado no modelo UML.


## ✅ Funcionalidades Implementadas

### 🧬 **Pilares da POO**
- **Encapsulamento** (atributos privados + getters/setters)
- **Herança** (`Animal` → `Mamifero` → {`Macaco`, `Leao`, `Elefante`})
- **Polimorfismo** (métodos `emitirSom()` e `alimentar()` sobrescritos)

### 🧠 **Lógica e Estrutura**
- Estrutura de pacotes seguindo padrão MVC  
  `model`, `view`, `controller`, `service`, `util`
- Uso de **ArrayList** para gerenciar os animais
- Uso de **HashMap** para estatísticas
- Tratamento de exceções no input do usuário

### 💾 **Persistência de Dados (.txt – sem Gson)**
- Os dados são salvos em `data/zoo.txt`
- O arquivo é criado automaticamente caso não exista
- Formato simples e legível, ex:


# 🐾 **Funcionalidades**

### ✔ **Cadastro de Animais**
1. Usuário escolhe a **espécie**  
   - Mamíferos  
   - Aves  
   - Répteis  
   - Peixes  
   - Invertebrados  
2. Escolhe o **animal específico**  
3. Digita **nome** e **idade**

### ✔ **Listagem de animais**
Exibe todos os animais cadastrados com seus dados.

### ✔ **Emissão de som**
Cada espécie sobrescreve o método `emitirSom()` usando **polimorfismo**.

### ✔ **Alimentar todos**
Cada animal possui seu próprio comportamento no método `alimentar()`.

### ✔ **Remoção de animais**

### ✔ **Estatísticas**
Conta quantos animais existem por espécie usando `Map<String, Integer>`.

### ✔ **Persistência em arquivo**
Todos os animais são salvos em:
\data\zoo.txt

O arquivo é reconstruído automaticamente ao iniciar o sistema.

### ✔ **Thread de Auto-Salvamento**
O sistema possui uma Thread que roda paralelamente, salvando automaticamente a lista de animais a cada 10 segundos.
