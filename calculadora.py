from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.route('/calcular', methods=['POST'])
def calcular():
    data = request.json

    try:
        num1 = float(data.get('numero1'))
        num2 = float(data.get('numero2'))
        operador = data.get('operador')
    except (ValueError, TypeError):
        return jsonify({'erro': 'Valores inválidos'}), 400

    if operador not in ['+', '-', '*', '/']:
        return jsonify({'erro': 'Operador inválido'}), 400

    if operador == '+':
        resultado = num1 + num2
    elif operador == '-':
        resultado = num1 - num2
    elif operador == '*':
        resultado = num1 * num2
    elif operador == '/':
        if num2 == 0:
            return jsonify({'erro': 'Divisão por zero'}), 400
        resultado = num1 / num2

    return jsonify({
        'resultado': f'{num1} {operador} {num2} = {resultado}'
    })

if __name__ == '__main__':
    app.run(debug=True)
