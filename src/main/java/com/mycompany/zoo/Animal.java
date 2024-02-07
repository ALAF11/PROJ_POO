package com.mycompany.zoo;

public abstract class Animal{ //Classe abstrata -> Animal não é possível instanciar da seguinte maneira: Animal a = new Animal();
    
    private static int count = 0; //Contador para o id
    private int id;
    private String nome;
    private int idade;
    private float atratividade;
    private float preco;
    private boolean albinismo, heterocromia, melanismo;
    
    public Animal(){ //Construtor
        nome = "";
        idade = 0;
        atratividade = 0;
        preco = 0;
    }
    
    public Animal(int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){ //Overloading sem String nome
        nome = "";
        this.idade = idade;
        this.atratividade = atratividade;
        this.preco = preco;
        this.albinismo = albinismo;
        this.heterocromia = heterocromia;
        this.melanismo = melanismo;
    }
    
    public Animal(String nome, int idade, float atratividade, float preco, boolean albinismo, boolean heterocromia, boolean melanismo){ //Overloading com String nome
        id = ++count;
        this.nome = nome;
        this.idade = idade;
        this.atratividade = atratividade;
        this.preco = preco;
        this.albinismo = albinismo;
        this.heterocromia = heterocromia;
        this.melanismo = melanismo;
    }
    
    @Override
    public String toString(){ //Método toString() que imprime os dados do animal
        String texto;
        texto = "------------ Animal nº: " + id + " ------------\n";
        texto += "Nome: " + nome + "\n";
        texto += "Idade: " + idade + " anos\n";
        texto += "Atratividade: " + atratividade + "\n";
        texto += "Preço: " + preco + " euros\n";
        if(albinismo == true){
            texto += "Albinismo: Sim\n";
        }
        else{
            texto += "Albinismo: Não\n";
        }
        if(heterocromia == true){
            texto += "Heterocromia: Sim\n";
        }
        else{
            texto += "Heterocromia: Não\n";
        }
        if(melanismo == true){
            texto += "Melanismo: Sim\n";
        }
        else{
            texto += "Melanismo: Não\n";
        }
        texto += "--------------------------------------\n";
        return texto;
    }
    
    //GETTERS
    
    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public float getAtratividade(){
        return atratividade;
    }
    
    public float getPreco(){
        return preco;
    }
    
    public boolean temAlbinismo(){
        return albinismo;
    }
    
    public boolean temHeterocromia(){
        return heterocromia;
    }
    
    public boolean temMelanismo(){
        return melanismo;
    }
    
    //SETTERS
    
    public void setNome(String nome){
        id = ++count;
        this.nome = nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public void setAtratividade(float atratividade){
        this.atratividade = atratividade;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }
    
    public void setAlbinismo(boolean albinismo){
        this.albinismo = albinismo;
    }
    
    public void setHeterocromia(boolean heterocromia){
        this.heterocromia = heterocromia;
    }
    
    public void setMelanismo(boolean melanismo){
        this.melanismo = melanismo;
    }
}
