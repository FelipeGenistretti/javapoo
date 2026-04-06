package com.example.model;
import java.util.Objects;

import com.example.model.ValueObjects.Cpf;

public class Titular {

    private String nome;
    private String cpf;

    public Titular(String nome, String cpf) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(cpf);

        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Titular{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}