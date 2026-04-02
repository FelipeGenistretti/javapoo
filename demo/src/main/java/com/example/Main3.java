package com.example;

import com.example.enums.TipoConta;
import com.example.model.Conta;
import com.example.model.ContaEspecial;
import com.example.model.ContaInvestimento;
import com.example.model.Titular;
import com.example.model.ValueObjects.Cpf;

public class Main3 {
    public static void main(String[] args) {
        Titular titular = new Titular("João da Silva", "12312312300");
        ContaEspecial conta1 = new ContaEspecial(titular, 1234, 999999, 90);
        conta1.setTipo(TipoConta.ESPECIAL);
        conta1.setLimiteChequeEspecial(1000);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100);
        conta1.imprimirDemonstrativo();

        conta1.sacar(200);
        conta1.imprimirDemonstrativo();

        conta1.debitarTarifaMensal();
        conta1.imprimirDemonstrativo();
    }
} 