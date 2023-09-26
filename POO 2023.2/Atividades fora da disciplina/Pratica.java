class Pessoa {
    private String nome;
    private int idade;
    private String sexo;

    public Pessoa(String nome, int i, String s) {
        this.setNome(nome);
        this.setIdade(i);
        this.setSexo(s);
    }

    public void fazerAniver() {
        this.idade++;
    }

    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public String getSexo() {
        return this.sexo;
    }
    public void setNome(String n) {
        this.nome = n;
    }
    public void setIdade(int i) {
        this.idade = i;
    }
    public void setSexo(String s) {
        this.sexo = s;
    }
}

class Livro {
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private Pessoa leitor;
    private boolean aberto;

    public Livro(String t, String a, int t2, Pessoa l){
        this.setTitulo(t);
        this.setAutor(a);
        this.setTotPaginas(t2);
        this.setLeitor(l);
    }

    public String detalhes() {  //fazer ainda
        return "Titulo:" + this.titulo + ", " +
                            " Autor:" + this.autor + ", " +
                            "\nTotal de Paginas:" + this.totPaginas + ", " +
                            " Aberto:" + this.aberto + ", " +
                            " Pagina Atual:" + this.pagAtual + ", " +
                            " \nleitor:" + this.leitor.getNome() + ", " +
                            " idade:" + this.leitor.getIdade() + ", " +
                            " Genero:" + this.leitor.getSexo();
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    public int getTotPaginas() {
        return this.totPaginas;
    }
    public int getPagAtual() {
        return this.pagAtual;
    }
    public Pessoa getLeitor() {
        return this.leitor;
    }
    public boolean getAberto() {
        return aberto;
    }
    public void setTitulo(String n) {
        this.titulo = n;
    }
    public void setAutor(String i) {
        this.autor = i;
    }
    public void setTotPaginas(int s) {
        this.totPaginas = s;
    }
    public void setPagAtual(int p) {
        this.pagAtual = p;
    }    
    public void setLeitor(Pessoa l) {
        this.leitor = l;
    }
    public void setAberto(boolean a) {
        this.aberto = a;
    }
    
    public void abrir() {
        this.aberto = true;
    }
    public void fechar() {
        this.aberto = false;
    }
    public void folhear(int p) {
        if(p <= this.getTotPaginas()) {
            this.setPagAtual(p);
        } else {
            this.setPagAtual(0);
        }
    }
    public void avançarPag() {
        this.setPagAtual(getPagAtual() +1);
    }
    public void voltarPag() {
        this.setPagAtual(getPagAtual() -1);
    }

}

public class Pratica {
    public static void main(String[] args) {
        Pessoa[] p = new Pessoa[3];
        Livro[] l = new Livro[3];

        p[0] = new Pessoa("carlos", 21, "masculino");
        p[1] = new Pessoa("caio", 39, "nao binario");
        p[2] = new Pessoa("rodrigo", 12, "masculino");

        l[0] = new Livro("Prova POO", "Rubens", 1000, p[0]);
        l[1] = new Livro("Prova POO Mais Uma vez", "Alisson", 3000, p[1]);
        l[2] = new Livro("Prova POO passamos", "Rubens", 1000,  p[0]);

        l[1].abrir();
        l[1].folhear(500);
        System.out.println(l[1].detalhes());
    }
}