// fiz essa atividade fora da universidade para praticar
// envolve agregacao simples, levei umas 3 horas para terminar
// serviu pra entender melhor o conceito de agregacao

import java.util.Random;

class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public Lutador getDesafiado() {
        return this.desafiado;
    }
    public Lutador getDesafiante() {
        return this.desafiante;
    }
    public int getRound() {
        return this.rounds;
    }
    public boolean getAprovada() {
        return this.aprovada;
    }
    public void setDesafiado(Lutador n) {
        this.desafiado = n;
    }
    public void setDesafiante(Lutador n) {
        this.desafiante = n;
    }
    public void setRounds(int n) {
        this.rounds = n;
    }
    public void setAprovada(boolean n) {
        this.aprovada = n;
    }

    public void marcarLuta(Lutador l1, Lutador l2) {
        if(l1.getCategoria().equals(l2.getCategoria())){
            if(l1 != l2){
                this.setAprovada(true);
                System.out.println("+++Desafiante+++");
                System.out.println(">" + l1.getNome() + "<");
                System.out.println("-----------------------");
                this.desafiante = l1;
                System.out.println("###Desafiado###");
                System.out.println(">" + l2.getNome() + "<");
                System.out.println("----------------------");
                System.out.println(" ");
                this.desafiado = l2;
            } else {
                this.setAprovada(false);
                l1 = null;
                l2 = null;
                System.out.println("Mesmo lutador");
            }
        } else {
            this.setAprovada(false);
            l1 = null;
            l2 = null;
            System.out.println("Categoria diferente");
        }
    }
    
    public void lutar() {
        if(this.getAprovada()){
            this.desafiado.apresentador();
            this.desafiante.apresentador();

            Random ale = new Random();
            int vencedor = ale.nextInt(3);
            switch(vencedor) {
                case 0:
                    System.out.println("Empatou");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                    break;
                case 1:
                    System.out.println("Ganhou " + this.desafiado.getNome() + " Desafiado");
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                    break;
                case 2:
                    System.out.println("Ganhou " + this.desafiante.getNome() + " Desafinate");
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                    break;
            }
        }
        else {
            System.out.println("Luta nao pode acontecer");
        }
    }
}

class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;

    Lutador(String n, String na, int i, float a, float p, int v, int d, int e) {
        this.setNome(n);
        this.setNacionalidade(na);
        this. setIdade(i);
        this.setAltura(a);
        this.setPeso(p);
        this.setVitorias(v);
        this.setDerrotas(d);
        this.setEmpates(e);
    }

    public String getNome() {
        return this.nome;
    }
    public String getNacionalidade() {
        return this.nacionalidade;
    }
    public int getIdade() {
        return this.idade;
    }
    public float getAltura() {
        return this.altura;
    }
    public float getPeso() {
        return this.peso;
    }
    public String getCategoria() {
        return this.categoria;
    }
    public int getVitorias() {
        return this.vitorias;
    }
    public int getDerrotas() {
        return this.derrotas;
    }
    public int getEmpates() {
        return this.empates;
    }
    public void setNome(String n) {
        this.nome = n;
    }
    public void setNacionalidade(String n) {
        this.nacionalidade = n;
    }
    public void setIdade(int n) {
        this.idade = n;
    }
    public void setAltura(float n) {
        this.altura = n;
    }
    public void setPeso(float n) {
        this.peso = n;
        this.setCategoria(n);
    }
    public void setCategoria(float n) {
        if(this.peso < 52.2) {
            this.categoria = "Ivalido";
        }
        else if(this.peso <= 70.3f) {
            this.categoria = "Leve";
        }
        else if(this.peso <= 83.9f){
            this.categoria = "Medio";
        }
        else if (this.peso <= 120.2f) {
            this.categoria = "Pesado";
        }
        else {
            this.categoria = "invalido";
        }
    }
    public void setVitorias(int n) {
        this.vitorias = n;
    }
    public void setDerrotas(int n) {
        this.derrotas = n;
    }
    public void setEmpates(int n) {
        this.empates = n;
    }
    
    public void apresentador() {
        System.out.println("**********************");
        System.out.println("Lutador: " + this.getNome());
        System.out.println("Origem: " + this.getNacionalidade());
        System.out.println(this.getIdade() + " anos");
        System.out.println(this.getAltura() + " m de altura");
        System.out.println("Ganhou: " + this.getVitorias());
        System.out.println("Perdeu: " + this.getDerrotas());
        System.out.println("Empatou: " + this.getEmpates());
        System.out.println(" ");
        return;
    }
    public void status() {
        System.out.println(getNome());
        System.out.println("É um peso " + this.getCategoria());
        System.out.println("Ganhou: " + this.getVitorias());
        System.out.println("Perdeu: " + this.getDerrotas());
        System.out.println("Empatou: " + this.getEmpates());
        System.out.println(" ");
    }
    public void ganharLuta() {
        this.setVitorias(this.getVitorias() +1);
    }
    public void perderLuta() {
        this.setDerrotas(this.getDerrotas() +1);
    }
    public void empatarLuta() {
        this.setEmpates(this.getEmpates() +1);
    }
    }

    public class Ufe {
        public static void main(String args[]) {
            Lutador vetL[] = new Lutador[6];
            vetL[0] = new Lutador("Rodrigo Farinon", "Fortaleza", 20, 1.75f, 80.2f, 1, 30, 2); 
            vetL[1] = new Lutador("Coala", "Banabuiu", 21, 1.79f, 100.2f, 34, 3, 2); 
            vetL[2] = new Lutador("Rodrigo caua", "Messejana", 19, 1.76f, 65f, 4, 10, 2); 
            vetL[3] = new Lutador("Caio Cezar", "Quixda", 24, 1.79f, 77.0f, 9, 10, 12); 
            vetL[4] = new Lutador("Danabuiu", "Taua", 19, 1.65f, 63.0f, 12, 7, 4); 
            vetL[5] = new Lutador("Eduardo", "Pindoretama", 20, 1.77f, 73.5f, 5, 5, 5);

            Luta UFE1 = new Luta();
            UFE1.marcarLuta(vetL[2],vetL[4]);
            UFE1.lutar();
    }
}