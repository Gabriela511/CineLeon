package scbc;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Cine {
    private Cartelera cartelera;
    private ReservadorBoleto reserva;
    private Cuenta cuenta;
    private String cadena;
    private int opcion;
    
    
    public void bienvenida(){
        System.out.println("¡Bienvenido a Cine Leon! \n ¡ Escuche el rugido del cine ! Rawr ;)");
        menu();
    }
    
    public void menu(){
        System.out.println("¿Que desea hacer?\n\n\t1. Ver Cartelera \n\t 2.Reservar Boleto\n\t3. Iniciar Sesión \n\t4.Salir");
        opcion=Integer.parseInt(setDato());
        switch(opcion){
            case 1: cartelera.mostrarCartelera();
                    break;
            case 2: reserva.reservar();
                    break;
            case 3: cuenta.entrar();
                break;
            case 4: System.out.println("Tenga buen día");
                break;
            default: System.out.println("ACCESO DENEGADO. ERROR");
                break;
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
