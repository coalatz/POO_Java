//fiz parcial
//fiz em sala com o profssor
//primeira vez que a main foi usada e fiquei um pouco perdido no inicio, mas fui entendedo
// 1 hora

import java.util.Scanner;

class Carro {
    int pass; // quantidade de passageiros
    int passmax; // o maximo de passgeiros
    int gas; // combustivel atual do carro 
    int gasmax; // max de combustivel que suporta 
    int km; // km atual do carro 
    
    Carro() {
        this.passmax = 2;
        this.gasmax = 100;
    }
    
    void enter() {
        if(this.pass < this.passmax){
        this.pass++;
        } else {
            System.out.println("fail: limite de pessoas atingido");
        }
        
    }
    void leave() {
        if(pass > 0) {
            this.pass--;
        } else {
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
    void fuel( int comb) {
        this.gas += comb;
        if ( this.gas > this.gasmax ) {
            this.gas = this.gasmax;
        }
    }
    void drive( int km) {
        if(this.pass <= 0 ){
            System.out.println("fail: nao ha ninguem no carro");
        } else if( this.gas == 0 ) {
            System.out.println("fail: tanque vazio");
        } else if(this.gas < km) {
            System.out.println("fail: tanque vazio apos andar" + " " + this.gas + " km");
            this.km += this.gas;
            this.gas =0;
        } else {
            this.km += km;
            this.gas -= km;
        }
    }
    void show() {
        System.out.println(
            "pass: " + this.pass + ", " + 
            "gas: " + this.gas + ", " +
            "km: " + this.km);
    }
}

public class Main {
    public static void main(String[] a) {
        Carro car = new Carro();
        
        while (true) {
            String line = input();
            write("$" + line);
            String[] args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                }
            else if (args[0].equals("show"))  { car.show();                           }
            else if (args[0].equals("enter")) { car.enter();                          }
            else if (args[0].equals("leave")) { car.leave();                          }
            else if (args[0].equals("drive")) { car.drive((int) number(args[1]));     }
            else if (args[0].equals("fuel"))  { car.fuel((int) number(args[1]));      }
            else                              { write("fail: comando invalido");}
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static String  input()              { return scanner.nextLine(); }
    static double  number(String value) { return Double.parseDouble(value); }
    static void    write(String value)  { System.out.println(value); }
}
