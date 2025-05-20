# fazendo uma calculadora com while
# calculadora com entrada apenas para dois numeros

while True:
    numero_1 = input('digite um numero: ')
    numero_2 = input('digite outro numero: ')
    operador = input('Digite o operador (+, -, /, *): ')

    numeros_validos = None
    num_1_float = 0
    num_2_float = 0

    try:
        num_1_float = float(numero_1)
        num_2_float = float(numero_2)
        numeros_validos = True
    except: 
        numeros_validos = None

    if numeros_validos is None:
        print('Um ou ambos os numeros digitados nao e validos.')
        continue

    operadores_permitidos = '+-/*'
    if operador not in operadores_permitidos:
        print('Operador invalido')
        continue
    
    if len(operador) > 1:
        print('Digite apenas um operador.')
        continue

    print('Realizando sua conta. Confira o Resultado abaixo:')
    
    if operador == '+':
        print(f'{num_1_float}" + "{num_2_float}=', num_1_float + num_2_float)
    elif operador == '-':
        print(f'{num_1_float}" - "{num_2_float}=', num_1_float - num_2_float)
    elif operador == '/':
        print(f'{num_1_float}" / "{num_2_float}=', num_1_float / num_2_float)
    elif operador == '*':
        print(f'{num_1_float}" * "{num_2_float}=', num_1_float * num_2_float)
        
    else:
        print('nunca deveria ter chegado a esse ponto.')

    sair = input('Quer Sair? [S]im: ').lower().startswith('s')
    print (sair)
    if sair is True: 
        break