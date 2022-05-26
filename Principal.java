import Models.*;
import Procesar.ProcesarInstrumentos;
import Procesar.Recibocsv;
import Procesar.Registrobin;
public class Principal {
    public static void main(String args[]){
        ProcesarInstrumentos pi= new ProcesarInstrumentos();
        Instrumento i[] = new Instrumento[4];
        Recibocsv rc = new Recibocsv("Recibo.csv");
        Registrobin rb = new Registrobin("Archivo.bin");
        i[0]=new Violin("Stradivarius","4/4",20,1,"Yamaha",true,.6);
        i[1]=new Violin("Stradivarius","4/4",10000,1,"Yamaha",0);
        i[2]=new Guitarra("Metal", "Alto y Ancho", 3000, -12, "Yamaha",0);
        i[3]=new Guitarra("Country", "Bajo y Ancho", 100, 2, "Yamaha", true,.4);
        try {
            pi.procesarIns(i,rb,rc);
            rb.leerInstrumentobi();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}