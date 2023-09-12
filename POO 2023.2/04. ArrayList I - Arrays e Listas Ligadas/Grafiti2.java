// fiz ativdade em sala, professor foi fazendo e eu fui acompanhando, apresnetou
// arraylist, tive um pouco de dificuldade por ser o primeirp contato, mas consi-
// guir assimilar ate que bem, atividade passou em tudo.

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

class Lead {
    private float thickness;
    private String hardness;
    private int size;
    
    public Lead(float t, String h, int s) {
        this.thickness = t;
        this.hardness = h;
        this.size = s;
    }
    
    public void usagePerSheet() {
        if(this.getHardness().equals("HB")) {
            this.setSize(this.getSize() -1);
            return;
        }
        if(this.getHardness().equals("2B")) {
            this.setSize(this.getSize() -2);
            return;
        }
        if(this.getHardness().equals("4B")) {
            this.setSize(this.getSize() -4);
            return;
        }
        if(this.getHardness().equals("6B")) {
            this.setSize(this.getSize() -6);
            return;
        }
    }

    
    public String getHardness() {
        return this.hardness;
    }
    public int getSize() {
        return this.size;
    }
    public float getThickness() {
        return this.thickness;
    }
    
    public void setSize(int s) {
        this.size = s;
    }
      public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + hardness + ":" + size;
    }
   
}



class Pencil {
    private float thickness;
    private Lead tip = null;
    private ArrayList<Lead> barrel;
    
    public Pencil(float v) {
        this.thickness = v;
        this.barrel = new ArrayList<Lead>();
    }
    public boolean hasGrafite() {
        if(this.tip != null) {
            System.out.println("fail: ja existe grafite no bico");
            return true;
        } else {
            return false;
        }
    }
    public boolean insert(Lead v) {
        if(v.getThickness() != this.thickness) {
            System.out.println("fail: calibre incompatível");
                return false;
        }
        this.barrel.add( v );
        return true;
        
            
        }
         public boolean Pull() {
        if ( hasGrafite() ) {
            return false;
        }
        
        Lead removido = this.barrel.remove(0);
        this.tip = removido;
        return true;
    }
            

    public Lead remove() {
        Lead v1; 
        if(this.tip == null ){
            System.out.println("fail: nao existe grafite");
            return null;
        }
        if(this.tip != null) {
             v1 = this.tip;
            this.tip = null;
            return v1;
        } else {
            return null;
        }
    }
    
    public void writePage() {
        int v2;
        if(this.tip == null){
            System.out.println("fail: nao existe grafite no bico");
            return;

        }
        if(this.tip.getSize() <= 10){
            System.out.println("fail: tamanho insuficiente");
            return;
        }
        if(this.tip.getSize() > 10){
            this.tip.usagePerSheet();
                if(this.tip.getSize() < 10) {
                    this.tip.setSize(10);
                    System.out.println("fail: folha incompleta");
                    return;
        }
        }
        
    }
    
    
    public String toString() {
        String saida = "calibre: " + thickness + ", bico: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "[]";
            
        saida += ", tambor: {";
        
        for(Lead elem : this.barrel){
            saida += "[" + elem + "]";
        }
        
        saida += "}";
        return saida;
    
    
    
}
}
public class Grafiti2 {
    public static void main(String[] args) {
        Pencil pencil = new Pencil(0.5f);

        while (true) {
            String line = input();
            String[] argsL = line.split(" ");
            write('$' + line);

            if      ("end".equals(argsL[0])   ) { break;                                                                    }
            else if ("init".equals(argsL[0])  ) { pencil = new Pencil(number(argsL[1]));                                       }
            else if ("insert".equals(argsL[0])) { pencil.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3]))); }
            else if ("remove".equals(argsL[0])) { pencil.remove();                                                             }
            else if ("pull".equals(argsL[0]))   { pencil.Pull();                                                             }
            else if ("write".equals(argsL[0]) ) { pencil.writePage();                                                          }                         
            else if ("write".equals(argsL[0]) ) { pencil.writePage();                                                          }                                                      
            else if ("show".equals(argsL[0])  ) { write(pencil.toString());                                                               }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static float number(String str) { return Float.parseFloat(str); }
}

