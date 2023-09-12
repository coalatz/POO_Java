//passou tudo
//fiz sozinho
//tambem estou fazendo um curso de poo em java do gustavo guanabara
// e por la ja tinha tido um certo contato com os modificadores de acesso
// entao foi algo familiar, mas serviu bem pra aprender e praticar, ja tinha feito
// uma atividade usando os mesmo conceitos e esta no driva tambem
// 2 horas

import java.util.Scanner;

class Pet {
    private boolean alive;
    private int clean;
    private int cleanMax;
    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int age;
    private int diamonds;
    
    private boolean testeAlive() {
        if(this.energy >0 && this.hungry > 0 && this.clean > 0){
            return true;
        } else {
            return false;
        }
        
    }
    public Pet(int e, int h, int c) {
        this.alive = true;
        this.energyMax = e;
        this.hungryMax = h;
        this.cleanMax = c;
        this.energy = energyMax;
        this.hungry = hungryMax;
        this.clean = cleanMax;
        diamonds = 0;
        age =0;
    }
    
    public String toString(){
        String ss = "";
        ss +=  "E:" + energy + "/" + energyMax + ", "
            +  "S:" + hungry + "/" + hungryMax + ", "
            +  "L:" + clean + "/" + cleanMax + ", "
            +  "D:" + diamonds + ", " + "I:"  + age;
        return ss;
    }
    
    
    
    public void eat() {  //comer
    
        if(testeAlive()){
            this.setEnergy(this.energy - 1);
            this.setHungry(this.hungry + 4);
            this.setClean(this.clean - 2);
            this.age++;
            return;
        } else {
            System.out.println("fail: pet esta morto");
            return;
        }
    }
    public void play() {  //brincar
        if(testeAlive()){
            this.setEnergy(this.energy -2);
            this.setHungry(this.hungry -1);
            this.setClean(this.clean -3);
            this.diamonds++;
            this.age++;
            return;
        } else {
            System.out.println("fail: pet esta morto");
            return;
        }
    }
    public void shower() {  //banho
        if(! this.testeAlive()){
            System.out.println("fail: pet esta morto");
            return;
        }
        int v = getCleanMax() - getClean();
        if(testeAlive()){
            this.setEnergy(this.energy -3);
            this.setHungry(this.hungry -1);
            this.setClean(this.clean + v);
            this.age += 2;
            return;
        } 
    }
    public void sleep() { //dormir
        if(!testeAlive()){
                System.out.println("fail: pet esta morto");
                return;
        } 
        int d = this.getEnergyMax() - 5;
        int v = this.getEnergyMax() - this.getEnergy();
        if(testeAlive()){
            if(this.getEnergy() <= d){
            this.setEnergy(this.getEnergy() + v);
            this.setHungry(this.hungry -1);
            this.age += v;
            return;
            } 
            else {
                System.out.println("fail: nao esta com sono");
                return;
            }
        }
    }
    
    public int getClean() {
        return this.clean;
    }
    public int getCleanMax() {
        return this.cleanMax;
    }
    public int getEnergy() {
        return this.energy;
    }
    public int getEnergyMax() {
        return energyMax;
    }
    public int getHungry() {
        return hungry;
    }
    public int getHungryMax() {
        return hungryMax;
    }
    public void setClean(int v) {
        if(v <= 0){
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
            return;
        }
            if(v > this.cleanMax) {
            this.clean = this.cleanMax;
            return;
            } else {
            this.clean = v;
            }
    }
    
    public void setHungry(int v) {
        if(v <= 0){
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
            return;
        }
            if(v > this.hungryMax) {
            this.hungry = this.hungryMax;
            return;
        }
        this.hungry = v;
    }
    
    public void setEnergy(int v){
        if(v <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
            return;
        }
        if(v > this.energyMax) {
            this.energy = this.energyMax;
            return;
            } else {
                this.energy = v;
            }
    }
    
}

public class Main1 {
    public static void main(String[] a) {
        Pet pet = new Pet(0, 0, 0);
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                                                           }
            else if (args[0].equals("show"))  { write(pet.toString());                                                           }
            else if (args[0].equals("init"))  { pet = new Pet((int)number(args[1]), (int)number(args[2]), (int)number(args[3])); }
            else if (args[0].equals("play"))  { pet.play();                                                                      }
            else if (args[0].equals("eat"))   { pet.eat();                                                                       }
            else if (args[0].equals("sleep")) { pet.sleep();                                                                     }
            else if (args[0].equals("shower")){ pet.shower();                                                                    }
            else                              { write("fail: comando invalido");                                                 }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}
