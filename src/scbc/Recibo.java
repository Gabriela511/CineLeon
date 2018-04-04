
package scbc;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gabriela Alejandra Pérez Arteaga
 */
public class Recibo {
    private int folio;
    private String cadena;
    
    
      public void GenerarRecibo() throws DocumentException, FileNotFoundException{
        folio=getFolio()+1;
        generarLog(folio);
        FileOutputStream archivo = new FileOutputStream("src/file/recibos/recibo"+getFolio()+".pdf");
        Document recibo = new Document();
        PdfWriter.getInstance(recibo, archivo);
        recibo.open();
        recibo.add(new Paragraph("¡Cine Leon!"));
        recibo.add(new Paragraph("Información Compra"));
        
        recibo.close();
    }
      
         
      public void generarLog(int folio){
          try{
            File archivo=new File("src/file/recibos/folio.txt");
            
            FileWriter escribir=new FileWriter(archivo,true);
            escribir.write(folio);
            escribir.close();
        }catch(Exception e){
            System.out.println("Error al escribir");
        }
      }
      
      public int getFolio(){
        try{
            FileReader f = new FileReader("src/file/recibos/folio.txt");
            BufferedReader b = new BufferedReader(f);
            cadena = b.readLine();
            System.out.println(cadena);
            
            b.close();    
        }catch(Exception e){
            System.out.println("Error al leer2");
        }
        return folio;
      }
      
}