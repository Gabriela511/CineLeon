package scbc;

/**
 *
 * @author richy
 */
public class Pelicula {
    private int numPeli;
    private int duracion;
    private String nomPeli;
    private String resumen;
    private Horario horario;
    
    public Pelicula(){
        this(0,0,"","");
    }
    public Pelicula(int numPeli, int duracion, String nomPeli, String resumen){
        this.numPeli=numPeli;
        this.duracion=duracion;
        this.nomPeli=nomPeli;
        this.resumen=resumen;
    }
    public Pelicula(Pelicula pelicula){
        pelicula.nomPeli=nomPeli;
        pelicula.duracion=duracion;
        pelicula.nomPeli=nomPeli;
        pelicula.resumen=resumen;
    }
    public void destruir(){
        nomPeli=null;
        resumen=null;
        System.gc();
    }
    
    public void asignarHorario(){
        horario.asignarHora(duracion);
        horario.comprobarDisponibilidad();
    }
    public int getNumPeli(){
        return numPeli;
    }
    public String getNomPeli(){
        return nomPeli;
    }
}
