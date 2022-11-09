package com.rpec.pucpr;

import java.util.ArrayList;

public class ArvoreAVL_Palavras {
    NoAVL_Palavras raiz;
    ArrayList<String> old_lista = new ArrayList<>();


    public void insere_elemento(String valor,String nome_arquivo) {
        //so ppode criar uma lista se o valor for diferente
        //ListaEncadeada_Palavras listaEncadeada = new ListaEncadeada_Palavras();
        String aux = null;
        aux = valor.replace("\r","");
        valor = aux;

        NoAVL_Palavras novo = new NoAVL_Palavras(valor);


        ArrayList<NoAVL_Palavras> lista = new ArrayList<>();
//        for (int i = old_lista.size() - 1; i >= 0; i--) {
//            aux = novo.info.replace("\r","");
//
//            if (old_lista.get(i).equals(aux)){
//                return;
//
//            }
//
//        }
        ListaEncadeada_Palavras listaEncadeada = new ListaEncadeada_Palavras();


        if (raiz == null) {
            raiz = novo;

            listaEncadeada.insere(nome_arquivo);
            raiz.lista_encadeada = listaEncadeada;

        }else if(raiz.info.equals(valor)){
            raiz.lista_encadeada.insere(nome_arquivo);

        } else {
            NoAVL_Palavras p = raiz;
            NoAVL_Palavras q = null;
            //verifica em qual posicao alocar
            while (p != null) {

                lista.add(p);
                q = p;

                if (p.info.equals(novo.info)){
                        raiz.lista_encadeada.insere(nome_arquivo);
                        return;
                    }

                if (valor.compareTo(p.info) < 0) {
                    p = p.esquerda;
                } else {
                    p = p.direita;
                }
            }
            //inserindo
            if (valor.compareTo(q.info) < 0) {
                q.esquerda = novo;
                q.esquerda.lista_encadeada = listaEncadeada;
                q.esquerda.lista_encadeada.insere(nome_arquivo);
            } else {
                q.direita = novo;
                q.direita.lista_encadeada = listaEncadeada;
                q.direita.lista_encadeada.insere(nome_arquivo);

            }

            for (int i = lista.size() - 1; i >= 0; i--) {
                rebalancear(lista.get(i));
            }

        }
    }



//    public NoAVL_Palavras remove_elemento(NoAVL_Palavras noAVL, int elemento){
//        if(noAVL == null){
//            return noAVL;
//        }
//        //vai pelo lado esquerdo da árvore até o elemento digitado ser menor que o valor do nó
//        else if(elemento< noAVL.dado){
//            noAVL.esquerda = remove_elemento(noAVL.esquerda, elemento);
//        }
//        //vai pelo lado direito da árvore até o elemento digitado ser menor que o valor do nó
//        else if(elemento > noAVL.dado){
//            noAVL.direita = remove_elemento(noAVL.direita, elemento);
//        }
//        else{
//            //caso o elemento tiver uma ou nenhuma subarvore e encontra o menor elemento da sub arvore direita
//            if(noAVL.esquerda == null){
//                return noAVL.direita;
//            }
//            else if(noAVL.direita == null) {
//                return noAVL.esquerda;
//            }
//            noAVL.dado = menor_elemento(noAVL.direita);
//            noAVL.direita = remove_elemento(noAVL.direita, noAVL.dado);
//        }
//        return noAVL;
//    }
//
//    public NoAVL_Palavras existe_elemento(int valor){
//        NoAVL_Palavras p = this.raiz;
//        while(p != null){
//            if(valor < p.dado){
//                p = p.esquerda;
//            }else if (p.dado == valor){
//                break;
//            }
//            else{
//                p = p.direita;
//            }
//        }
//        return p;
//    }
//
    public void imprime_preordem(NoAVL_Palavras raiz){
        if(raiz != null){
            System.out.println(raiz.info);
            imprime_preordem(raiz.esquerda);
            imprime_preordem(raiz.direita);
        }
    }

    public void imprime_inordem(NoAVL_Palavras raiz){
        if(raiz != null){
            imprime_inordem(raiz.esquerda);
            System.out.println(raiz.info);
            imprime_inordem(raiz.direita);
        }
    }

    public void imprime_posordem(NoAVL_Palavras raiz){
        if(raiz != null){
            imprime_posordem(raiz.esquerda);
            imprime_posordem(raiz.direita);
            System.out.println(raiz.info);

        }
    }

//   public int altura(NoAVL_Palavras noAVL){
//        if (noAVL != null) {
//            return 1 + Math.max(altura(noAVL.esquerda), altura(noAVL.direita));
//        }
//       return 0;
//   }
    public int altura(NoAVL_Palavras atual) {
        if(atual == null || (atual.esquerda == null && atual.direita == null))
            return 0;
        else {
            if (altura(atual.esquerda) > altura(atual.direita))
                return ( 1 + altura(atual.esquerda) );
            else
                return ( 1 + altura(atual.direita) );
        }
    }
//
//    public int menor_elemento(NoAVL_Palavras noAVL) {
//        NoAVL_Palavras raizAtual = noAVL;
//        while (raizAtual.esquerda != null) {
//            raizAtual = raizAtual.esquerda;
//        }
//
//        return raizAtual.dado;
//    }
//
    private void rotacaoEsquerda(NoAVL_Palavras e) {

        NoAVL_Palavras pai = getPai(e);
        NoAVL_Palavras b = e.direita;

        if (e == raiz) {
            raiz = b;
        } else if (pai.getInfo().compareTo(b.getInfo()) < 0) {
            pai.direita = b;
        } else {
            pai.esquerda = b;
        }

        e.direita = b.esquerda;


        b.esquerda = e;


    }

    private void rotacaoDireita(NoAVL_Palavras d) {

       NoAVL_Palavras pai = getPai(d);
       NoAVL_Palavras b = d.esquerda;

        if (d == raiz) {
           raiz = b;
        } else if (pai.getInfo().compareTo(b.getInfo()) < 0) {
            pai.direita = b;
        } else {
           pai.esquerda = b;
       }

        d.esquerda = b.direita;

        b.direita = d;

   }

    public int fator_balanceamento(NoAVL_Palavras noAVL) {
       if (noAVL == null)
            return 0;
        //System.out.println(altura(noAVL.direita) - altura(noAVL.esquerda));
       return altura(noAVL.direita) - altura(noAVL.esquerda);
   }

   public void rebalancear(NoAVL_Palavras noAVL) {
      if (fator_balanceamento(noAVL) < -1) {
            if (fator_balanceamento(noAVL.esquerda) > 0) {
                rotacaoEsquerda(noAVL.esquerda);
            }
           rotacaoDireita(noAVL);
        } else if (fator_balanceamento(noAVL) > 1) {
            if (fator_balanceamento(noAVL.direita) < 0) {
               rotacaoDireita(noAVL.direita);
            }
          rotacaoEsquerda(noAVL);
        }
//      else {
//          System.out.println("erro rebalancear");
//      }
   }

    public NoAVL_Palavras getPai(NoAVL_Palavras noAVL) {
        if (noAVL == raiz)
            return null;

        NoAVL_Palavras raiz_atual = raiz;

        while (raiz_atual != null) {
            if (noAVL == raiz_atual.esquerda || noAVL == raiz_atual.direita)
                break;
            if (noAVL.getInfo().compareTo(raiz_atual.getInfo()) < 0)
                raiz_atual = raiz_atual.esquerda;
            else
                raiz_atual = raiz_atual.direita;
        }

        return raiz_atual;

    }
}
