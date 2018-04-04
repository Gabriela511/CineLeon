package scbc;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author richy
 */

public class Horario {
    private int hora;
    private Sala salas[];
    private ArrayList horario;
    private String cadena;
    private Sala sala;
    
    public Horario(){
        
    }
    public Horario(int hora, Sala sala){
        this.hora=hora;
        
    }
    public Horario(Horario horario){
        horario.hora=hora;
        horario.sala=sala;
    }
    public void destruir(){
        sala=null;
        System.gc();
    }
    
    public void asignarHora(int duracion){
        System.out.println("Horario de proyeccion:");
        int n=0;
        while(hora<23){
            horario.add(hora);
            System.out.println((n+1)+".- "+hora+" hrs.");
            hora+=duracion;
            n++;
        }
        salas = new Sala[horario.size()];
        
    }
    public void comprobarDisponibilidad(){
        System.out.println("Seleccione el numero de la hora:");
        int n = Integer.parseInt(setDato());
        sala=salas[n];
        if(sala.disponibilidad()){
            setAsiento(sala);
        }
        else{
            System.out.println("Funcion llena.");
        }
    }
    public void setAsiento(Sala sala){
        System.out.println("¿Cuantos asientos reservara?:");
        int nb = Integer.parseInt(setDato());
        sala.disponibilidadAsientos();
        while(nb>0){
            System.out.println("Introduca el numero de el asiento:");
            int na = Integer.parseInt(setDato());
            sala.setAsiento(na);
            
        }
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
    
}
