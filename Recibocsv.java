import java.util.Scanner;

import javax.sound.midi.Instrument;

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
        String header = "RECIBO No. **\n";
        this.fileName = fileName;
        f= new File(fileName);
            try {
                    outputStream = new PrintWriter(new FileOutputStream(fileName,true));
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
            outputStream = new PrintWriter(new FileOutputStream(fileName, true));//objeto de tipo editar archivo, true agrega texto nuevo
            outputStream.print(i.getInstrumento()+"\n");//metodo para escribir
        } catch (FileNotFoundException e) {
            System.out.println("Excepcion de tipo: "+e.getClass().getSimpleName());
            e.printStackTrace();
        }
        outputStream.close();//cerrarlo
    }

}