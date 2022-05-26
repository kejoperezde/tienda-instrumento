package Models;

import Exception.ExcDescuento;

public class Guitarra extends DatosInstrumento implements Instrumento {
     private String genero;
    private String traste;

    public Guitarra(String genero, String trastedouble, double precio, int cantidad, String marca, boolean aditamentos,double desc) {
        super(precio, cantidad, marca, aditamentos, desc);
        this.genero = genero;
        this.traste = traste;
    }

    public Guitarra(String genero, String traste, double precio, int cantidad, String marca,double desc) {
        super(precio, cantidad, marca,desc);
        this.genero = genero;
        this.traste = traste;
    }

    @Override
    public double calcularPrecio() {
        double total;
        total= (getPrecio()*getCantidad()) ;
        return total;
    }

    @Override
    public double calcularPrecio(double desc) throws ExcDescuento{
       double total;
       if(desc>.6){
           ExcDescuento e = new ExcDescuento();
           e.errorDescuento();
           desc = .6;
       }
        total= (getPrecio()*getCantidad())-(getPrecio()*getCantidad()*desc) ;
        return total;
    }

    //sobreescritura de metodo
    @Override
    public double getPrecio() {
        double precio = super.getPrecio();
        if(super.getAditamentos() ==true){
            precio = precio + (precio*.1);
        }
        return precio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTraste() {
        return traste;
    }

    public void setTraste(String traste) {
        this.traste = traste;
    }

    @Override
    public String getInstrumento() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getInstrumento());
        sb.append("Guitarra{");
        sb.append("genero=").append(genero);
        sb.append(", traste=").append(traste);
        sb.append('}');
        return sb.toString();
    }

}
