/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scbc;

/**
 *
 * @author alumno
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class Boleto {
   public void GenerarBoleto() throws DocumentException, FileNotFoundException{
        
        FileOutputStream archivo = new FileOutputStream("src/file/recibos/boleto.pdf");
        Document recibo = new Document();
        PdfWriter.getInstance(recibo, archivo);
        recibo.open();
        recibo.add(new Paragraph("¡Cine Leon!"));
        recibo.add(new Paragraph("Información Compra"));
        
        recibo.close();
    }
}
