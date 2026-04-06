package com.example;

import com.example.enums.TipoConta;
import com.example.model.CaixaEletronico;
import com.example.model.Conta;
import com.example.model.ContaEspecial;
import com.example.model.Titular;
import com.example.model.ValueObjects.Cpf;

import javax.accessibility.AccessibleAction;

public class Main {
    public static void main(String[] args) {
        CaixaEletronico caixaEletronico = new CaixaEletronico();

        Titular titularJoao = new Titular("João da Silva", "12312312300");
        Titular titularAna = new Titular("Ana da Silva", "12312312377");

        ContaEspecial conta1 = new ContaEspecial(titularJoao, 1234, 999999, 90);
        conta1.setLimiteChequeEspecial(1000);

        ContaEspecial conta2 = new ContaEspecial(titularAna, 2222, 888888, 90);
        conta2.setLimiteChequeEspecial(1000);

        conta1.depositar(300);

        caixaEletronico.transferir(conta1, conta2, 400);



    }
} 