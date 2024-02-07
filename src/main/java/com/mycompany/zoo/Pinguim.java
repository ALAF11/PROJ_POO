package com.mycompany.zoo;

public class Pinguim extends Animal implements Aptenodytes{
    
    public Pinguim(){
        super();
    }
    
    public Pinguim(int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
    
    public Pinguim(String nome, int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(nome, idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }

}