package com.mycompany.zoo;

public class Rinoceronte extends Animal implements Ceratotherium{
    
    public Rinoceronte(){
        super();
    }
    
    public Rinoceronte(int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
    
    public Rinoceronte(String nome, int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){
        super(nome, idade, atratividade, preco, albinismo, heterocromia, melanismo);
    }
}
