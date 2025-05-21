package com.exemplo.calculadoraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*") // <-- Isso permite requisições de qualquer origem
public class CalculadoraApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraApiApplication.class, args);
    }

    static class CalcRequest {
        public String numero1;
        public String numero2;
        public String operador;
    }

    static class CalcResponse {
        public String resultado;
        public String erro;
    }

    @PostMapping("/calcular")
    public CalcResponse calcular(@RequestBody CalcRequest req) {
        CalcResponse resp = new CalcResponse();

        double num1, num2;
        try {
            num1 = Double.parseDouble(req.numero1);
            num2 = Double.parseDouble(req.numero2);
        } catch (NumberFormatException e) {
            resp.erro = "Um ou ambos os números não são válidos.";
            return resp;
        }

        if (req.operador == null || req.operador.length() != 1 || "+-/*".indexOf(req.operador) == -1) {
            resp.erro = "Operador inválido.";
            return resp;
        }

        switch (req.operador) {
            case "+":
                resp.resultado = num1 + " + " + num2 + " = " + (num1 + num2);
                break;
            case "-":
                resp.resultado = num1 + " - " + num2 + " = " + (num1 - num2);
                break;
            case "*":
                resp.resultado = num1 + " * " + num2 + " = " + (num1 * num2);
                break;
            case "/":
                if (num2 == 0) {
                    resp.erro = "Erro: Divisão por zero não é permitida.";
                } else {
                    resp.resultado = num1 + " / " + num2 + " = " + (num1 / num2);
                }
                break;
            default:
                resp.erro = "Operador inválido.";
        }

        return resp;
    }
}
