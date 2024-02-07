package com.mycompany.zoo;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class MainZoo{
    
    public static int option;
    public static String nome;
    
    //Preço e atratividade máximos e mínimos
    public static final int MAX = 5000;
    public static final int MIN = 500;
    
    //Esperanças de vida de cada animal
    public static final int ESPERANCAVIDABOI = 22;
    public static final int ESPERANCAVIDACABRA = 18;
    public static final int ESPERANCAVIDACANGURU = 22;
    public static final int ESPERANCAVIDACAVALO = 30;
    public static final int ESPERANCAVIDACHITA = 12;
    public static final int ESPERANCAVIDACOBRA = 30;
    public static final int ESPERANCAVIDACOELHO = 9;
    public static final int ESPERANCAVIDACÃO = 13;
    public static final int ESPERANCAVIDADRAGÃO = 500;
    public static final int ESPERANCAVIDAELEFANTE = 48;
    public static final int ESPERANCAVIDAGALO = 10;
    public static final int ESPERANCAVIDAGIRAFA = 33;
    public static final int ESPERANCAVIDAGORILA = 40;
    public static final int ESPERANCAVIDAHIPOPÓTAMO = 50;
    public static final int ESPERANCAVIDAJAGUAR = 15;
    public static final int ESPERANCAVIDAKOALA = 18;
    public static final int ESPERANCAVIDALEOPARDO = 17;
    public static final int ESPERANCAVIDALEÃO = 10;
    public static final int ESPERANCAVIDALINCE = 16;
    public static final int ESPERANCAVIDALOBO = 16;
    public static final int ESPERANCAVIDAMACACO = 27;
    public static final int ESPERANCAVIDAPANDA = 20;
    public static final int ESPERANCAVIDAPINGUIM = 20;
    public static final int ESPERANCAVIDAPORCO = 20;
    public static final int ESPERANCAVIDARATO = 20;
    public static final int ESPERANCAVIDARINOCERONTE = 50;
    public static final int ESPERANCAVIDASURICATA = 14;
    public static final int ESPERANCAVIDATIGRE = 10;
    public static final int ESPERANCAVIDAURSO = 30;
    public static final int ESPERANCAVIDAZEBRA = 30;
    
    public static ArrayList<Animal> Obituario = new ArrayList<Animal>(); //ArrayList para animais mortos
    public static ArrayList<Animal> Nascimentos = new ArrayList<Animal>(); //ArrayList para animais recém-nascidos
    public static ArrayList<Animal> Aquisicoes = new ArrayList<Animal>(); //ArrayList para animais adquiridos
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in, "cp1252");
        
        Zoo zoo;
        zoo = new Zoo();
        
        System.out.println(zoo);
        
        System.out.println("O saldo contabilístico está correto?"); 
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("0 - Sair da aplicação");
        option = scan.nextInt();
        switch(option){ //Escolher se o utilizador pretende alterar o saldo pré-definido
            case 1:
                menuPrincipal(zoo);
                break;
            case 2:
                System.out.print("\nIntroduza o saldo contabilístico disponível: ");
                zoo.setSaldo(scan.nextFloat());
                System.out.println("\nO saldo contabilístico do zoo passou para: " + zoo.getSaldo() + " euros.");
                menuPrincipal(zoo);
                break;
            case 0:
                System.exit(0);
                break;          
        }
    }
    
    public static void menuPrincipal(Zoo zoo){
        Scanner scan = new Scanner(System.in, "cp1252");
        
        System.out.println("\nEscolha o que deseja fazer:");
        System.out.println("1 - Adquirir animal");
        System.out.println("2 - Retrato de família animal");
        System.out.println("3 - Calendário chinês");
        System.out.println("4 - Construir instalação");
        System.out.println("5 - Listar instalações");
        System.out.println("6 - Adicionar animal a instalação");
        System.out.println("7 - Consultar obituário");
        System.out.println("8 - Adicionar recém-nascidos ao zoo");
        System.out.println("9 - Próxima página");
        System.out.println("0 - Sair da aplicação");
        option = scan.nextInt();
        switch(option){
            case 1:
                adquirirAnimal(zoo);
                break;
            case 2:
                retratoDeFamiliaAnimal(zoo);
                break;
            case 3:
                calendarioChines(zoo);
                break;
            case 4:
                construirInstalacao(zoo);
                break;
            case 5:
                retratoDeInstalacoes(zoo);
                break;
            case 6:
                introduzirAnimais(zoo);
                break;
            case 7: 
                obituario(zoo);
                break;
            case 8:
                nascimentos(zoo);
                break;
            case 9:
                System.out.println("\nEscolha o que deseja fazer:");
                System.out.println("1 - Período contabilístico");
                System.out.println("2 - Histórico");
                System.out.println("3 - Consultar saldo");
                System.out.println("4 - Jumanji");
                System.out.println("5 - Lista de animais com características");
                System.out.println("6 - Lista de possíveis mutações");
                System.out.println("0 - Sair da aplicação");
                option = scan.nextInt();
                switch(option){
                    case 1:
                        periodoContabilistico(zoo);
                        break;
                    case 2:
                        historico(zoo);
                        break;
                    case 3:
                        consultarSaldo(zoo);
                        break;
                    case 4:
                        jumanji(zoo);
                        break;
                    case 5:
                        menuCaracteristicas(zoo);
                        break;
                    case 6: //Possíveis combinações de mutação
                        System.out.println("\nGenoma - Equus" +
                        "Cavalo + Zebra\n" +
                        "\n" +
                        "Genoma - Canis" +
                        "Cão + Lobo\n" +
                        "\n" +
                        "Genoma - Panthera" +
                        "Jaguar + Leopardo\n" +
                        "Jaguar + Leão\n" +
                        "Jaguar + Tigre\n" +
                        "Leopardo + Leão\n" +
                        "Leopardo + Tigre\n" +
                        "Leão + Tigre");
                        menuPrincipal(zoo);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            case 0:
                System.exit(0);
                break;
        }
    }
    
    public static void adquirirAnimal(Zoo zoo){
        Scanner scan = new Scanner(System.in, "cp1252");
       
        String nome;
        int idade;
        float preco, atratividade;
        Random rand = new Random();
        Animal animal;
        
        //Características aleatórias
        boolean temAlbinismo = rand.nextBoolean();
        boolean temHeterocromismo = rand.nextBoolean();
        boolean temMelanismo = rand.nextBoolean();

        System.out.println("\n1 - Adquirir animal aleatório");
        System.out.println("2 - Inserir animal");
        System.out.println("0 - Voltar ao menu principal");
        
        int random;
        
        option = scan.nextInt();
        switch (option){ 
            case 1: //Escolheu adquirir animal aleatório
                
                ArrayList<Animal> Opcoes = new ArrayList<Animal>(); //Array para adicionar as 3 opções de animais
                
                for(int i = 0; i < 3; i++){ //Ciclo para 3 vezes
                    random = rand.nextInt(30) + 1; //Random entre 1 e 30 para calhar um dos 30 animais
                    
                    if(random == 1){
                        idade = rand.nextInt(ESPERANCAVIDABOI) + 1; //Idade random
                        preco = rand.nextFloat(MAX- MIN) + MIN; //Preço random
                        atratividade = rand.nextFloat(MAX - MIN) + MIN; //Atratividade random
                        System.out.println("\nBoi:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Boi(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 2){
                        idade = rand.nextInt(ESPERANCAVIDACABRA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nCabra:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Cabra(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 3){
                        idade = rand.nextInt(ESPERANCAVIDACANGURU) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nCanguru:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Canguru(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 4){
                        idade = rand.nextInt(ESPERANCAVIDACAVALO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nCavalo:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Cavalo(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 5){
                        idade = rand.nextInt(ESPERANCAVIDACHITA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nChita:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Chita(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 6){
                        idade = rand.nextInt(ESPERANCAVIDACOBRA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nCobra:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Cobra(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 7){
                        idade = rand.nextInt(ESPERANCAVIDACOELHO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nCoelho:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Coelho(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));;
                    }
                    else if(random == 8){
                        idade = rand.nextInt(ESPERANCAVIDACÃO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nCão:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Cão(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 9){
                        idade = rand.nextInt(ESPERANCAVIDADRAGÃO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nDragão:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Dragão(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 10){
                        idade = rand.nextInt(ESPERANCAVIDAELEFANTE) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nElefante:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Elefante(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 11){
                        idade = rand.nextInt(ESPERANCAVIDAGALO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nGalo:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Galo(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 12){
                        idade = rand.nextInt(ESPERANCAVIDAGIRAFA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nGirafa:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Girafa(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 13){
                        idade = rand.nextInt(ESPERANCAVIDAGORILA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nGorila:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Gorila(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 14){
                        idade = rand.nextInt(ESPERANCAVIDAHIPOPÓTAMO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nHipopótamo:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Hipopótamo(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 15){
                        idade = rand.nextInt(ESPERANCAVIDAJAGUAR) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nJaguar:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Jaguar(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 16){
                        idade = rand.nextInt(ESPERANCAVIDAKOALA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nKoala:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Koala(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 17){
                        idade = rand.nextInt(ESPERANCAVIDALEOPARDO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nLeopardo:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Leopardo(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 18){
                        idade = rand.nextInt(ESPERANCAVIDALEÃO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nLeão:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Leão(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 19){
                        idade = rand.nextInt(ESPERANCAVIDALINCE) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nLince:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Lince(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 20){
                        idade = rand.nextInt(ESPERANCAVIDALOBO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nLobo:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Lobo(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 21){
                        idade = rand.nextInt(ESPERANCAVIDAMACACO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nMacaco:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Macaco(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 22){
                        idade = rand.nextInt(ESPERANCAVIDAPANDA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nPanda:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Panda(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 23){
                        idade = rand.nextInt(ESPERANCAVIDAPINGUIM) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nPinguim:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Pinguim(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 24){
                        idade = rand.nextInt(ESPERANCAVIDAPORCO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nPorco:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Porco(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 25){
                        idade = rand.nextInt(ESPERANCAVIDARATO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nRato:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Rato(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }  
                    else if(random == 26){
                        idade = rand.nextInt(ESPERANCAVIDARINOCERONTE) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nRinoceronte:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Rinoceronte(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 27){
                        idade = rand.nextInt(ESPERANCAVIDASURICATA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nSuricata:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Suricata(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 28){
                        idade = rand.nextInt(ESPERANCAVIDATIGRE) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nTigre:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Tigre(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }  
                    else if(random == 29){
                        idade = rand.nextInt(ESPERANCAVIDAURSO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nUrso:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Urso(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random == 30){
                        idade = rand.nextInt(ESPERANCAVIDAZEBRA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.println("\nZebra:\n" +
                        "Idade: " + idade + "\n" +
                        "Preço: " + preco + "\n" +
                        "Atratividade: " + atratividade);
                        Opcoes.add(new Zebra(idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                }
                
                System.out.println("\nEscolha uma ou rejeite todas as propostas de animais: ");
                System.out.println("1 - Animal 1");
                System.out.println("2 - Animal 2");
                System.out.println("3 - Animal 3");
                System.out.println("4 - Rejeitar propostas");
                option = scan.nextInt();
                switch(option){ //Escolha de uma das propostas ou rejeição
                    case 1: 
                        animal = Opcoes.get(0); //Animal é buscado a Opcoes
                        System.out.print("\nIntroduza um nome para o animal: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        Aquisicoes.add(animal); //Caso o animal tenha sido escolhido é inserido o nome e é adicionado a Aquisicoes
                        zoo.addAnimal(animal); //Adicionado ao zoo
                        zoo.setSaldo(zoo.getSaldo() - animal.getPreco()); //Atualização do saldo
                        break;
                    case 2:
                        animal = Opcoes.get(1);
                        System.out.print("\nIntroduza um nome para o animal: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        Aquisicoes.add(animal);
                        zoo.addAnimal(animal);
                        zoo.setSaldo(zoo.getSaldo() - animal.getPreco());
                        break;
                    case 3:
                        animal = Opcoes.get(2);
                        System.out.print("\nIntroduza um nome para o animal: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        Aquisicoes.add(animal);
                        zoo.addAnimal(animal);
                        zoo.setSaldo(zoo.getSaldo() - animal.getPreco());
                        break;
                    case 4:
                        menuPrincipal(zoo);
                        break;
                }
 
                menuPrincipal(zoo);
                break;
            case 2: //Caso o utilizador escolha inserir o animal por completo
                System.out.println("\nEscolha o animal que pretende inserir: \n" + //Apresentada a lista dos 30 animais
                "1 - Boi\n" +
                "2 - Cabra\n" +
                "3 - Canguru\n" +
                "4 - Cavalo\n" +
                "5 - Chita\n" +
                "6 - Cobra\n" +
                "7 - Coelho\n" +
                "8 - Cão\n" +
                "9 - Próxima página");
                
                option = scan.nextInt();
                switch(option){
                    case 1:
                        //Dados do animal continuam a ser aleatórios
                        idade = rand.nextInt(ESPERANCAVIDABOI) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para o boi: ");
                        nome = scan.next(); //Introdução do nome

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1: //O animal é adquirido, adicionado ao zoo e a Aquisicoes e é retirado o saldo
                                animal = new Boi(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;
                                
                    case 2:
                        idade = rand.nextInt(ESPERANCAVIDACABRA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para a cabra: ");
                        nome = scan.next();

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                animal = new Cabra(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;
                        
                    case 3:
                        idade = rand.nextInt(ESPERANCAVIDACANGURU) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para o canguru: ");
                        nome = scan.next();

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                animal = new Canguru(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;
                        
                    case 4:
                        idade = rand.nextInt(ESPERANCAVIDACAVALO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para o cavalo: ");
                        nome = scan.next();

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                animal = new Cavalo(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;
                        
                    case 5:
                        idade = rand.nextInt(ESPERANCAVIDACHITA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para a chita: ");
                        nome = scan.next();

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                animal = new Chita(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;
                        
                    case 6:
                        idade = rand.nextInt(ESPERANCAVIDACOBRA) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para a cobra: ");
                        nome = scan.next();

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                animal = new Cobra(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;

                    case 7:
                        idade = rand.nextInt(ESPERANCAVIDACOELHO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para o coelho: ");
                        nome = scan.next();

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                animal = new Coelho(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;
                        
                    case 8:
                        idade = rand.nextInt(ESPERANCAVIDACÃO) + 1;
                        preco = rand.nextFloat(MAX- MIN) + MIN;
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                        System.out.print("\nIntroduza um nome para o cão: ");
                        nome = scan.next();

                        System.out.print("Nome: " + nome + "\n" +
                        "Idade: " + idade + " anos\n" +
                        "Atratividade: " + atratividade + "\n" +
                        "Preço: " + preco + " euros\n");

                        System.out.println("\n1 - Confirmar a aquisição do animal");
                        System.out.println("0 - Não, voltar ao menu principal");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                animal = new Cão(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                Aquisicoes.add(animal);
                                zoo.addAnimal(animal);
                                zoo.setSaldo(zoo.getSaldo() - preco);
                                break;
                            case 0:
                                menuPrincipal(zoo);
                                break;
                        }
                        break;
                        
                    case 9:
                        System.out.println("\n1 - Dragão\n" +
                        "2 - Galo\n" +
                        "3 - Girafa\n" + 
                        "4 - Gorila\n" +
                        "5 - Hipopótamo\n" +
                        "6 - Jaguar\n" +
                        "7 - Koala\n" +
                        "8 - Leopardo\n" +
                        "9 - Próxima página");
                        option = scan.nextInt();
                        switch(option){
                            case 1:
                                idade = rand.nextInt(ESPERANCAVIDADRAGÃO) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para o dragão: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Dragão(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                            
                            case 2:
                                idade = rand.nextInt(ESPERANCAVIDAGALO) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para o galo: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Galo(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                                
                            case 3:
                                idade = rand.nextInt(ESPERANCAVIDAGIRAFA) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para a girafa: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Girafa(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                                
                            case 4:
                                idade = rand.nextInt(ESPERANCAVIDAGORILA) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para o gorila: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Gorila(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                                        
                            case 5:
                                idade = rand.nextInt(ESPERANCAVIDAHIPOPÓTAMO) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para o hipopótamo: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Hipopótamo(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                                
                            case 6:
                                idade = rand.nextInt(ESPERANCAVIDAJAGUAR) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para o jaguar: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Jaguar(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                                
                            case 7:
                                idade = rand.nextInt(ESPERANCAVIDAKOALA) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para o koala: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Koala(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                                
                            case 8:
                                idade = rand.nextInt(ESPERANCAVIDALEOPARDO) + 1;
                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                System.out.print("\nIntroduza um nome para o leopardo: ");
                                nome = scan.next();

                                System.out.print("Nome: " + nome + "\n" +
                                "Idade: " + idade + " anos\n" +
                                "Atratividade: " + atratividade + "\n" +
                                "Preço: " + preco + " euros\n");

                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                System.out.println("0 - Não, voltar ao menu principal");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        animal = new Leopardo(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                        Aquisicoes.add(animal);
                                        zoo.addAnimal(animal);
                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                        break;
                                    case 0:
                                        menuPrincipal(zoo);
                                        break;
                                }
                                break;
                                
                            case 9:
                                System.out.println("\n1 - Leão\n" +
                                "2 - Lince\n" +
                                "3 - Lobo\n" +
                                "4 - Macaco\n" +
                                "5 - Panda\n" +
                                "6 - Pinguim\n" +
                                "7 - Porco\n" +
                                "8 - Rato\n" +
                                "9 - Próxima página");
                                option = scan.nextInt();
                                switch(option){
                                    case 1:
                                        idade = rand.nextInt(ESPERANCAVIDALEÃO) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o leão: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Leão(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;
                                 
                                    case 2:
                                        idade = rand.nextInt(ESPERANCAVIDALINCE) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o lince: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Lince(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;
                                        
                                    case 3:
                                        idade = rand.nextInt(ESPERANCAVIDALOBO) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o lobo: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Lobo(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;
                                       
                                    case 4:
                                        idade = rand.nextInt(ESPERANCAVIDAMACACO) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o macaco: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Macaco(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;

                                    case 5:
                                        idade = rand.nextInt(ESPERANCAVIDAPANDA) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o panda: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Panda(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;

                                    case 6:
                                        idade = rand.nextInt(ESPERANCAVIDAPINGUIM) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o pinguim: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Pinguim(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;

                                    case 7:
                                        idade = rand.nextInt(ESPERANCAVIDAPORCO) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o porco: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Porco(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;
                                     
                                    case 8:
                                        idade = rand.nextInt(ESPERANCAVIDARATO) + 1;
                                        preco = rand.nextFloat(MAX- MIN) + MIN;
                                        atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                        System.out.print("\nIntroduza um nome para o rato: ");
                                        nome = scan.next();

                                        System.out.print("Nome: " + nome + "\n" +
                                        "Idade: " + idade + " anos\n" +
                                        "Atratividade: " + atratividade + "\n" +
                                        "Preço: " + preco + " euros\n");

                                        System.out.println("\n1 - Confirmar a aquisição do animal");
                                        System.out.println("0 - Não, voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                animal = new Rato(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                Aquisicoes.add(animal);
                                                zoo.addAnimal(animal);
                                                zoo.setSaldo(zoo.getSaldo() - preco);
                                                break;
                                            case 0:
                                                menuPrincipal(zoo);
                                                break;
                                        }
                                        break;
                                        
                                    case 9:
                                        System.out.println("\n1 - Rinoceronte\n" +
                                        "2 - Suricata\n" +
                                        "3 - Tigre\n" +
                                        "4 - Urso\n" +
                                        "5 - Zebra\n" +
                                        "0 - Voltar ao menu principal");
                                        option = scan.nextInt();
                                        switch(option){
                                            case 1:
                                                idade = rand.nextInt(ESPERANCAVIDARINOCERONTE) + 1;
                                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                                System.out.print("\nIntroduza um nome para o rinoceronte: ");
                                                nome = scan.next();

                                                System.out.print("Nome: " + nome + "\n" +
                                                "Idade: " + idade + " anos\n" +
                                                "Atratividade: " + atratividade + "\n" +
                                                "Preço: " + preco + " euros\n");

                                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                                System.out.println("0 - Não, voltar ao menu principal");
                                                option = scan.nextInt();
                                                switch(option){
                                                    case 1:
                                                        animal = new Rinoceronte(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                        Aquisicoes.add(animal);
                                                        zoo.addAnimal(animal);
                                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                                        break;
                                                    case 0:
                                                        menuPrincipal(zoo);
                                                        break;
                                                }
                                                break;
                                             
                                            case 2:
                                                idade = rand.nextInt(ESPERANCAVIDASURICATA) + 1;
                                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                                System.out.print("\nIntroduza um nome para o suricata: ");
                                                nome = scan.next();

                                                System.out.print("Nome: " + nome + "\n" +
                                                "Idade: " + idade + " anos\n" +
                                                "Atratividade: " + atratividade + "\n" +
                                                "Preço: " + preco + " euros\n");

                                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                                System.out.println("0 - Não, voltar ao menu principal");
                                                option = scan.nextInt();
                                                switch(option){
                                                    case 1:
                                                        animal = new Suricata(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                        Aquisicoes.add(animal);
                                                        zoo.addAnimal(animal);
                                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                                        break;
                                                    case 0:
                                                        menuPrincipal(zoo);
                                                        break;
                                                }
                                                break;
                                                
                                            case 3:
                                                idade = rand.nextInt(ESPERANCAVIDATIGRE) + 1;
                                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                                System.out.print("\nIntroduza um nome para o tigre: ");
                                                nome = scan.next();

                                                System.out.print("Nome: " + nome + "\n" +
                                                "Idade: " + idade + " anos\n" +
                                                "Atratividade: " + atratividade + "\n" +
                                                "Preço: " + preco + " euros\n");

                                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                                System.out.println("0 - Não, voltar ao menu principal");
                                                option = scan.nextInt();
                                                switch(option){
                                                    case 1:
                                                        animal = new Tigre(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                        Aquisicoes.add(animal);
                                                        zoo.addAnimal(animal);
                                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                                        break;
                                                    case 0:
                                                        menuPrincipal(zoo);
                                                        break;
                                                }
                                                break;
                                                
                                            case 4:
                                                idade = rand.nextInt(ESPERANCAVIDAURSO) + 1;
                                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                                System.out.print("\nIntroduza um nome para o urso: ");
                                                nome = scan.next();

                                                System.out.print("Nome: " + nome + "\n" +
                                                "Idade: " + idade + " anos\n" +
                                                "Atratividade: " + atratividade + "\n" +
                                                "Preço: " + preco + " euros\n");

                                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                                System.out.println("0 - Não, voltar ao menu principal");
                                                option = scan.nextInt();
                                                switch(option){
                                                    case 1:
                                                        animal = new Urso(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                        Aquisicoes.add(animal);
                                                        zoo.addAnimal(animal);
                                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                                        break;
                                                    case 0:
                                                        menuPrincipal(zoo);
                                                        break;
                                                }
                                                break;
                                                
                                            case 5:
                                                idade = rand.nextInt(ESPERANCAVIDAZEBRA) + 1;
                                                preco = rand.nextFloat(MAX- MIN) + MIN;
                                                atratividade = rand.nextFloat(MAX - MIN) + MIN;

                                                System.out.print("\nIntroduza um nome para a zebra: ");
                                                nome = scan.next();

                                                System.out.print("Nome: " + nome + "\n" +
                                                "Idade: " + idade + " anos\n" +
                                                "Atratividade: " + atratividade + "\n" +
                                                "Preço: " + preco + " euros\n");

                                                System.out.println("\n1 - Confirmar a aquisição do animal");
                                                System.out.println("0 - Não, voltar ao menu principal");
                                                option = scan.nextInt();
                                                switch(option){
                                                    case 1:
                                                        animal = new Zebra(nome, idade, atratividade, preco, temAlbinismo, temHeterocromismo, temMelanismo);
                                                        Aquisicoes.add(animal);
                                                        zoo.addAnimal(animal);
                                                        zoo.setSaldo(zoo.getSaldo() - preco);
                                                        break;
                                                    case 0:
                                                        menuPrincipal(zoo);
                                                        break;
                                                }
                                                break;
                                                
                                            case 0:
                                                menuPrincipal(zoo);
                                        }
                                }
                        }
                        break;
                    case 0:
                        menuPrincipal(zoo);
                }
        }
        
        System.out.println("\nO saldo contabilístico do zoo passou para: " + zoo.getSaldo() + " euros."); //Apresentação do saldo contabilístico
        
        menuPrincipal(zoo);
    }
    
    public static void retratoDeFamiliaAnimal(Zoo zoo){ 
        //Se o zoo tiver um animal a palavra aparece no singular caso contrário no plural
        if(zoo.getAnimais().size() == 1){
            System.out.println("\nO zoo tem " + zoo.getAnimais().size() + " animal.");
        }
        else{
            System.out.println("\nO zoo tem " + zoo.getAnimais().size() + " animais.");
        }
        if(!zoo.getAnimais().isEmpty()){ //Se o zoo tiver animais é apresentado a lista
            System.out.println("Os animais presentes no zoo são: \n");
            for (int i = 0; i < zoo.getAnimais().size(); i++){ //Enquanto i for menor que o array é mostrada a espécie e os dados do animal
                System.out.println("Espécie: " + zoo.getAnimais().get(i).getClass().getSimpleName()); //Buscar o nome da classe do animal 
                System.out.println(zoo.getAnimais().get(i)); //Buscar cada animal para cada posição i do array
            }
            menuPrincipal(zoo);
        }
        else{
            menuPrincipal(zoo);
        }
    }
    
    public static void calendarioChines(Zoo zoo){ 
        Scanner scan = new Scanner(System.in, "cp1252");
        
        int year;
        final int BONUS = 1000; //Bonus de atratividade para o animal do respetivo ano
        
        Animal animal;
        
        System.out.print("Introduza o ano que pretende: ");
        year = scan.nextInt();

        //Apresentação da frase a dizer qual animal dá mais atratividade no ano introduzido
        if(year % 12 == 0){
            System.out.println("\nEste ano os macacos dão maior atratividade.");
        }
        else if(year % 12 == 1){
            System.out.println("\nEste ano os galos dão maior atratividade.");
        }
        else if(year % 12 == 2){
            System.out.println("\nEste ano os cães dão maior atratividade.");
        }
        else if(year % 12 == 3){
            System.out.println("\nEste ano os porcos dão maior atratividade.");
        }
        else if(year % 12 == 4){
            System.out.println("\nEste ano os ratos dão maior atratividade.");
        }
        else if(year % 12 == 5){
            System.out.println("\nEste ano os bois dão maior atratividade.");
        }
        else if(year % 12 == 6){
            System.out.println("\nEste ano os tigres dão maior atratividade.");
        }
        else if(year % 12 == 7){
            System.out.println("\nEste ano os coelhos dão maior atratividade.");
        }
        else if(year % 12 == 8){
            System.out.println("\nEste ano os dragões dão maior atratividade.");
        }
        else if(year % 12 == 9){
            System.out.println("\nEste ano as cobras dão maior atratividade.");
        }
        else if(year % 12 == 10){
            System.out.println("\nEste ano os cavalos dão maior atratividade.");
        }
        else if(year % 12 == 11){
            System.out.println("\nEste ano as cabras dão maior atratividade.");
        }
        
        //Se o zoo não estiver vazio vai buscar os animais presentes em instalações
        if(!zoo.getAnimais().isEmpty()){
            System.out.println("Os animais presentes no zoo são: \n");
            for(int i = 0; i < zoo.getInstalacoes().size(); i++){ //Buscar as instalações no zoo
                for (int j = 0; j < zoo.getInstalacoes().get(i).getAnimais().size(); j++){ //Percorrer os animais da instalação da posição i
                    animal = zoo.getInstalacoes().get(j).getAnimais().get(i);
                    if(year % 12 == 0 && animal.getClass() == Macaco.class){ //Se o resto da divisão do ano por 12 for 0 e o animal for da classe Macaco
                        animal.setAtratividade(animal.getAtratividade() + BONUS); //Atribuído o BONUS
                    }
                    else if(year % 12 == 1 && animal.getClass() == Galo.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 2 && animal.getClass() == Cão.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 3 && animal.getClass() == Porco.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 4 && animal.getClass() == Rato.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 5 && animal.getClass() == Boi.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 6 && animal.getClass() == Tigre.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 7 && animal.getClass() == Coelho.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 8  && animal.getClass() == Dragão.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 9 && animal.getClass() == Cobra.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 10 && animal.getClass() == Cavalo.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                    else if(year % 12 == 11 && animal.getClass() == Cabra.class){
                        animal.setAtratividade(animal.getAtratividade() + BONUS);
                    }
                }
            }
            menuPrincipal(zoo);
        }
        else {
            System.out.println("O zoo tem " + zoo.getAnimais().size() + " animais."); //Vai mostrar que tem 0 animais caso o zoo não tenha animais no zoo
            menuPrincipal(zoo);
        }

        menuPrincipal(zoo);
    }
    
    public static void construirInstalacao(Zoo zoo){
        Scanner scan = new Scanner(System.in, "cp1252");
        
        int c1, c2, c3; //3 capacidades
        float p1, p2, p3; //3 preços
        final int MAX_CAPACIDADE = 10; //Máximo de capacidade
        final int MIN_CAPACIDADE = 1; //Mínimo de capacidade
        
        Random rand = new Random();
        
        c1 = rand.nextInt(MAX_CAPACIDADE) + MIN_CAPACIDADE; //Random entre 1 e 10 pra capacidade
        p1 = rand.nextFloat(MAX) + MIN; //Preço entre 500 e 5000
        c2 = rand.nextInt(MAX_CAPACIDADE) + MIN_CAPACIDADE;
        p2 = rand.nextFloat(MAX) + MIN;
        c3 = rand.nextInt(MAX_CAPACIDADE) + MIN_CAPACIDADE;
        p3 = rand.nextFloat(MAX) + MIN;
        
        System.out.println("\nRecebeu 3 propostas para uma nova instalação: \n"); //São apresentadas as 3 propostas
        System.out.println("Proposta 1 - Capacidade: " + c1 + " animais || Preço: " + p1);
        System.out.println("Proposta 2 - Capacidade: " + c2 + " animais || Preço: " + p2);
        System.out.println("Proposta 3 - Capacidade: " + c3 + " animais || Preço: " + p3);

        System.out.println("\nEscolha uma ou rejeite todas as propostas: ");
        System.out.println("1 - Proposta 1");
        System.out.println("2 - Proposta 2");
        System.out.println("3 - Proposta 3");
        System.out.println("4 - Rejeitar propostas");
        option = scan.nextInt();
        Instalacao instalacao;
        switch(option){
            case 1://Caso seja escolhida uma é instanciada a instalação com o respetivo preço e capacidade, adicionada ao zoo e o preço é subtraído no saldo
                instalacao = new Instalacao(c1, p1);
                zoo.addInstalacao(instalacao);
                zoo.setSaldo(zoo.getSaldo() - instalacao.getPreco());
                break;
            case 2:
                instalacao = new Instalacao(c2, p2);
                zoo.addInstalacao(instalacao);
                zoo.setSaldo(zoo.getSaldo() - instalacao.getPreco());
                break;
            case 3:
                instalacao = new Instalacao(c3, p3);
                zoo.addInstalacao(instalacao);
                zoo.setSaldo(zoo.getSaldo() - instalacao.getPreco());
                break;
            case 4:
                menuPrincipal(zoo);
                break;
            case 0:
                System.exit(0);
        }
        
        System.out.println("\nO saldo contabilístico do zoo passou para: " + zoo.getSaldo() + " euros.");
        
        menuPrincipal(zoo);
    }
    
    public static void retratoDeInstalacoes(Zoo zoo){ //Mostrar as instalações
        if(zoo.getInstalacoes().size()==1){ //Singular
            System.out.println("\nO zoo tem " + zoo.getInstalacoes().size() + " instalacão.");
        }
        else{ //Plural
            System.out.println("\nO zoo tem " + zoo.getInstalacoes().size() + " instalações.");
        }
        if(!zoo.getInstalacoes().isEmpty()){ //Se o zoo tiver instalações
            System.out.println("As instalações presentes no zoo são: \n");
            for (int i = 0; i < zoo.getInstalacoes().size(); i++){ //Ciclo para percorrer as instalações
                System.out.println(zoo.getInstalacoes().get(i));
            }
            menuPrincipal(zoo);
        }
        else{
            menuPrincipal(zoo);
        }
    }
    
    public static void introduzirAnimais(Zoo zoo){ //Introduzir animais nas instalações
        Scanner scan = new Scanner(System.in, "cp1252");
        
        int idAnimal, idInstalacao;

        Instalacao instalacao;
        Animal animal;
        
        //Caso não haja animais ou instalações
        if(zoo.getAnimais().isEmpty()){
            System.out.println("\nAdquira animais primeiro.");
            menuPrincipal(zoo);
        }
        if(zoo.getInstalacoes().isEmpty()){
            System.out.println("\nAdquira instalações primeiro.");
            menuPrincipal(zoo);
        }
        
        else{
            System.out.print("\nInsira o número do animal: ");
            idAnimal = scan.nextInt(); //Inserido o id do animal
            if(idAnimal > zoo.getAnimais().size()){ //Se o id for maior que o tamanho do array o id não corresponde a nenhum animal
                System.out.print("\nO número " + idAnimal + " não corresponde a nenhum animal.\n");
                menuPrincipal(zoo);
            }
            animal = zoo.getAnimais().get(idAnimal - 1); //Se o id introduzido for 1 vai buscar ao array na posição 0

            for(int i = 0; i < zoo.getInstalacoes().size(); i++){
                for (int j = 0; j < zoo.getInstalacoes().get(i).getAnimais().size(); j++){ //Percorrer animais nas instalações
                    if(animal == zoo.getAnimais().get(j)){ //Se o animal cujo id foi introduzido for igual ao animal presente no array
                        System.out.println("O animal já pertence a outra instalação. Pretende mudá-lo de instalação?");//Diz que já está numa instalação e se pretende mudá-lo de instalação
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não, voltar ao menu principal");
                        System.out.println("0 - Sair da aplicação");
                        
                        option = scan.nextInt(); 
                        switch(option){
                            case 1:
                                System.out.print("Insira o número da instalação: ");
                                idInstalacao = scan.nextInt(); //Inserido o id da instalação
                                if(idInstalacao > zoo.getInstalacoes().size()){ //Se o id for maior que o tamanho do array o id não corresponde a nenhuma instalação
                                    System.out.print("\nO número " + idInstalacao + " não corresponde a nenhuma instalação.\n"); 
                                    menuPrincipal(zoo);
                                }
                                instalacao = zoo.getInstalacoes().get(idInstalacao - 1); //Se o id introduzido for 1 vai buscar ao array na posição 0
                                zoo.getInstalacoes().get(i).removeAnimal(animal); //O animal é removido da instalação que estava
                                
                                if(instalacao.getCapacidade() == instalacao.getAnimais().size()){ //Se o tamanho do array atingir a capacidade, diz que a instalação está cheia
                                    System.out.println("\nEsta instalação está cheia."); 
                                    menuPrincipal(zoo);
                                }
                                break;
                            case 2:
                                menuPrincipal(zoo);
                                break;
                            case 0:
                                System.exit(0);
                        }
                    }
                }
            }
            
            System.out.print("Insira o número da instalação: ");
            idInstalacao = scan.nextInt(); //Inserido o id da instalação
            if(idInstalacao > zoo.getInstalacoes().size()){ //Se o id for maior que o tamanho do array o id não corresponde a nenhuma instalação
                System.out.print("\nO número " + idInstalacao + " não corresponde a nenhuma instalação.\n");
                menuPrincipal(zoo);
            }
            instalacao = zoo.getInstalacoes().get(idInstalacao - 1);
            
            if(instalacao.getCapacidade() == instalacao.getAnimais().size()){ //Se o tamanho do array atingir a capacidade, diz que a instalação está cheia
                System.out.println("\nEsta instalação está cheia.");
                menuPrincipal(zoo);
            }
            
            //Confirmação
            System.out.println("\nInserir o animal: ");
            System.out.println("Espécie: " + animal.getClass().getSimpleName());
            System.out.println(animal);
            System.out.println("Na instalação: ");
            System.out.println(instalacao);
            
            System.out.println("\nConfirma a sua escolha?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não, voltar ao menu principal");
            System.out.println("0 - Sair da aplicação");
            option = scan.nextInt();
            switch(option){
                case 1://Se sim o animal é adicionado à instalação
                    instalacao.addAnimal(animal);
                    menuPrincipal(zoo);
                    break;
                case 2:
                    menuPrincipal(zoo);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
    
    public static void periodoContabilistico(Zoo zoo){
        int random;
        double random2;
        Random rand = new Random();
        Animal animal;
        final int MARGEM = 3; //Margem de vida
        final int PERCENTAGEMTOTAL = 100;
        final double PERCENTAGEMPARCIAL2 = 3.33;
        final float PRECO_NASCIMENTO = 1000;
        int idade = 0;
        float atratividade;
        boolean temAlbinismo = rand.nextBoolean();
        boolean temHeterocromismo = rand.nextBoolean();
        boolean temMelanismo = rand.nextBoolean();
        
        if(zoo.getAnimais().size()>0){ //Se houver animais no zoo

            float atratividadeTotal = 500;
            for(int i = 0; i < zoo.getInstalacoes().size(); i++){
                for (int j = 0; j < zoo.getInstalacoes().get(i).getAnimais().size(); j++){
                    atratividadeTotal = atratividadeTotal + zoo.getInstalacoes().get(i).getAnimais().get(j).getAtratividade(); //Adiciona à atratividadeTotal a atratividade de cada animal nas instalações
                }
            }
            System.out.println("\nO zoo obteve uma atratividade total de: " + atratividadeTotal + ", sendo adicionado este valor em euros ao saldo contabilístico do zoo.");
            zoo.setSaldo(zoo.getSaldo() + atratividadeTotal); //Adicionado ao saldo do zoo a atratividadeTotal
            System.out.println("\nO saldo contabilístico do zoo passou para: " + zoo.getSaldo() + " euros.");
        
        //MORTES
            for (int i = 0; i < zoo.getAnimais().size(); i++){
                animal = zoo.getAnimais().get(i);
                if(animal.getClass() == Boi.class){ //Se animal for da classe Boi
                    if(animal.getIdade() >= (ESPERANCAVIDABOI - MARGEM)){ //Se o animal tiver idade maior do que a esperança de vida menos 3 anos
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 50){ //50% probabilidade do animal morrer
                            Obituario.add(animal); //Adicionado ao Obituario
                            zoo.removeAnimal(animal); //Animal removido do zoo
                        }
                    }
                    else{ //Com qualquer idade o animal tem 10% probabilidade de morrer
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Cabra.class){
                    if(animal.getIdade() >= (ESPERANCAVIDACABRA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Canguru.class){
                    if(animal.getIdade() >= (ESPERANCAVIDACANGURU - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Cavalo.class){
                    if(animal.getIdade() >= (ESPERANCAVIDACAVALO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Chita.class){
                    if(animal.getIdade() >= (ESPERANCAVIDACHITA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Cobra.class){
                    if(animal.getIdade() >= (ESPERANCAVIDACOBRA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Coelho.class){
                    if(animal.getIdade() >= (ESPERANCAVIDACOELHO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Cão.class){
                    if(animal.getIdade() >= (ESPERANCAVIDACÃO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Dragão.class){
                    if(animal.getIdade() >= (ESPERANCAVIDADRAGÃO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Elefante.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAELEFANTE - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Galo.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAGALO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Girafa.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAGIRAFA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Gorila.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAGORILA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Hipopótamo.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAHIPOPÓTAMO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Jaguar.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAJAGUAR - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Koala.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAKOALA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Leopardo.class){
                    if(animal.getIdade() >= (ESPERANCAVIDALEOPARDO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Leão.class){
                    if(animal.getIdade() >= (ESPERANCAVIDALEÃO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Lince.class){
                    if(animal.getIdade() >= (ESPERANCAVIDALINCE - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Lobo.class){
                    if(animal.getIdade() >= (ESPERANCAVIDALOBO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Macaco.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAMACACO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Panda.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAPANDA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Pinguim.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAPINGUIM - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Porco.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAPORCO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Rato.class){
                    if(animal.getIdade() >= (ESPERANCAVIDARATO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Rinoceronte.class){
                    if(animal.getIdade() >= (ESPERANCAVIDARINOCERONTE - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Suricata.class){
                    if(animal.getIdade() >= (ESPERANCAVIDASURICATA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Tigre.class){
                    if(animal.getIdade() >= (ESPERANCAVIDATIGRE - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Urso.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAURSO - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
                else if (animal.getClass() == Zebra.class){
                    if(animal.getIdade() >= (ESPERANCAVIDAZEBRA - MARGEM)){
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random >= 50){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                    else{
                        random = rand.nextInt(PERCENTAGEMTOTAL) + 1;
                        if(random <= 10){
                            Obituario.add(animal);
                            zoo.removeAnimal(animal);
                        }
                    }
                }
            }
        
            //NASCIMENTOS
            if(zoo.getAnimais().size()>=2){ //Se houver pelo menos 2 animais no zoo podem nascer animais aleatoriamente sem nenhum critério
                random = rand.nextInt(5) + 1;
                for(int i = 0; i < random; i++){ //Acontece entre 1 e 5 nascimentos
                    random2 = rand.nextDouble(PERCENTAGEMTOTAL) + 1;
                    
                    //Cada animal tem 3.33% de probabilidade de nascer cada animal depois de ser criado aleatório e com idade 0, é adicionado a Nascimentos
                    if(random2 <= PERCENTAGEMPARCIAL2){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nBoi:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Boi(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > PERCENTAGEMPARCIAL2 && random2 <= (2*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nCabra:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Cabra(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (2*PERCENTAGEMPARCIAL2) && random2 <= (3*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nCanguru:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Canguru(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (3*PERCENTAGEMPARCIAL2) && random2 <= (4*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nCavalo:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Cavalo(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (4*PERCENTAGEMPARCIAL2) && random2 <= (5*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nChita:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Chita(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (5*PERCENTAGEMPARCIAL2) && random2 <= (6*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nCobra:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Cobra(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (6*PERCENTAGEMPARCIAL2) && random2 <= (7*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nCoelho:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Coelho(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (7*PERCENTAGEMPARCIAL2) && random2 <= (8*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nCão:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Cão(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (8*PERCENTAGEMPARCIAL2) && random2 <= (9*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nDragão:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Dragão(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (9*PERCENTAGEMPARCIAL2) && random2 <= (10*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nElefante:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Elefante(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (10*PERCENTAGEMPARCIAL2) && random2 <= (11*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nGalo:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Galo(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (11*PERCENTAGEMPARCIAL2) && random2 <= (12*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nGirafa:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Girafa(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (12*PERCENTAGEMPARCIAL2) && random2 <= (13*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nHipopótamo:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Hipopótamo(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (13*PERCENTAGEMPARCIAL2) && random2 <= (14*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nJaguar:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Jaguar(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (14*PERCENTAGEMPARCIAL2) && random2 <= (15*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nKoala:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Koala(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (15*PERCENTAGEMPARCIAL2) && random2 <= (16*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nLeopardo:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Leopardo(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (16*PERCENTAGEMPARCIAL2) && random2 <= (17*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nLeão:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Leão(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (17*PERCENTAGEMPARCIAL2) && random2 <= (18*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nLince:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Lince(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (18*PERCENTAGEMPARCIAL2) && random2 <= (19*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nLobo:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Lobo(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (19*PERCENTAGEMPARCIAL2) && random2 <= (20*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nMacaco:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Macaco(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (20*PERCENTAGEMPARCIAL2) && random2 <= (21*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nPanda:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Panda(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (21*PERCENTAGEMPARCIAL2) && random2 <= (22*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nPinguim:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Pinguim(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (22*PERCENTAGEMPARCIAL2) && random2 <= (23*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nPorco:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Porco(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (23*PERCENTAGEMPARCIAL2) && random2 <= (24*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nRato:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Rato(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (24*PERCENTAGEMPARCIAL2) && random2 <= (25*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nRinoceronte:\n" + 
                        "Idade: " + idade + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Rinoceronte(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (25*PERCENTAGEMPARCIAL2) && random2 <= (26*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nSuricata:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Suricata(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (26*PERCENTAGEMPARCIAL2) && random2 <= (27*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nTigre:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Tigre(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (27*PERCENTAGEMPARCIAL2) && random2 <= (28*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nUrso:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Urso(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                    else if(random2 > (28*PERCENTAGEMPARCIAL2)){
                        atratividade = rand.nextFloat(MAX - MIN) + MIN;
                        System.out.println("\nZebra:\n" + 
                        "Idade: " + idade + "\n" +
                        "Preço: " + PRECO_NASCIMENTO + "\n" +
                        "Atratividade: " + atratividade);
                        Nascimentos.add(new Zebra(idade, atratividade, PRECO_NASCIMENTO, temAlbinismo, temHeterocromismo, temMelanismo));
                    }
                }
            }
            else{
                System.out.println("\nNão ocorreram quaisquer nascimentos. O zoo tem que ter pelo menos dois animais para ocorrer nascimentos.");
            }
            
            if(zoo.getAnimais().size()>=2){
                fazerMutacoes(zoo); //São feitas mutações
            }
        }
        
        else{
            System.out.println("\nO zoo ainda não tem animais para percorrer o período contabilístico.");
        }
        
        menuPrincipal(zoo);
    }
    
    public static void obituario(Zoo zoo){ //Mostrar animais mortos
        if(Obituario.size() == 0){
            System.out.println("\nAinda não faleceram quaisquer animais.");
        }
        else{
            System.out.println("Lista dos animais que faleceram, pela ordem de falecimento: ");
            for(int i = 0; i < Obituario.size(); i++){ 
                System.out.println(Obituario.get(i)); //Percorrer Obituario
            }
        }
        menuPrincipal(zoo);
    }
    
    public static void nascimentos(Zoo zoo){ //Mostrar animais mortos e atribuir nome ao animal
        Scanner scan = new Scanner(System.in, "cp1252");
        
        Animal animal;
        String nome;
        
        if(Nascimentos.size() > 0) {
            System.out.println("Lista dos animais que nasceram, pela ordem de nascimento: ");
            for(int i = 0; i < Nascimentos.size(); i++){
                animal = Nascimentos.get(i); //Mostrar animais
                System.out.println("Espécie: " + animal.getClass().getSimpleName());
                System.out.println(animal); 
                System.out.println("Atribuir nome ao animal e adicionar ao zoo:");
                nome = scan.next();
                animal.setNome(nome); //Colocar nome introduzido ao animal
                zoo.addAnimal(animal); //Adicionar animal ao zoo
                Nascimentos.clear(); //É esvaziado Nascimentos
            }
        }
        else{ //Caso contrário não ocorreram nascimentos ainda
            System.out.println("\nNão ocorreram quaisquer nascimentos.");
        }
        menuPrincipal(zoo);
    }
    
    public static void consultarSaldo(Zoo zoo){
        System.out.println("\nO saldo contabilístico do zoo, neste momento, são " + zoo.getSaldo() + " euros.");
        menuPrincipal(zoo);
        if(zoo.getSaldo() < 0){ //Se o saldo for nulo acontece jumanji
            jumanji(zoo);
        }
    }
    
    public static void historico(Zoo zoo){
        Animal animala;
        
        if(zoo.getAnimais().size()==0){ //Se não há animais não foi feito nada no zoo ainda
            System.out.println("\nAinda não executou qualquer ação no seu zoo.");
        }
        else{
            System.out.println("\nAquisições de animais para o zoo: ");
            for(int i = 0; i < Aquisicoes.size(); i++){ //Mostrar animais no Aquisicoes
                animala = Aquisicoes.get(i); 
                System.out.println("Espécie: " + animala.getClass().getSimpleName());
                System.out.println(animala);
            }
        }
        
        obituario(zoo); //Mostra obituario
        
        consultarSaldo(zoo); //Mostra saldo
        
    }
    
    public static void jumanji(Zoo zoo){
        final int PREJUIZO = 1000000; //Prejuízo definido para o jumanji
        Random rand = new Random();
        
        if(zoo.getAnimais().size()>0){
            
            //Desaparecer animais do zoo
            for(int i= 0; i < zoo.getAnimais().size(); i++){
                if((rand.nextInt(100)+1)<50){
                    zoo.getAnimais().remove(i);
                    i--;
                }
            }
            
            //Desaparecer animais das instalações mas continuam no zoo
            for(int i= 0; i < zoo.getInstalacoes().size(); i++){
                for(int j = 0; j < zoo.getInstalacoes().get(i).getAnimais().size(); j++){
                    if((rand.nextInt(100)+1)<50){
                        zoo.getInstalacoes().get(i).getAnimais().remove(j);
                        j--;
                    }
                }
            }
            
            //Prejuízo causado pelo Jumanji + Mensagem final
            zoo.setSaldo(zoo.getSaldo() - PREJUIZO);

            System.out.println("\nVários animais desapareceram das instalações. Outros desapareceram do zoo.");
            System.out.println("Verifique o que aconteceu através do menu.");
            
            System.out.println("\nApós o Jumanji, o saldo do zoo passou para " + zoo.getSaldo() + " euros.");
        }
        else{
            System.out.println("\nO seu zoo está vazio.");
        }
        
        menuPrincipal(zoo);
    }
    
    public static void fazerMutacoes(Zoo zoo) {
        Scanner scan = new Scanner(System.in, "cp1252");
        
        Random rand = new Random();
        
        int id1, id2;
        String nome;
        final float ATRATIVIDADEMUTACAO = 5000;
        
        Animal animal;
        Animal animal1;
        Animal animal2;
        
        id1 = rand.nextInt(zoo.getAnimais().size());
        id2 = rand.nextInt(zoo.getAnimais().size());
        
        //Se id2 for igual id1 enquanto não for diferente vai atualizar id2
        while(id1 == id2){
            id2 = rand.nextInt(zoo.getAnimais().size());
        }
        
        //2 animais randoms
        animal1 = zoo.getAnimais().get(id1);
        animal2 = zoo.getAnimais().get(id2);
        
        //Array com interfaces
        Class<?>[] interfaces1 = animal1.getClass().getInterfaces();
        Class<?>[] interfaces2 = animal2.getClass().getInterfaces();
        
        for (Class<?> interface1 : interfaces1) { //Para cada interface1 de cada interface no array interfaces1
            for (Class<?> interface2 : interfaces2) { //Para cada interface2 de cada interface no array interfaces2
                if (interface1.getName().equals(interface2.getName()) && animal1.getClass()!= animal2.getClass()) { //Se ambos animais implementarem mesma interface e forem de classes diferentes
                    if((animal1.getClass().getSimpleName() == "Lobo" && animal2.getClass().getSimpleName() == "Cão") ||  (animal2.getClass().getSimpleName() == "Lobo" && animal1.getClass().getSimpleName() == "Cão")){
                        if((rand.nextInt(100)+1) <= 50){ //50% probabilidade de haver mutação
                            animal = new Cão(0, ATRATIVIDADEMUTACAO, 0, false, false, false); //Instanciado um animal "genérico"
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){ //Se anima1 ou animal2 tiver albinismo é passado o albinismo para animal como true
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Lobo(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: "); //Atribuir nome ao animal "mutante"
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else if((animal1.getClass().getSimpleName() == "Cavalo" && animal2.getClass().getSimpleName() == "Zebra") ||  (animal2.getClass().getSimpleName() == "Cavalo" && animal1.getClass().getSimpleName() == "Zebra")){
                        if((rand.nextInt(100)+1) <= 50){
                            animal = new Cavalo(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Zebra(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else if((animal1.getClass().getSimpleName() == "Jaguar" && animal2.getClass().getSimpleName() == "Leopardo") ||  (animal2.getClass().getSimpleName() == "Jaguar" && animal1.getClass().getSimpleName() == "Leopardo")){
                        if((rand.nextInt(100)+1) <= 50){
                            animal = new Jaguar(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Leopardo(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else if((animal1.getClass().getSimpleName() == "Jaguar" && animal2.getClass().getSimpleName() == "Leão") ||  (animal2.getClass().getSimpleName() == "Jaguar" && animal1.getClass().getSimpleName() == "Leão")){
                        if((rand.nextInt(100)+1) <= 50){
                            animal = new Jaguar(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Leão(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else if((animal1.getClass().getSimpleName() == "Jaguar" && animal2.getClass().getSimpleName() == "Tigre") ||  (animal2.getClass().getSimpleName() == "Jaguar" && animal1.getClass().getSimpleName() == "Tigre")){
                        if((rand.nextInt(100)+1) <= 50){
                            animal = new Jaguar(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Tigre(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else if((animal1.getClass().getSimpleName() == "Leopardo" && animal2.getClass().getSimpleName() == "Leão") ||  (animal2.getClass().getSimpleName() == "Leopardo" && animal1.getClass().getSimpleName() == "Leão")){
                        if((rand.nextInt(100)+1) <= 50){
                            animal = new Leopardo(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Leão(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else if((animal1.getClass().getSimpleName() == "Leopardo" && animal2.getClass().getSimpleName() == "Tigre") ||  (animal2.getClass().getSimpleName() == "Leopardo" && animal1.getClass().getSimpleName() == "Tigre")){
                        if((rand.nextInt(100)+1) <= 50){
                            animal = new Leopardo(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Tigre(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else if((animal1.getClass().getSimpleName() == "Tigre" && animal2.getClass().getSimpleName() == "Leão") ||  (animal2.getClass().getSimpleName() == "Tigre" && animal1.getClass().getSimpleName() == "Leão")){
                        if((rand.nextInt(100)+1) <= 50){
                            animal = new Tigre(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        else {
                            animal = new Leão(0, ATRATIVIDADEMUTACAO, 0, false, false, false);
                            if(animal1.temAlbinismo() || animal2.temAlbinismo()){
                                animal.setAlbinismo(true);
                            }
                            if(animal1.temHeterocromia() || animal2.temHeterocromia()){
                                animal.setHeterocromia(true);
                            }
                            if(animal1.temMelanismo() || animal2.temMelanismo()){
                                animal.setMelanismo(true);
                            }
                        }
                        System.out.println("\nOs dois animais têm o mesmo genoma. Aconteceu o nascimento de um animal por mutação.");
                        System.out.println("Introduza o nome para o novo animal mutante: ");
                        nome = scan.next();
                        animal.setNome(nome);
                        zoo.addAnimal(animal);
                    }
                    else{ //Caso contrário só apresenta a seguinte mensagem
                        System.out.println("\nNão ocorreu qualquer mutação.");
                    }
                }
            }
        }
        
        menuPrincipal(zoo);
    }
    
    public static void menuCaracteristicas(Zoo zoo){ //Mostra os animais com dada característica
        Scanner scan = new Scanner(System.in, "cp1252");
        
        Animal animal;
        
        //Array para animais com cada caracteristica
        ArrayList<Animal> albinismo = new ArrayList<Animal>();
        ArrayList<Animal> heterocromia = new ArrayList<Animal>();
        ArrayList<Animal> melanismo = new ArrayList<Animal>();
        
        for(int i = 0; i < zoo.getAnimais().size(); i++){
            animal = zoo.getAnimais().get(i); //Percorrer animais, caso tenham uma dada característica são adicionados ao array da mesma
            if(animal.temAlbinismo()){
                albinismo.add(animal);
            }
            if(animal.temHeterocromia()){
                heterocromia.add(animal);
            }
            if(animal.temMelanismo()){
                melanismo.add(animal);
            }
        }
        
        System.out.println("\n1 - Animais com albinismo");
        System.out.println("2 - Animais com heterocromia");
        System.out.println("3 - Animais com melanismo");
        System.out.println("0 - Voltar ao menu principal");
        option = scan.nextInt();
        switch(option){
            case 1:
                for(int i = 0; i < albinismo.size(); i++){ //Percorrer cada array de características
                    System.out.println(albinismo.get(i));
                }
                menuPrincipal(zoo);
                break;
            case 2:
                for(int i = 0; i < heterocromia.size(); i++){
                    System.out.println(heterocromia.get(i));
                }
                menuPrincipal(zoo);
                break;
            case 3:
                for(int i = 0; i < melanismo.size(); i++){
                    System.out.println(melanismo.get(i));
                }
                menuPrincipal(zoo);
                break;
            case 0:
                menuPrincipal(zoo);
                break;
        }
    }
}