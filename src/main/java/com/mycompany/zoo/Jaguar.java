package com.mycompany.zoo;

public class Jaguar extends Animal implements Panthera{
    
    public Jaguar(){
        super();
    }
    
    public Jaguar(int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
    
    public Jaguar(String nome, int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(nome, idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
}
