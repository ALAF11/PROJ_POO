package com.mycompany.zoo;

import java.util.ArrayList;

public class Zoo{
    private String nome;
    private int ano;
    private float saldo;
    private ArrayList<Animal> animais;
    private ArrayList<Instalacao> instalacoes;
    
    public Zoo(){
        nome = "Blank Park"; //O zoo chama-se Blank Park
        ano = 2022;
        saldo = 5000000;
        animais = new ArrayList<Animal>();
        instalacoes = new ArrayList<Instalacao>();
    }
    
    public void addAnimal(Animal animal){ //Adiciona animal ao zoo
        animais.add(animal);
    }
    
    public ArrayList<Animal> getAnimais(){ //Obter animais do zoo
        return animais;
    }
    
    public void removeAnimal(Animal animal){ //Remover animal do zoo
        animais.remove(animal);
    }
    
    public void addInstalacao(Instalacao instalacao){ //Adiciona instalação ao zoo
        instalacoes.add(instalacao);
    }
    
    public ArrayList<Instalacao> getInstalacoes(){ //Obter instalações do zoo
        return instalacoes;
    }
    
    @Override
    public String toString(){ //Método toString() que imprime os dados do zoo
        String texto;
        texto = "\nO '" + nome + "'";
        texto += " foi inaugurado em " + ano +".\n";
        texto += "O saldo contabilístico do '" + nome + "' são " + saldo + " euros.\n";
        return texto;
    }
    
    //GETTERS
    public String getNome(){
        return nome;
    }
    
    public int getAno(){
        return ano;
    }
    
    public float getSaldo(){
        return saldo;
    }
    
    //SETTERS
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }
    
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
}