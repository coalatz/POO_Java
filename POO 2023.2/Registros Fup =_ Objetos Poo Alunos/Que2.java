import java.util.Scanner;

class Aluno{
    String nome;
    float nota1, nota2, nota3;
    
    void ler(){
        Scanner sc = new Scanner(System.in);
        
        nome = sc.nextLine();
        nota1 = Float.parseFloat(sc.nextLine());
        nota2 = Float.parseFloat(sc.nextLine());
        nota3 = Float.parseFloat(sc.nextLine());
    }
    
    void imprimir(){
        float media = (nota1 + nota2 + nota3)/3;
        System.out.printf("%.2f", media);
    }
    
}

class Que2{
    public static void main(String[] args){
        Aluno a1 = new Aluno();
        a1.ler();
        
        a1.imprimir();
    }
}