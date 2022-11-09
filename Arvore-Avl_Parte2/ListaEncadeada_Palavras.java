package com.rpec.pucpr;

public class ListaEncadeada_Palavras {
    public NoLE_Palavras primeiro;
    public NoLE_Palavras ultimo;

    public ListaEncadeada_Palavras(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean vazia(){
        return this.primeiro == null;
    }

    public void imprime(){
        NoLE_Palavras p = this.primeiro;
        while(p != null){
            System.out.println(p.nome_arquivo);
            System.out.println(p.frequencia);
            p = p.proximo;
        }
    }

    public void inserePrimeiro(String nome_arquivo){
        NoLE_Palavras p = new NoLE_Palavras(nome_arquivo);
        p.proximo = this.primeiro;
        this.primeiro = p; //aponta para p
        if(this.ultimo == null){
            this.ultimo = p;
        }
    }


    public void insereUltimo(String nome_arquivo){
        NoLE_Palavras p = new NoLE_Palavras(nome_arquivo);



        if(this.ultimo != null) {
            this.ultimo.proximo = p;
        }

        else {
            this.primeiro = p; //aponta para p
        }
        this.ultimo = p;
    }

    public void insereDepois(NoLE_Palavras no, String nome_arquivo){;
        NoLE_Palavras novoNo = new NoLE_Palavras(nome_arquivo);
        novoNo.proximo = no.proximo;
        no.proximo = novoNo;
    }

    public void insere(String nome_arquivo){
        if(this.vazia()){
            this.inserePrimeiro(nome_arquivo);
        }
        else{

            NoLE_Palavras novo = new NoLE_Palavras(nome_arquivo);
            NoLE_Palavras p = this.primeiro;
            NoLE_Palavras q = null;

            while(p !=null){
                q = p;
                p = p.proximo;

                if (q.nome_arquivo.equals(novo.nome_arquivo)){
                    this.primeiro.frequencia +=1;
//                    System.out.println(p.nome_arquivo);
//                    System.out.println(p.frequencia);
                    return;

                }




            }

            q.proximo = novo;
            novo.proximo = p;
        }
    }

}
