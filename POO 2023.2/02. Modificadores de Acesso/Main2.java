//passou em tudo
// fiz so 
// tive dificuldade de implementar a funçao next pois
// estava usadando get e set, so que la tinham os limitadores
// entao quando chegava a 60 dava erro, e passei um tmepo nisso
// ate perceber que tinha que ser as variaveis direto
// 3 horas

import java.util.Scanner;

class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    
    Time(int h, int m, int s) {
        this.setHour(h);
        this.setMinute(m);
        this.setSecond(s);
    }
    
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    public void nextSecond() {
        if(this.second >= 0 && this.second < 60) {
            this.second  += 1;
        }
        if(this.second == 60){
            this.second = 0;
            this.minute += 1;
        }
        if(this.minute == 60) {
            this.minute = 0;
            this.hour += 1;
        }
        if(this.hour == 24) {
            this.hour = 0;
        }
        
    }
    
    
    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getSecond() {
        return this.second;
    }
    public void setHour(int v) {
        if (v >= 0 && v <= 23) {
            this.hour = v;
       } 
        else {
          // this.hour=0;
            System.out.println("fail: hora invalida");
        }
    }

    public void setMinute(int v) {
        if (v >= 0 && v <= 59) {
            this.minute = v;
        } 
        else {
           // this.minute =0;
            System.out.println("fail: minuto invalido");
        }
    }
    
    public void setSecond(int v) {
        if (v >= 0 && v <= 59) {
            this.second = v;
        } 
        else {
          //  this.second=0;
            System.out.println("fail: segundo invalido");
        }
    }

    
    
}

public class Main2 {
    public static void main(String[] a) {
        Time time = new Time(0, 0, 0);
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            
            if (args[0].equals("show"))  { 
                write("" + time); 
            }
            else if (args[0].equals("init")) {
                time = new Time((int)number(args[1]), (int)number(args[2]), (int)number(args[3]));
            }
            else if (args[0].equals("set")) {
                time.setHour((int)number(args[1]));
                time.setMinute((int)number(args[2]));
                time.setSecond((int)number(args[3]));
            }
            else if (args[0].equals("end"))   { 
                break; 
            } else if(args[0].equals("next")) 
                time.nextSecond();
            else { 
                write("fail: comando invalido"); 
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}
