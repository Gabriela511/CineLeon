package scbc;

/**
 *
 * @author Gabii
 */
public class Sala {
    private boolean asientos[];
    private int numSala;
    private int ocupabilidad;
    
    
    public Sala(int numSala, int ocupabilidad, int numAsientos){
        this.numSala=numSala;
        this.ocupabilidad=ocupabilidad;
        asientos = new boolean[numAsientos];
        for(int n=0;n<asientos.length;n++){
            asientos[n]=false;
        }
        
    }
    
    public boolean disponibilidad(){
        if(ocupabilidad<61){
            return true;
        }
        else{
            return false;
        }
    }
    public void disponibilidadAsientos(){
        System.out.println("N. Asientot /t Estado");
        for(int n=0;n<asientos.length;n++){
            if(asientos[n]==false){
            System.out.println((n+1)+".- /t Disponible");
            }    
            else{
                System.out.println((n+1)+".- /t Ocupado");
            }
        }
    }
    public void setAsiento(int numAsiento){
        if(asientos[numAsiento]==false){
            System.out.println("Se a seleccionado el asiento numero: "+numAsiento);
            ocupabilidad++;
        }
        else{
            System.out.println("El asiento numero: "+numAsiento+ " se encuentra ocupadoOcupado");
        }
    }
    public void setNumSala(int numSala){
        this.numSala=numSala;
    }
    
    public String toString(){
        return "Numero de Sala: "+numSala+"\n"
               +"Numero de asientos disponibles: "+(60-ocupabilidad)+"\n";
    }
}
