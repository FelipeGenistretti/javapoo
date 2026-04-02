package com.example.model;

import com.example.enums.TipoConta;

public class ContaInvestimento extends Conta{

    private double valorTotalRendimentos;


    public double getValorTotalRendimentos() {
        return valorTotalRendimentos;
    }
    

    public void creditarRendimentos(double percentualJuros) {
        if (getTipo() ==  TipoConta.INVESTIMENTO || getTipo() ==  TipoConta.ESPECIAL) {
            double valorRendimentos = getSaldo() * percentualJuros / 100;
            this.valorTotalRendimentos += valorRendimentos;
            depositar(valorRendimentos);
        } else {
            throw new RuntimeException("Não pode creditar rendimentos neste tipo de conta");
        }
    }

    

}