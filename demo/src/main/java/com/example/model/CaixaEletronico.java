package com.example.model;

public class CaixaEletronico {

    public static final double TARIFA_TRASNFERENCIA = 10;

    public void transferir(Conta contaOrigem, Conta contaDestino, double valorTransferencia){
        contaOrigem.sacar(valorTransferencia + TARIFA_TRASNFERENCIA);
        contaDestino.depositar(valorTransferencia);

    }
}
