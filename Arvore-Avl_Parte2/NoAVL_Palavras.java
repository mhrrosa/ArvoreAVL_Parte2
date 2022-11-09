package com.rpec.pucpr;

public class NoAVL_Palavras{
    String info;
    NoAVL_Palavras direita;
    NoAVL_Palavras esquerda;
    ListaEncadeada_Palavras lista_encadeada;

    public NoAVL_Palavras(String info) {
        this.info = info;
        this.direita = null;
        this.esquerda = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
