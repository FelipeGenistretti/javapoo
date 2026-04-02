package com.example;

import com.example.enums.TipoConta;
import com.example.model.Conta;
import com.example.model.ContaInvestimento;
import com.example.model.Titular;
import com.example.model.ValueObjects.Cpf;

public class Main2 {
    public static void main(String[] args) {
        ContaInvestimento conta1 = new ContaInvestimento();
        conta1.setTitular(new Titular("João da Silva", "12312312300"));
        conta1.setAgencia(1234);
        conta1.setNumero(999999);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100);
        conta1.imprimirDemonstrativo();

        conta1.creditarRendimentos(6);
        conta1.imprimirDemonstrativo();
    }
} 