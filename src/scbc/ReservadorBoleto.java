
package scbc;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Gabriela Alejandra Pérez Artea
 */
public class ReservadorBoleto{
    
    
    private String pelicula;
    private String horario;
    private String cadena;
    private int importe;
    private int boletoadulto;
    private int boletoninio;
    private int decision;
    
    private Sala sala1;
    private Cine cine1;
    private RegistradorUsuario usuario;
    
    public ReservadorBoleto(){
        this(" ", " ", " ", 0, 0, 0, 0);
        sala1 = new Sala(0,0,0);
        cine1 = new Cine();
        usuario = new RegistradorUsuario();
    }
    
    public ReservadorBoleto(String pelicula, String horario, String cadena, int importe, int boletoadulto, int boletoninio, int decision){
        this.pelicula = pelicula;
        this.horario = horario;
        this.cadena = cadena;
        this.importe = importe;
        this.boletoadulto = boletoadulto;
        this.boletoninio = boletoninio;
        this.decision = decision;
    }
    
    public ReservadorBoleto(ReservadorBoleto rb){
        pelicula = rb.pelicula;
        horario = rb.horario;
        cadena = rb.cadena;
        importe = rb.importe;
        boletoadulto = rb.boletoadulto;
        boletoninio = rb.boletoninio;
    }
    
    public void destruir(){
        usuario = null;
        sala1 = null;
        pelicula = null;
        horario = null;
        cadena = null;
        System.gc();
    }
    
    /* Reserva boletos */
    public void reservar(){
        int nboletos;
        
        System.out.println(" Ingrese pelicula ");
        pelicula = setDato();   
        System.out.println(" Ingrese horario ");
        horario = setDato();
        
        System.out.println(" ¿Cuantos boletos para adulto? (Precio $60.00 mx)");
            boletoadulto = Integer.parseInt(setDato());
            importe = boletoadulto * 60;
            nboletos = boletoadulto;
            System.out.println(" ¿Requiere boletos para niño? (1 = SI / 2 = NO)");
            decision = Integer.parseInt(setDato());
        
            if(decision==1){
                System.out.println(" ¿Cuantos boletos para niño? (Precio $45.00 mx)");
                boletoninio = Integer.parseInt(setDato());
                nboletos = boletoadulto + boletoninio;
                importe = importe + (boletoninio * 45);
            }
            
        if(sala1.disponibilidad()){
            System.out.println(" Asientos disponibles :");
            System.out.println(" -- RESUMEN -- \n Película : "+pelicula+"\n Horario : "+horario+"\nNumero de Boletos : "+nboletos+"\n\t Boletos  adulto :: "+boletoadulto+"\n\t Boletos niño :: "+boletoninio+"\n\t\t Importe total : "+importe);        
            System.out.println("¿Desea continuar con su compra? (1 = SI / 2 = NO)");
            decision = Integer.parseInt(setDato());
            
            if(decision == 1){  /* Inicia sesión */
                usuario.registrar(pelicula, horario,boletoadulto, boletoninio, importe);
            }else{
                cine1.bienvenida();
            }
            
        }else{
            System.out.println(" Lo sentimos, asientos  N O  disponibles. ");
        
        }
        cine1.bienvenida();
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
