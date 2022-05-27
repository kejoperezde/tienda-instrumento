package Procesar;
import Models.*;
import Exception.*;
public class ProcesarInstrumentos {
    public void procesarIns(Instrumento[] i,Registrobin rb,Recibocsv rc) throws ExcCantidad,ExcDescuento,ExcPrecio{
        for (Instrumento ref : i) {
            try {
                if(ref.getCantidad()<=0){
                    throw new ExcCantidad();
                }
                else{
                    if(ref.getPrecio()<100){
                        throw new ExcPrecio();
                    }
                    if(ref.getDesc()!=0){
                        System.out.println(ref.calcularPrecio(ref.getDesc()));
                    }
                    else{
                        System.out.println(ref.calcularPrecio());
                    } 
                    rb.agregarInstrumentobin(ref);
                    rc.agregarInstrumento(ref);
                }
            } catch (ExcCantidad e) {
                e.errorCantidad();
                //e.StackOverflowError();
            } 
            catch (ExcDescuento e) {
                e.errorDescuento();
                //e.StackOverflowError();
            }  
            catch (ExcPrecio e) {
                e.errorPrecio();
                //e.StackOverflowError();
            }  
        }
    }
}