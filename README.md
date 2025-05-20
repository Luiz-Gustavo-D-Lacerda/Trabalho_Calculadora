# Calculadora Simples com Frontend e Backend

Este projeto implementa uma calculadora simples com interface web (frontend) e backend em Python usando Flask.  
O frontend faz requisições para o backend para realizar as operações matemáticas.

---

## 1. Funcionalidades

- Soma, subtração, multiplicação e divisão de dois números.
- Validação dos números e operador.
- Interface web responsiva e simples.
- Backend separado que processa as operações.

---

## 2. Tecnologias utilizadas

- Python 3.x  
- Flask (backend)  
- HTML, CSS, JavaScript (frontend)

---

## 3. Como usar

### 3.1 Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```
### 3.2 Instale as dependências
```
pip install flask
```
### 3.3 Rode o servidor Flask
```
python app.py
```
O backend estará disponível em: http://localhost:5000

### 3.4 Acesse a calculadora no navegador
Abra o arquivo index.html na pasta frontend diretamente ou configure um servidor para servir os arquivos estáticos.
## 4. Estrutura do projeto
```
/backend
  app.py          # Código Python do backend Flask
/frontend
  index.html      # Interface da calculadora
  style.css       # Estilos CSS (se existir)
  script.js       # Script JavaScript para chamadas ao backend

```
## 5. Como funciona
O usuário insere dois números e escolhe a operação no frontend.

O frontend envia uma requisição para o backend via API REST.

O backend realiza a operação e retorna o resultado.

O frontend exibe o resultado para o usuário.