
package scbc;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Gabriela Alejandra Perez Arteaga 
 */
public class RegistradorUsuario {
    
    private String cadena;
    private String nombre;
    private String correo;
    private String usuario;
    private String contrasenia;
    private String contraseniaconf;
    private int decision;
    private Cuenta c;
    
    public RegistradorUsuario(){
        this(" ", " ", " ", " ", " "," ", 0);
        c = new Cuenta();
    }
    
    public RegistradorUsuario(String cadena, String nombre, String correo, String usuario, String contrasenia, String contraseniaconf, int decision){
        this.cadena=cadena;
        this.nombre=nombre;
        this.correo=correo;
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.contraseniaconf=contraseniaconf;
        this.decision=decision;
    }
    
    public RegistradorUsuario(RegistradorUsuario ru){
        cadena=ru.cadena;
        nombre=ru.nombre;
        correo=ru.correo;
        usuario=ru.usuario;
        contrasenia=ru.contrasenia;
        contraseniaconf=ru.contraseniaconf;
        decision=ru.decision;
    }
    
    public void destruir(){
        usuario = null;
        cadena = null;
        nombre=null;
        correo=null;
        contrasenia=null;
        contraseniaconf=null;
        System.gc();
    }
    
    public void registrar(String pelicula, String horario, int boletoadulto,int boletoninio,int importe){
        System.out.println("¿Usted tiene cuenta? ( 1 = SI / 2 = NO)");
        decision = Integer.parseInt(setDato());
        if(decision == 1){
            
            c.entrar();
        }else{
            
            
            System.out.println("Necesita una cuenta para poder proseguir con su compra. Favor de registrarse");
            System.out.println(" Nombre ");
            nombre=setDato();
            System.out.println(" Correo ");
            correo=setDato();
            System.out.println("Nombre de Usuario");
            usuario=setDato();
            System.out.println("Contraseña");
            contrasenia=setDato();
            System.out.println("Repetir Contraseña");
            contraseniaconf=setDato();
            if(contrasenia.equals(contraseniaconf)){
                c.nuevo(usuario, contrasenia, nombre, correo);
            }else{
                System.out.println("Las contraseñas no coinciden");
                System.out.println("Contraseña");
                contrasenia=setDato();
                System.out.println("Repetir Contraseña");
                contraseniaconf=setDato();
            }
            
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

    public String toString(){
        return "Usuario \t"+usuario+"\nNombre:\t"+nombre+"\nCorreo: \t"+correo+"\n";
    }

}
