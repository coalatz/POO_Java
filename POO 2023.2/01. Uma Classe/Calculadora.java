//fiz parcial 
//fiz com um amigo fora da disciplina
//tive uma certa dificiculdade com a main pois ainda nao tava entendendo muito bem
// e tava dando alguns erros e pedir ajuda, mas de resto fiz so.
// 2 horas

import java.util.Scanner;

class Calculator {
    public int batteryMax;
    public int battery;
    public float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0.0f;
    }

    public void chargeBattery() {
        chargeBattery(1);
    }

    public void chargeBattery(int value) {
        if (value < 0)
            return;
        this.battery += value;
        if (this.battery > this.batteryMax)
            this.battery = this.batteryMax;
    }

    public boolean useBattery() {
        if (this.battery == 0) {
            System.out.println("fail: bateria insuficiente");
            return false;
        }
        this.battery -= 1;
        return true;
    }

    public void sum(int a, int b) {
        if (useBattery())
            this.display = a + b;
    }

    public void division(int num, int den) {
        if (!useBattery())
            return;
        if (den == 0) {
            System.out.println("fail: divisao por zero");
        } else
            this.display = (float) num / den;
    }

    public void show() {
    System.out.println(
        String.format("display = %.2f, battery = %d", this.display, this.battery));
}

}

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = null;

        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] parts = line.split(" ");

            if (parts[0].equals("end")) {
                break;
            } else if (parts[0].equals("init")) {
                calculator = new Calculator(Integer.parseInt(parts[1]));
            } else if (calculator != null) {
                if (parts[0].equals("show")) {
                    calculator.show();
                } else if (parts[0].equals("charge")) {
                    if (parts.length == 1) {
                        calculator.chargeBattery();
                    } else {
                        calculator.chargeBattery(Integer.parseInt(parts[1]));
                    }
                } else if (parts[0].equals("sum")) {
                    calculator.sum(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                } else if (parts[0].equals("div")) {
                    calculator.division(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                } else {
                    System.out.println("fail: comando invalido");
                }
            } else {
                System.out.println("fail: inicializacao necessaria");
            }
        }
    }
}
