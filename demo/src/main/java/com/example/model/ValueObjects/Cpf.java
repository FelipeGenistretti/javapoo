package com.example.model.ValueObjects;

public class Cpf {

    private String valor;

    public Cpf(String valor){
        if (!validate(valor)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.valor = valor;
    }

    protected boolean validate(String valor){
        valor = valor.replaceAll("[^\\d]", "");

        if(valor.length() != 11) return false;

        if(valor.matches("(\\d)\\1{10}")) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Cpf [valor=" + valor + "]";
    }

    
}