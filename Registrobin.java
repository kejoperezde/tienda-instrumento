import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Models.Instrumento;
public class Registrobin{
    private String fileName;

    public Registrobin(String fileName) {
        super();
        ObjectOutputStream outputstream = null;//crear la clase
        this.fileName = fileName;
        File f = new File(this.fileName);
        try {
            if(!f.exists()){
                outputstream = new ObjectOutputStream(new FileOutputStream(this.fileName));//pasarle el nombre del archivo
                outputstream.close();//cerrarlo
                System.out.println("Se creo el archivo");
            }else{
                System.out.println("Ya existe el archivo");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El error es de tipo: "+e.getClass().getSimpleName());
            //e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("El error es de tipo: "+e.getClass().getSimpleName());
            //e.printStackTrace();
        }
    }

    public void leerInstrumentobi(){
        ObjectInputStream inputstream = null;//crear la clase
        Instrumento i;//se necesita para pasarle el objeto a este
        try {
            inputstream = new ObjectInputStream(new FileInputStream(this.fileName));//buscar el archivo
            while(true){//si dara un error y saldra
                i =(Instrumento) inputstream.readObject();//leer el objeto
                System.out.println(i.getInstrumento());//imprimirlo
            }
        } catch (FileNotFoundException e) {
            System.out.println("El error es de tipo: "+e.getClass().getSimpleName());
            //e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            System.out.println("El error es de tipo: "+e.getClass().getSimpleName());
            //e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Se termino de leer: "+this.fileName);//no tiene manera de parar si una excepcion, asi que este es el fin
            //e.printStackTrace();
        }  
    }

    public void agregarInstrumentobin(Instrumento i){
        AddContenido outputstream =null;
        try {
            outputstream = new AddContenido(new FileOutputStream(this.fileName, true));
            outputstream.writeObject(i);
            outputstream.close();
        } catch (FileNotFoundException e) {
            System.out.println("El error es de tipo: "+e.getClass().getSimpleName());
            //e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Se termino de agregar: "+this.fileName);//no tiene manera de parar si una excepcion, asi que este es el fin
            //e.printStackTrace();
        }  
    }

}
