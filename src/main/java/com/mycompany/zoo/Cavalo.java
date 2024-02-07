package com.mycompany.zoo;

public class Cavalo extends Animal implements Equus{
    
    public Cavalo(){
        super();
    }
    
    public Cavalo(int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
    
    public Cavalo(String nome, int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(nome, idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
}