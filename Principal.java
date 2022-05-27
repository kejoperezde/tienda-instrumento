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
        i[0]=new Violin(100,1,"Yamaha",true,.5,"Stradivarius","4/4");
        i[1]=new Violin(100,1,"Yamaha",.7,"Stradivarius","4/4");
        i[2]=new Guitarra(3000, -12, "Yamaha",0,"Metal", "Alto y Ancho");
        i[3]=new Guitarra(100, 2, "Yamaha", true,.4,"Country", "Bajo y Ancho");
        try {
            pi.procesarIns(i,rb,rc);
            rb.leerInstrumentobi();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}