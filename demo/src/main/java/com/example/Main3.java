package com.example;

import com.example.enums.TipoConta;
import com.example.model.Conta;
import com.example.model.ContaEspecial;
import com.example.model.ContaInvestimento;
import com.example.model.Titular;
import com.example.model.ValueObjects.Cpf;

public class Main3 {
    public static void main(String[] args) {
        ContaEspecial conta1 = new ContaEspecial();
        conta1.setTitular(new Titular("João da Silva", "12312312300"));
        conta1.setAgencia(1234);
        conta1.setTipo(TipoConta.ESPECIAL);
        conta1.setNumero(999999);
        conta1.setLimiteChequeEspecial(1000);
        conta1.setTarifaMensal(90);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100);
        conta1.imprimirDemonstrativo();

        conta1.sacar(200);
        conta1.imprimirDemonstrativo();

        conta1.debitarTarifaMensal();
        conta1.imprimirDemonstrativo();
    }
} 