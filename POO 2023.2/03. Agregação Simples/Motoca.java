// comecei a fazer a questao na sala, professor me ajudou na logica de uma 
// funçao, e de funçoes que tavam retorando errado, fiquei 1 hora e 20 na sala
// mais 1 hora em casa, tive dificuldades, na main pois antes era intregue 
// pronta e tambem nas saidas, mas aos poucos fui entendendo, fiz a questao
// e depois fui concertando os erros.

import java.util.*;

class Person {
    private int age;
    private String name;
    
    public Person(String n, int a) {
        this.name = n;
        this.age = a;
    }
    
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public String toString() {
        String saida;
        
            return saida = "(" + this.getName() + ":" + this.getAge() + ")";
    }
    
}

class Motorcycle {
    private Person person = null;
    private int power = 1;
    private int time;
    
    public Motorcycle(int p) {
        this.power = p;
    }
    
    public boolean enter(Person p) {
        if(this.person == null) {
            this.person = p;
            this.person = p;
            return true;
        }
        System.out.println("fail: busy motorcycle");
        return false;
    }
    
    public Person leave() {
        Person v1 = this.person;
        if(v1 != null){
            this.person = null;
            return v1;
        }
        System.out.println("fail: empty motorcycle");
        return null;
    }
    
    public void buyTime(int t) {
        this.time += t;
    }
    
    public void drive(int t) {
        int tempAndo = 0;

        if(this.getTime() == 0){
            System.out.println("fail: buy time first");
            return;
        }
        else if(this.person == null){
            System.out.println("fail: empty motorcycle");
            return;
        }
        if(this.person.getAge() > 10) {
            System.out.println("fail: too old to drive");
            return;
        }
        if(this.person.getAge() <= 10 && this.getTime() > 0) {
            tempAndo = this.getTime();
            this.time -= t;
            if(this.getTime() <= 0) {
                this.time = 0;
                System.out.println("fail: time finished after " + tempAndo + " minutes");
                return;
            }
        }
        return;
    } 
    public String honk() {
        String buzina = "";
        for(int i = 0; i<this.getPower(); i++){
            buzina += "e";
        }
        System.out.println("P" + buzina + "m");
        String bu = buzina;
        return bu;
    }
    
    public Person getPerson() {
        return this.person;
    }
    public int getPower() {
        return this.power;
    }
    public int getTime() {
        return this.time;
    }
    
    
    public String toString(){
        if(this.person != null){
            String saidap = "power:" + this.getPower() + ", " + "time:"  + this.getTime() + ", "
                            + "person:" + this.person;
            return saidap;
        }
        
        return  "power:" + this.getPower() + ", " + "time:" + this.getTime() + ", "
                 + "person:"  + "(empty)";
    }
    
}
class Motoca{
    static Motorcycle motoca = new Motorcycle(1);
    public static void main(String[] args) {    
        while(true) {
            String line = input();
            args = line.split(" ");
            write('$' + line);

            if      (args[0].equals("show"))     { System.out.println(motoca);                         }
            else if (args[0].equals("init"))     { motoca = new Motorcycle(number(args[1]));           }  
            else if (args[0].equals("enter"))    { motoca.enter(new Person(args[1], number(args[2]))); }
            else if (args[0].equals("buy"))      { motoca.buyTime(number(args[1])); }
            else if (args[0].equals("drive"))    { motoca.drive(number(args[1])); }
            else if (args[0].equals("honk"))     { motoca.honk(); }
            else if (args[0].equals("end"))      { break;                                              }
            else if (args[0].equals("leave"))    {
                Person person = motoca.leave();
                if(person != null) {
                    System.out.println(person.getName() + ":" + person.getAge());
                }
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static int number(String str)   { return Integer.parseInt(str); }
}