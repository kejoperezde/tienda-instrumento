import Models.*;

public class Principal {
    public static void main(String args[]){
        ProcesarInstrumentos pi= new ProcesarInstrumentos();
        Instrumento i[] = new Instrumento[4];
        i[0]=new Violin("Stradivarius","4/4",10000,1,"Yamaha",true,.5);
        i[1]=new Violin("Stradivarius","4/4",10000,1,"Yamaha",0);
        i[2]=new Guitarra("Metal", "Alto y Ancho", 3000, -12, "Yamaha",0);
        i[3]=new Guitarra("Country", "Bajo y Ancho", 100, 2, "Yamaha", true,.4);
        try {
            pi.getRecibo(i);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}