package com.mycompany.zoo;

public class Cão extends Animal implements Canis{
    
    public Cão(){
        super();
    }
    
    public Cão(int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
    
    public Cão(String nome, int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(nome, idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }

}