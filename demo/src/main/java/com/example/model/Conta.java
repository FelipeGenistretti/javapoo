package com.example.model;

import com.example.enums.TipoConta;

public class Conta {

    private Titular titular;
    private int agencia;
    private int numero;
    protected double saldo;
    private TipoConta tipo = TipoConta.NORMAL;

    // investimento
    private double valorTotalRendimentos;

    // especial
    private double tarifaMensal;
    private double limiteChequeEspecial;

   

    public Conta(Titular titular, int agencia, int numero) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }


    public Titular getTitular() {
        return titular;
    }


    public int getAgencia() {
        return agencia;
    }


    public int getNumero() {
        return numero;
    }


    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;

        if (tipo != TipoConta.ESPECIAL) {
            this.limiteChequeEspecial = 0;
            this.tarifaMensal = 0;
        }
    }

    protected void validarSaldoParaSaque(double valor) {
        if (getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public double getSaldoDisponivel() {
        if (tipo == TipoConta.ESPECIAL) {
            return saldo + limiteChequeEspecial;
        }
        return saldo;
    }

    public void setLimiteChequeEspecial(double limite) {
        if (tipo != TipoConta.ESPECIAL) {
            throw new RuntimeException("Só conta especial pode ter limite");
        }
        this.limiteChequeEspecial = limite;
    }

    public void setTarifaMensal(double tarifa) {
        if (tipo != TipoConta.ESPECIAL) {
            throw new RuntimeException("Só conta especial tem tarifa");
        }
        this.tarifaMensal = tarifa;
    }

    public void creditarRendimentos(double percentual) {
        if (tipo != TipoConta.INVESTIMENTO && tipo != TipoConta.ESPECIAL) {
            throw new RuntimeException("Conta não permite rendimento");
        }

        double rendimento = saldo * percentual / 100;
        valorTotalRendimentos += rendimento;
        depositar(rendimento);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        validarSaldoParaSaque(valor);

        saldo -= valor;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        saldo += valor;
    }

    public void debitarTarifaMensal() {
        if (tipo != TipoConta.ESPECIAL) {
            throw new RuntimeException("Só conta especial tem tarifa");
        }

        sacar(tarifaMensal);
    }

    public void imprimirDemonstrativo() {
        System.out.println();
        System.out.printf("Agência: %d%n", agencia);
        System.out.printf("Conta: %d%n", numero);
        System.out.printf("Titular: %s%n", titular.getNome());
        System.out.printf("Saldo: %.2f%n", saldo);
    }

    @Override
    public String toString() {
        return String.format("Conta(titular=%s, agencia=%d, numero=%d)", titular.getNome(), agencia, numero);
    }
}