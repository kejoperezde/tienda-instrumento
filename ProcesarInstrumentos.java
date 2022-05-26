import Models.*;
import Exception.*;

public class ProcesarInstrumentos {
    public void getRecibo(Instrumento[] i) throws ExcCantidad,ExcDescuento{
        for (Instrumento ref : i) {
            try {
                if(ref.getCantidad()<0){
                    throw new ExcCantidad();
                }
                else{
                    if(ref.getDesc()!=0){
                        System.out.println(ref.calcularPrecio(ref.getDesc()));
                    }else{
                        System.out.println(ref.calcularPrecio(ref.getDesc()));
                    }
                }
            } catch (ExcCantidad e) {
                System.out.println("Error tipo "+e.getClass().getSimpleName());
                //e.StackOverflowError();
            } 
            catch (ExcDescuento e) {
                System.out.println("Error tipo "+e.getClass().getSimpleName());
                //e.StackOverflowError();
            }     
        }
    }
}