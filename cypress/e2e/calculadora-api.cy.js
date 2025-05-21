// cypress/e2e/calculadora-api.cy.js

describe('API Calculadora', () => {
  const url = 'http://localhost:8080/calcular'; // ajuste a porta se for diferente

  it('deve somar dois números corretamente', () => {
    cy.request({
      method: 'POST',
      url,
      body: { numero1: "10", numero2: "5", operador: "+" },
      headers: { 'Content-Type': 'application/json' }
    }).then(response => {
      expect(response.status).to.eq(200);
      expect(response.body.resultado).to.contain('15.0');
      expect(response.body.erro).to.be.null;
    });
  });

  it('deve subtrair dois números corretamente', () => {
    cy.request({
      method: 'POST',
      url,
      body: { numero1: "10", numero2: "5", operador: "-" },
      headers: { 'Content-Type': 'application/json' }
    }).then(response => {
      expect(response.status).to.eq(200);
      expect(response.body.resultado).to.contain('5.0');
      expect(response.body.erro).to.be.null;
    });
  });

  it('deve multiplicar dois números corretamente', () => {
    cy.request({
      method: 'POST',
      url,
      body: { numero1: "10", numero2: "5", operador: "*" },
      headers: { 'Content-Type': 'application/json' }
    }).then(response => {
      expect(response.status).to.eq(200);
      expect(response.body.resultado).to.contain('50.0');
      expect(response.body.erro).to.be.null;
    });
  });

  it('deve dividir dois números corretamente', () => {
    cy.request({
      method: 'POST',
      url,
      body: { numero1: "10", numero2: "5", operador: "/" },
      headers: { 'Content-Type': 'application/json' }
    }).then(response => {
      expect(response.status).to.eq(200);
      expect(response.body.resultado).to.contain('2.0');
      expect(response.body.erro).to.be.null;
    });
  });

  it('deve retornar erro para operador inválido', () => {
    cy.request({
      method: 'POST',
      url,
      body: { numero1: "10", numero2: "5", operador: "%" },
      headers: { 'Content-Type': 'application/json' },
      failOnStatusCode: false // permite checar respostas de erro sem falhar o teste automaticamente
    }).then(response => {
      expect(response.status).to.eq(200);  // conforme sua API, está retornando 200 mesmo para erro
      expect(response.body.erro).to.exist;
      expect(response.body.erro).to.not.be.empty;
    });
  });
});
