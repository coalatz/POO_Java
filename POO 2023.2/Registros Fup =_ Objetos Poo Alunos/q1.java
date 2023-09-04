import java.util.Scanner;
class Aluno {
    String nome;
    int matr;
    String disc;
    float nota;
    
    void ler(){
        Scanner sc = new Scanner(System.in);
        
        nome = sc.nextLine();
        matr = Integer.parseInt(sc.nextLine());
        disc = sc.nextLine();
        nota =  Float.parseFloat(sc.nextLine());
    }    
    
    void imprimir(){
        System.out.println("Nome = " + nome);
        System.out.println("Matrícula = " + matr);
        System.out.println("Disciplina = " + disc);
        System.out.println("Nota = " + nota);
    }
}

class q1{
    public static void main(String[] args){
        Aluno a1 = new Aluno();
        
        a1.ler();
        
        a1.imprimir();
        
    }
}