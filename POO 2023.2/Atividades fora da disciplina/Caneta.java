class V1 {
    public String modelo;
    private float ponta;
    
    V1(String m, float p) {
        this.modelo = m;
        this.ponta = p;
    }

    public String getmodelo() {
        return this.modelo;
    }
    public void setmodelo(String m) {
        this.modelo = m;
    }
    public float getponta() {
        return this.ponta;
    }
    public void setponta(float p) {
        this.ponta = p;
    }
    void status () {
        System.out.println("Modelo: " + this.getmodelo());
        System.out.println("Ponta: " + this.getponta()); 
    }
}

class Caneta{
    public static void main (String[] args) {
        V1 o1 = new V1("bic", 4.5f);
       o1.status();
    }
} 



/*class V1 {
   public String modelo;
   public String cor;
   private float ponta;
   protected int carga;
   protected boolean tampada;

    void status () {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta: " + this.ponta); 
        System.out.println("Carga: " + this.carga);
        System.out.println("Esta tampada? " + this.tampada); 
    }

   public void rabiscar () {
        if(this.tampada == true){
            System.out.println("Precisa destampar");
        } else {
            System.out.println("Rabisca papai");
        }
    }
    
   protected void tampar () {
        this.tampada = true;
    }

  protected void destampar () {
        this.tampada = false;
    }
}
 class Caneta{
    public static void main (String[] args) {
        V1 o1 = new V1();
        o1.carga = 90;
        o1.status();
       
    }
} */