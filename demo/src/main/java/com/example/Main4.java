package com.example;

import com.example.enums.TipoConta;
import com.example.model.Conta;
import com.example.model.ContaEspecial;
import com.example.model.Titular;

public class Main4 {
    public static void main(String[] args) {
        Titular titular = new Titular("João da Silva", "12312312300");
        Conta conta1 = new Conta(titular, 1234, 999999);
        ContaEspecial contaEspecial = new ContaEspecial(titular, 1234, 999999, 90);
        System.out.println(contaEspecial);

    }
} 