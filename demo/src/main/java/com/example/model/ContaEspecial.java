package com.example.model;

import com.example.enums.TipoConta;

public class ContaEspecial extends ContaInvestimento {
    // conta especial
    private double tarifaMensal;
    private double limiteChequeEspecial;

    
    public ContaEspecial(Titular titular, int agencia, int numero, double tarifaMensal) {
        super(titular, agencia, numero);
        this.tarifaMensal = tarifaMensal;
    }

    public double getTarifaMensal() {
        return tarifaMensal;
    }

    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = tarifaMensal;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        if (getTipo() != TipoConta.ESPECIAL) {
            throw new RuntimeException("Este tipo de conta não permite limite de cheque especial");
        }

        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    protected void validarSaldoParaSaque(double valor) {
        if (getSaldoDisponivel() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }


    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        if (getSaldoDisponivel() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }

        saldo -= valor;
    }

    @Override
    public void imprimirDemonstrativo(){
        System.out.println();
        System.out.printf("Agência: %d%n", getAgencia());
        System.out.printf("Conta: %d%n", getNumero());
        System.out.printf("Titular: %s%n", getTitular().getNome());
        System.out.printf("Saldo: %.2f%n", getSaldo());
        System.out.printf("Saldo disponível: %.2f%n", getSaldoDisponivel());
    }

    public double getSaldoDisponivel() {
        return getSaldo() + getLimiteChequeEspecial();
    }


    public void debitarTarifaMensal() {
        if (getTipo() ==  TipoConta.ESPECIAL) {
            sacar(getTarifaMensal());
        } else {
            throw new RuntimeException("Não pode debitar tarifa mensal neste tipo de conta");
        }
    }

    @Override
    public String toString() {
        return "ContaEspecial{" +
                "titular=" + getTitular() +
                ", agencia=" + getAgencia() +
                ", numero=" + getNumero() +
                "tarifaMensal=" + tarifaMensal +
                ", limiteChequeEspecial=" + limiteChequeEspecial +
                ", tarifaMensal=" + tarifaMensal +
                ", valorTotalRendimentos=" + getValorTotalRendimentos() +
                '}';
    }
}