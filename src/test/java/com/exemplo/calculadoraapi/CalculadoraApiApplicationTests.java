package com.exemplo.calculadoraapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // sobe o app na porta random para teste
public class CalculadoraApiApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate; // cliente para chamar o endpoint

    @Test
    public void testarSoma() {
        String json = "{\"numero1\":\"10\", \"numero2\":\"5\", \"operador\":\"+\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        ResponseEntity<CalculadoraApiApplication.CalcResponse> response =
            restTemplate.postForEntity("/calcular", entity, CalculadoraApiApplication.CalcResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().resultado).contains("15.0");
        assertThat(response.getBody().erro).isNull();
    }

    @Test
    public void testarSubtracao() {
        String json = "{\"numero1\":\"10\", \"numero2\":\"5\", \"operador\":\"-\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        ResponseEntity<CalculadoraApiApplication.CalcResponse> response =
            restTemplate.postForEntity("/calcular", entity, CalculadoraApiApplication.CalcResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().resultado).contains("5.0");
        assertThat(response.getBody().erro).isNull();
    }

    @Test
    public void testarMultiplicacao() {
        String json = "{\"numero1\":\"10\", \"numero2\":\"5\", \"operador\":\"*\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        ResponseEntity<CalculadoraApiApplication.CalcResponse> response =
            restTemplate.postForEntity("/calcular", entity, CalculadoraApiApplication.CalcResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().resultado).contains("50.0");
        assertThat(response.getBody().erro).isNull();
    }

    @Test
    public void testarDivisao() {
        String json = "{\"numero1\":\"10\", \"numero2\":\"5\", \"operador\":\"/\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        ResponseEntity<CalculadoraApiApplication.CalcResponse> response =
            restTemplate.postForEntity("/calcular", entity, CalculadoraApiApplication.CalcResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().resultado).contains("2.0");
        assertThat(response.getBody().erro).isNull();
    }

    @Test
    public void testarOperadorInvalido() {
        String json = "{\"numero1\":\"10\", \"numero2\":\"5\", \"operador\":\"%\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        ResponseEntity<CalculadoraApiApplication.CalcResponse> response =
            restTemplate.postForEntity("/calcular", entity, CalculadoraApiApplication.CalcResponse.class);

        // Status deve ser 200 porque a API responde com sucesso mesmo para operador inválido
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        // Aqui esperamos que o campo erro esteja preenchido
        assertThat(response.getBody().erro).isNotNull();
        assertThat(response.getBody().erro).isNotEmpty();
    }
}
