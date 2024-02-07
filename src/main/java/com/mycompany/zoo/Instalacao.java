package com.mycompany.zoo;

import java.util.ArrayList;
import java.util.Random;

public class Instalacao {
    
    private static int count = 0; //Contador para o id
    private int id;
    private int capacidade;
    private float preco;
    private ArrayList<Animal> animais;

    public Instalacao(){ //Construtor
        count ++;
        id = count;
        capacidade = 0;
        preco = 0;
        animais = new ArrayList<Animal>();
    }
    
    public Instalacao(int capacidade, float preco){ //Overloading sem animais
        count ++;
        id = count;
        this.capacidade = capacidade;
        this.preco = preco;
        animais = new ArrayList<Animal>();
    }
    
    public Instalacao(int capacidade, float preco, ArrayList<Animal> animais){ //Overloading com animais
        count ++;
        id = count;
        this.capacidade = capacidade;
        this.preco = preco;
        this.animais = animais;
    }

    public void addAnimal(Animal animal){ //Adiciona animal à instalação
        animais.add(animal);
    }
    
    public void removeAnimal(Animal animal){ //Remove animal da instalação
        animais.remove(animal);
    }
    
    public ArrayList<Animal> getAnimais(){ //Obter animais da instalação
        return animais;
    }
    
    @Override
    public String toString(){ //Método toString() que imprime os dados da instalação
        String texto;
        texto = "------------ Instalação nº: " + id + " ------------\n";
        texto += "Capacidade: " + capacidade + " animais\n";
        texto += "Preço: " + preco + " euros\n";
        if (animais.size() == 0){
            texto += "A instalação não tem animais\n";
            texto += "------------------------------------------";
        }
        else{
            texto += "A instalação tem os seguintes animais:\n";
            for (int i = 0; i < getAnimais().size(); i++){
                texto += "Espécie: " + getAnimais().get(i).getClass().getSimpleName() + "\n";
                texto += getAnimais().get(i);
            }
        }
        return texto;
    }
    
    //GETTERS
    public int getCapacidade(){
        return capacidade;
    }
    
    public float getPreco(){
        return preco;
    }
    
    //SETTERS
    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }
}