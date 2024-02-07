package com.mycompany.zoo;

public class Hipopótamo extends Animal implements Hippopotamus{
    
    public Hipopótamo(){
        super();
    }
    
    public Hipopótamo(int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
    
    public Hipopótamo(String nome, int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(nome, idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
}
