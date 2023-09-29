// essa foi a ativdade que mais tive trablho pois faltei a explicaçao e pela descri
// cao nao conseguir entender bem. peguei o metodo procurar do professor e o inicio
// do cancelar, levei quase 3 horas, os codigos nao estao testados no moodle porque 
// estava fora do ar.

import java.util.*;

class Client {
    private String id;
    private String fone;
    public Client(String id, String fone) {
        this.id = id;
        this.fone = fone;
    }

    public String toString() {
        return id + ":" + fone;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}


class Sala{
    private ArrayList<Client> cadeiras;


    public Sala(int capacidade) {
        cadeiras = new ArrayList<Client>();
        for (int i=0; i<capacidade; i++) {
            this.cadeiras.add(null);
        }
    }
    
   private int procurar( String nome ) {
        // for (Client cliente : this.cadeiras) {
        for (int i=0; i<this.cadeiras.size(); i++) {
            Client cliente = this.cadeiras.get(i);
            if ( cliente != null ) {
                if ( cliente.getId().equals(nome) ) { //se o nome de um dos clientes for igual ao nome procurado
                    return i;
                }
            }
            // if ( cliente != null && cliente.getId().equals(nome) ) { //se o nome de um dos clientes for igual ao nome procurado
            //     return i;
            // }
        }
        return -1;
    }
    private boolean verificarIndice(int i) {
        int ind = this.cadeiras.size() -1;
        if(i > ind) {
            return false;
        }
        return true;
    }
    
    public boolean reservar(String id, String fone, int ind) {
        
        if(verificarIndice(ind)) {
                if(this.cadeiras.get(ind) == null) {
                    if(procurar(id) == -1) {
                        Client novClien = new Client(id,fone);
                        this.cadeiras.remove(ind);
                        this.cadeiras.add(ind,novClien);
                        return true;
                    }
                    System.out.println("fail: cliente ja esta no cinema");
                    return false;
                }
                System.out.println("fail: cadeira ja esta ocupada");
                return false; 
            }
        System.out.println("fail: cadeira nao existe");
        return false;
    }

    public void cancelar(String id) {
        int ind = procurar(id);
        if (ind == -1) {
            System.out.println("fail: cliente nao esta no cinema");
        } else {
            this.cadeiras.set(ind, null);
        }
    }
    
    

    public String toString() {
        String saida = "[";
        for (Client cliente : cadeiras) {
            if(cliente == null)
                saida += "- ";
            else
                saida += cliente + " ";
        }
        return saida.trim() + "]";
    }

}
    //public ArrayList<Client> getCadeiras() {
    //}


class Cinema {
    static Shell sh = new Shell();
    static Sala sala = new Sala(0);

    public static void main(String args[]) {
        sh.chain.put("init",     () -> { sala = new Sala(getInt(1));});
        sh.chain.put("show",     () -> { System.out.println(sala);});
        sh.chain.put("reservar", () -> { sala.reservar(getStr(1), getStr(2), getInt(3));});
        sh.chain.put("cancelar", () -> { sala.cancelar(getStr(1));});

        sh.execute();
    }

    static int getInt(int pos) {
        return Integer.parseInt(sh.param.get(pos));
    }
    static String getStr(int pos) {
        return sh.param.get(pos);
    }
}

class Shell {    
    public Scanner scanner = new Scanner(System.in);
    public HashMap<String, Runnable> chain = new HashMap<>();
    public ArrayList<String> param = new ArrayList<>();
    public Shell() {
        Locale.setDefault(new Locale("en", "US"));
    }
    public void execute() {
        while(true) {
            param.clear();
            String line = scanner.nextLine();
            Collections.addAll(param, line.split(" "));
            System.out.println("$" + line);
            if(param.get(0).equals("end")) {
                break;
            } else if (chain.containsKey(param.get(0))) {
                chain.get(param.get(0)).run();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}