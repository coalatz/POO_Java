import java.util.Scanner;

class ContaBanco {
    public int numConta;
    protected String tipo; // CC = conta corrente CP = conta poupança
    private String dono;
    private float saldo;
    private boolean status;
    
    ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }
    
    public void abrirConta(String v, String t) {
        this.setDono(v);        //abre conta passando o nome do dono
        this.setTipo(t);        //e o tipo de conta
        this.setStatus(true);
        if(t.equals("CC")) {
            this.setSaldo(50);
        } else {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta");
    }
    public String fecharConta() {
        if(this.saldo == 0) {           //fechar a conta, precisar 
            this.setStatus(false);        //precisa ter o saldo 0
            return "Conta fechada";
        }
        else if(this.saldo < 0) {
            return "Pague seu débito com o banco";
        } 
        else {
            return "Retire seu saldo";
        }
    }
    public String depositar(float r) {
        if(this.status == true){                 //o status precisa ser true 
            this.setSaldo(this.getSaldo() + r);    
            System.out.println("Depósito realizado");
            return "Depósito realizado";
        } 
        else {
            System.out.println("Impossivel sacar");
            return "";
            
        }
    }
    public String sacar(float t) {
        
        if(this.status == true && this.getSaldo() >= t) {
            this.setSaldo(this.getSaldo() - t);
            System.out.println("Saque realizado");
            return "";
        }
        else {
            System.out.println("Impossivel sacar");
            return "";
        }
    }
    public void show() {
        System.out.println("Conta: " + this.getnumConta());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Status: " + this.getStatus());
    }
    
    public int getnumConta() {
        return this.numConta;
    }
    public void setnumConta(int n) {
        this.numConta = n;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String n) {
        this.tipo = n;
    }
    public String getDono() {
        return this.dono;
    }
    public void setDono(String n) {
        this.dono = n;
    }
    public float getSaldo() {
        return this.saldo;
    }
    public void setSaldo(float n) {
        this.saldo = n;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean n) {
        this.status = n;
    }
}

public class Banco {
    public static void main(String[] args) {
        ContaBanco usuario = new ContaBanco(); 
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {
            String line = input(scanner); 
            write("$" + line);
            String[] parts = line.split(" ");

            if (parts[0].equals("end")) {
                break;
            } else if (parts[0].equals("show")) {
                usuario.show(); 
            } else if (parts[0].equals("abrir")) {
                usuario.abrirConta(parts[1], parts[2]);
            } else if (parts[0].equals("depositar")) {
                usuario.depositar(Float.parseFloat(parts[1]));
            } else if (parts[0].equals("sacar")) {
                usuario.sacar(Float.parseFloat(parts[1]));
            } else if (parts[0].equals("fechar")) {
                String result = usuario.fecharConta();
                write(result);
            } else {
                write("fail: comando invalido");
            }
        }
    }

    static String input(Scanner scanner) {
        return scanner.nextLine();
    }

    static void write(String value) {
        System.out.println(value);
    }
}