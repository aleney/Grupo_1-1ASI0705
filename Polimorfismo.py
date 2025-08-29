import math

# Clase base
class Figura:
    def area(self):
        pass  # Se implementará en las subclases
    
    def descripcion(self):
        return "Soy una figura geométrica."

# Subclase: Círculo
class Circulo(Figura):
    def __init__(self, radio):
        self.radio = radio

    def area(self):
        return math.pi * self.radio ** 2
    
    def descripcion(self):
        return f"Soy un Círculo con radio {self.radio}"

# Subclase: Rectángulo
class Rectangulo(Figura):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def area(self):
        return self.base * self.altura
    
    def descripcion(self):
        return f"Soy un Rectángulo de {self.base} x {self.altura}"

# Subclase: Triángulo
class Triangulo(Figura):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def area(self):
        return (self.base * self.altura) / 2
    
    def descripcion(self):
        return f"Soy un Triángulo con base {self.base} y altura {self.altura}"

# Función que demuestra el polimorfismo
def mostrar_informacion(figura):
    print(figura.descripcion())
    print(f"Área: {figura.area():.2f}")
    print("-" * 30)

# Programa principal
if __name__ == "__main__":
    figuras = [
        Circulo(5),
        Rectangulo(4, 6),
        Triangulo(3, 7)
    ]
    
    for f in figuras:
        mostrar_informacion(f)