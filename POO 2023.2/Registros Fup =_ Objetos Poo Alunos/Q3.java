//fiz tudo
// com o professor
// essa questao foi a mais desafiadora do primeiro contato, pois nao entendi tanto a logica, de primeira, so depois que fui fazendo outras questoes que fui conseguindo entender melhor
// de 1 dia para o outro 

import java.util.Scanner;
import java.lang.Math;


class Ponto {
    float x, y;
    
    void ler(){
        this.x = Q3.scan.nextFloat();
        this.y = Q3.scan.nextFloat();
    }
    
    float distancia(Ponto p){
        float cH = p.x - this.x;
        float cV = p.y - this.y;
        float dist = (float) Math.sqrt(cH*cH + cV*cV);
        return dist;
    }
}


class Circulo{
    Ponto centro;
    float raio;
    
    void ler(){
        this.centro = new Ponto();
        this.centro.x = Q3.scan.nextFloat();
        this.centro.y = Q3.scan.nextFloat();
        this.raio = Q3.scan.nextFloat();
    }
    
    boolean contem( Ponto p) {
        if ( p.distancia( centro ) <= raio ) {
            return true;
        } else {
            return false;
        }
    }
    
    int quantosDentro ( Ponto pontos[] ){
        int cont = 0;
        for ( Ponto ponto : pontos ) {
            if ( this.contem( ponto )) {
                cont++;
            }
            
        }
       return cont;
    }
}


class Q3 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int n = scan.nextInt();
        
        Ponto vetor[] = new Ponto[n];
        for (int i=0; i<n; i++) {
            vetor[i] = new Ponto();
            vetor[i].ler();
        }
        
        Circulo c = new Circulo();
        c.ler();
        
        System.out.println(c.quantosDentro( vetor ));
    }
}
