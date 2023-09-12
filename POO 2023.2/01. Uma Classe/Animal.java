//fiz sozinho, mas peguei a main disponibilizada, passou em tudo
// fiz sozinho
// foi uma atividade que demorei um pouco, por ser uma das partes que vai ficando dificil, mas conseguir fazer bem
// 4 horas

import java.util.Scanner;

class Animal {
    public String especie;
    public String barulho;
    public int idade;
    
    Animal(String e, String b) {
        this.especie = e;
        this.barulho = b;
        idade = 0;
    }
    String fazerBarulho() {
        if(this.idade == 0){
            return "---";
        }else if(this.idade > 0 && this.idade < 4){
            return this.barulho;
        }else {
            return "RIP";
        }
        
    }
    void envelhecer(int i) {
        this.idade += i;
        if(this.idade > 3) {
            System.out.println("warning: " + this.especie + " morreu");
            this.idade = 4;
        }
    }
    void show() {
        System.out.println(this.especie + ":" + this.idade + ":" + this.barulho);
    }

}

class Animal {
     public static void main(String[] _args) {
        Animal v1 = new Animal("","");
        
        while (true) {
        var line = input();         //lê a linha
        var args = line.split(" "); // quebra em array de palavras
        write("$" + line);          //mostra '$' na frente

        if (args[0].equals("init")) {
             v1 = new Animal(args[1],args[2]);
            //aqui voce repassa os parametros para o objeto
            //convertendo os que precisam ser números ou inteiros
        }
        else if (args[0].equals("show")) {
            v1.show();
        }
        else if (args[0].equals("grow")) {
            v1.envelhecer((int) number(args[1]));
        }
        else if (args[0].equals("noise")) {
            write(v1.fazerBarulho());
        }
        else if (args[0].equals("end")) {
            break;
        }
        else {
            write("fail: comando invalido");
        }
    }
}
    static Scanner scanner = new Scanner(System.in);
    static String  input()              { return scanner.nextLine(); }
    static double  number(String value) { return Double.parseDouble(value); }
    static void    write(String value)  { System.out.println(value); }
    
}
