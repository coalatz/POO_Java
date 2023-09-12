// fiz parcial e passou em todos os testes
// fiz na sala com o professor
//aprendi muito no geral, pois foi meu primeiro contato, o que e um objeto, como chamar, a parte do scanner, que e bem diferente de c para ler as informaçoes
// foi feita durante a aula 

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
