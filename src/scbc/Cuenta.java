/*
 * Clase encargada de conectarse con la Base de datos (cuentas)
 */
package scbc;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Gabii
 */
public class Cuenta {
    
    private String usuario;
    private String contrasenia;
    private String cadena;
    
    public void entrar(){          //Iniciar sesion
        System.out.println(" Ingrese su usuario ");
            usuario = setDato();
            System.out.println(" Ingrese su contraseña ");
            contrasenia = setDato();
            /*Conectar a la base de datos*/
        System.out.println("Bienvenido "+usuario);
        
    }
    
    public void nuevo(String usuario, String contrasenia, String nombre, String correo){            //crea usuario nuevo 
        /*crear en base de datos*/
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
