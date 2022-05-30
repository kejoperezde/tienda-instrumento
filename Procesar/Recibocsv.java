package Procesar;

import java.util.Scanner;

import Exception.ExcDescuento;
import Models.Instrumento;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Recibocsv {
    PrintWriter outputStream;
    Scanner inpuStream;
    String fileName;
    File f;

    public Recibocsv(String fileName) {
        super();
        String header = "Tipo,Precio,Cantidad,Descuento,Total";
        this.fileName = fileName;
        f = new File(fileName);
        try {
            if (!f.exists()) {
                outputStream = new PrintWriter(new FileOutputStream(fileName));
                outputStream.println(header);
                outputStream.close();
                System.out.println("Se creo el archivo: " + f.getName());
            }else{
                System.out.println("Ya existe el archivo: " + f.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Excepcion de tipo: " + e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    public void agregarInstrumento(Instrumento i) {
        try {
            outputStream = new PrintWriter(new FileOutputStream(fileName, true));// objeto de tipo editar archivo, true
                                                                                 // agrega texto nuevo
            outputStream.print(i.getClass().getSimpleName() + "," + i.getPrecio() + ",");
            if (i.getDesc() > .6) {
                outputStream.print(+i.getCantidad() + "," + "60.0," + i.calcularPrecio(.6) + "\n");
            } else {
                outputStream.print(
                        i.getCantidad() + "," + (i.getDesc() * 100) + "," + i.calcularPrecio(i.getDesc()) + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Excepcion de tipo: " + e.getClass().getSimpleName());
            e.printStackTrace();
        } catch (ExcDescuento e) {
            System.out.println("Excepcion de tipo: " + e.getClass().getSimpleName());
            e.printStackTrace();
        }
        outputStream.close();// cerrarlo
    }

    public void getFormatoRecibo(){
        String line, datos[];
        int items = 0;
        double total = 0;
        try {
            Scanner inputStream = new Scanner(new File(fileName));
            line = inputStream.nextLine();
            System.out.println("-------------------------------------------");
            System.out.println("TIENDA DE INSTRUMENTOS");
            System.out.println("TELEFONO: 311-121-92-66");
            System.out.println("EMAIL: tienda@tienda.com");
            System.out.println("-------------------------------------------");
            System.out.println("TIPO    CANT.    PRECIO    DESC.    TOTAL");
            while (inputStream.hasNextLine()) {
                line = inputStream.nextLine();
                if (line != null) {
                    datos = line.split(",");
                    // Tipo,Precio,Cantidad,Descuento,Total
                    System.out.println(datos[0] + "     " + datos[2] + "     " + datos[1] + "     " + datos[3] + "     " + datos[4]);
                    total += Double.parseDouble(datos[4]);
                    items += Integer.parseInt(datos[2]);
                }
            }
            System.out.println("-------------------------------------------");
            System.out.println("Total de instrumentos: " + items);
            System.out.println("Precio total: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }


}