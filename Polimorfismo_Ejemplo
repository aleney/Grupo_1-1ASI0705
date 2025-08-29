abstract class Figura {
    public abstract void area();  //Método abstracto
}

class Circulo extends Figura {
    @Override
    public void area() {
        System.out.println("Área del círculo = π * r²");
    }
}

class Cuadrado extends Figura {
    @Override
    public void area() {
        System.out.println("Área del cuadrado = lado * lado");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creamos un arreglo de figuras
        Figura[] figuras = {new Circulo(), new Cuadrado()};

        for (Figura f : figuras) {
            f.area();
        }
    }
}
