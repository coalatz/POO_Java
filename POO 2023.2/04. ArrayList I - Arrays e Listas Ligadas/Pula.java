// fiz uma parte da questao em sala, o kid remove, o resto fiz sozinho.
// montei o esqueleto do codigo todo em sala, e preenchi as funcoes em casa.
// passou em todas, demorei cerca de 3 horas ao todo.

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

class Kid {
    private int age;
    private String name;
    
    public Kid(String n, int i) {
        this.setName(n);
        this.setAge(i);
    }
     public String toString() {
        return name + ":" + age;
    }
    
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public void setAge(int n) {
        this.age = n;
    } 
    public void setName(String n) {
        this.name = n;
    }
    
}

class Trampoline {
    private LinkedList<Kid> playing;
    private LinkedList<Kid> waiting;
    
    private Kid remove(String n, LinkedList<Kid> l) {
        Kid criancar = null;
        for (Kid crianca : l) {
            if(n.equals(crianca.getName())){
                criancar = crianca;
                break;
            }
        }
            if(criancar != null) {
                l.remove(criancar);
                return criancar;
            }
        return null; 
        }
    
    public Trampoline() {
        this.playing = new LinkedList<Kid>();
        this.waiting = new LinkedList<Kid>();
    }
    
    public String toString() {
        return   "[" + waiting.stream().map(Kid::toString).collect(Collectors.joining(", ")) + "]" + " => "
               + "[" + playing.stream().map(Kid::toString).collect(Collectors.joining(", ")) + "]";
    }
    public void arrive(Kid l) {
        if( l != null ) {
            this.waiting.add(0,l);
            
        }
    }
    
    public void enter(){
    int primeiro = this.waiting.size() - 1; 
    
    if (primeiro >= 0) {
        Kid crianca = this.waiting.remove(primeiro); 
        this.playing.add(0,crianca);
            
        } 
    }
    public void leave() {
        int primeirop = this.playing.size() - 1;
        if(primeirop >= 0) {
        Kid removerp = this.playing.remove(primeirop);
        this.waiting.add(0,removerp);

        }
    }
    public Kid removeKid(String l) {
        for(Kid crianca : this.waiting) {
            if(crianca.getName().equals(l)){
                this.waiting.remove(crianca);
            }
            for(Kid crianca2 : this.playing){
                if(crianca2.getName().equals(l)){
                    this.playing.remove(crianca2);
                }
            }
        }
        return null;        
    }
}
    
class Pula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trampoline tramp = new Trampoline();
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$"+ line);
            String[] ui = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("arrive")) { // name age
                tramp.arrive(new Kid(ui[1], Integer.parseInt(ui[2]))) ;
            } else if(ui[0].equals("enter")) {
                tramp.enter();
            } else if(ui[0].equals("leave")) {
                tramp.leave();
            } else if(ui[0].equals("remove")) {//name
                tramp.removeKid(ui[1]);
            }
            else if(ui[0].equals("show")) {
                System.out.println(tramp);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
    
