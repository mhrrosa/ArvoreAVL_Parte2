package com.rpec.pucpr;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class TestaArvoreAVL_Palavras {

    public static void main(String[] args){
        ArvoreAVL_Palavras arvore = new ArvoreAVL_Palavras();
        try (DirectoryStream<Path> pasta = Files.newDirectoryStream(Paths.get("C:/Users/Mathe/Desktop/Faculdade/Problemas Estruturados/teste"))) {

            for (Path file : pasta) {
                Scanner arquivo = new Scanner(new FileReader("C:/Users/Mathe/Desktop/Faculdade/Problemas Estruturados/teste/" + file.getFileName())).useDelimiter("\n");

                while (arquivo.hasNext()) {

                    String nome_arquivo = file.getFileName().toString();
                    nome_arquivo = nome_arquivo.replace("\r","");
                    String info = arquivo.next();

                    arvore.insere_elemento(info,nome_arquivo);

                }
            }

        } catch (IOException | DirectoryIteratorException ex) {
            System.err.println(ex);
        }

        arvore.imprime_preordem(arvore.raiz);
        //arvore.imprime_posordem(arvore.raiz);
        //System.out.println(arvore.raiz.direita.lista_encadeada.primeiro.frequencia);
        System.out.println("--teste--");
        System.out.println(arvore.raiz.esquerda.esquerda.info);
        arvore.raiz.esquerda.esquerda.lista_encadeada.imprime();
        //System.out.println(arvore.raiz.direita.esquerda.direita.info);
        //arvore.imprime_inordem(arvore.raiz);


        //System.out.println(arvore.raiz.direita.info);
        //System.out.println(arvore.altura(arvore.raiz));




    }
}
