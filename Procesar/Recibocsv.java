package Procesar;
import java.util.Scanner;

import Exception.ExcDescuento;
import Models.Instrumento;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Recibocsv{
    PrintWriter outputStream;
    Scanner inpuStream;
    String fileName;
    File f;
    public Recibocsv(String fileName) {
        super();
        String header = "RECIBO No. **     Fecha del recibo del dia xx/xx/xx\n";
        this.fileName = fileName;
        f= new File(fileName);
            try {
                    outputStream = new PrintWriter(new FileOutputStream(fileName));
                    outputStream.println(header);
                    outputStream.close();
                    System.out.println("Se creo el archivo: "+f.getName());
            } catch (FileNotFoundException e) {
                System.out.println("Excepcion de tipo: "+e.getClass().getSimpleName());
                e.printStackTrace();
            }
    }

    public void agregarInstrumento(Instrumento i){
        try {
            outputStream = new PrintWriter(new FileOutputStream(fileName,true));//objeto de tipo editar archivo, true agrega texto nuevo
            outputStream.print("Instrumento de tipo: "+i.getClass().getSimpleName()+".........Precio: "+i.getPrecio());
            if(i.getDesc()>.6){
                outputStream.print("  Cantidad: "+i.getCantidad()+"  Con descuento del: 60%......Total: "+i.calcularPrecio(i.getDesc())+"\n");
            }
            else{
                outputStream.print("  Cantidad: "+i.getCantidad()+"  Con descuento del: "+(i.getDesc()*100)+"%......Total: "+i.calcularPrecio(i.getDesc())+"\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Excepcion de tipo: "+e.getClass().getSimpleName());
            e.printStackTrace();
        }
        catch (ExcDescuento e) {
            System.out.println("Excepcion de tipo: "+e.getClass().getSimpleName());
            e.printStackTrace();
        }
        outputStream.close();//cerrarlo
    }

}