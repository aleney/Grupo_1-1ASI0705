//clase principal que ejecutará el programa
public class Encapsulamiento {
    public static void main(String[] args) {
    Factura factura_upc = new Factura();
    factura_upc.SetCodigo("cod_123");
    factura_upc.SetMonto(2200.20);
    //factura_upc.SetCodigo("cod_456");

    System.out.print("El código es: ");
    System.out.println(factura_upc.getCodigo());
    System.out.print("El monto a pagar es: ");
    System.out.println(factura_upc.getMonto());
    }
}


class Factura{
    //atributos privados no accesibles sin métodos
    private String codigo;
    private double monto;

    //Getters de codigo y monto
    public String getCodigo() {
        return codigo;
    }

    public double getMonto() {
        return monto;
    }


    //Setters de codigo y monto
    public void SetCodigo(String newCodigo){
        if (this.codigo != null){
            throw new RuntimeException("El código ya fue asignado");
        }
        this.codigo = newCodigo;
    }

    public void SetMonto(double newMonto){
        this.monto = newMonto;
    }

}