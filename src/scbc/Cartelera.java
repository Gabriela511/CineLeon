package scbc;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author richy
 */
public class Cartelera {
    private int numPeli;
    private String cadena;
    private String dia;
    private Pelicula peliculas[];
    private Pelicula peli;
    
    public Cartelera(){
       
        peliculas=new Pelicula[0];
    }
    public Cartelera(String dia, Pelicula peliculas[]){
        this.dia=dia;
        this.peliculas=peliculas;
    }
    public Cartelera(Cartelera cartelera){
        dia=cartelera.dia;
        peliculas=cartelera.peliculas;
    }
    public void destruir(){
        dia=null;
        peliculas=null;
        System.gc();
    }
    
    public void mostrarCartelera(){
        System.out.println("Peliculas Disponibles:");
        for(int n=0;n<peliculas.length;n++){
            peli=peliculas[n];
            System.out.println(peli.getNumPeli()+".- "+peli.getNomPeli()+"\n");
        }
        setPeli();
    }
    public void setPeli(){
        System.out.println("Seleccione el numero de la pelicula:");
        numPeli=Integer.parseInt(setDato());   
        peli=peliculas[numPeli];
        System.out.println(peli);
        peli.asignarHorario();
    }
 
    public void setDia(String dia){
        this.dia=dia;
    }
    public String setDato(){
	DataInputStream sd = new DataInputStream(System.in);				
	System.out.flush();							
	
	try{			
		cadena = sd.readLine();	
	}catch(IOException e){
		System.out.println("ERROR: Se introdujo el dato");
		System.out.println(e);
	}
           return cadena;
    }
    
    public String toString(){
        return "Dia de la cartelera: "+dia;
    }
    
}