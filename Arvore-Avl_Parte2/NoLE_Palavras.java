package com.rpec.pucpr;

public class NoLE_Palavras {
    String nome_arquivo;
    int frequencia;
    NoLE_Palavras proximo;

    public NoLE_Palavras(String nome_arquivo) {
        this.nome_arquivo = nome_arquivo;
        this.proximo = null;
        this.frequencia = 1;
    }


}
