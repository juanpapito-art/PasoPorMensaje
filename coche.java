package clasep2102025;

public class Coche {
    private String color;
    private int velocidad;
    private float tamaño;
    private Rueda[] ruedas;
    private Motor motor;

    public Coche(String color, int velocidad, float tamaño, Rueda[] ruedas, Motor motor) {
        this.color = color;
        this.velocidad = velocidad;
        this.tamaño = tamaño;
        this.ruedas = ruedas;
        this.motor = motor;
    }

    public void avanzar() {
        System.out.println("\nEl coche " + this.color + " avanza");

        motor.inyectarCarburante();

        for (int i = 0; i < ruedas.length; i++) {
            ruedas[i].girar();
        }
        
        System.out.println("--- COCHE: Avanzando a " + this.velocidad + " km/h\n");
    }

    // NUEVO: Método para llevar el coche al taller
    public void irAlTaller() {
        System.out.println("\n🏁 Llevando el coche " + this.color + " al taller...");
        motor.realizarMantenimiento();
    }

    public static void main(String[] args) {

        Rueda[] ruedas = {new Rueda(20, "Dunlop"),
                          new Rueda(20, "Dunlop"),
                          new Rueda(22, "Dunlop"),
                          new Rueda(22, "Dunlop")};

        // --- Escenario 1: Coche Diesel con sistema de mantenimiento ---
        System.out.println("=== PRUEBA 1: COCHE DIESEL ===");
        Motor motorDiesel = new Motor("Diesel", "ACPM", 1000, 15);
        Coche miCoche = new Coche("Color pollito", 80, 3.2f, ruedas, motorDiesel);

        miCoche.avanzar();
        miCoche.avanzar();
        miCoche.avanzar();
        
        // Verificar mantenimiento
        miCoche.irAlTaller();

        // --- Escenario 2: Coche Gasolina ---
        System.out.println("\n=== PRUEBA 2: COCHE GASOLINA ===");
        Motor motorGasolina = new Motor("Gasolina", "Premium", 500, 10);
        Coche tuCoche = new Coche("Azul", 100, 4.0f, ruedas, motorGasolina);
        
        tuCoche.avanzar();
        tuCoche.avanzar();
        
        // Intentar mantenimiento antes de tiempo
        tuCoche.irAlTaller();
        
        // --- Escenario 3: Coche Eléctrico alcanzando el límite de mantenimiento ---
        System.out.println("\n=== PRUEBA 3: COCHE ELÉCTRICO ===");
        Motor motorElectrico = new Motor("Electrico", "Batería", 400, 20);
        Coche suCoche = new Coche("Negro", 150, 4.5f, ruedas, motorElectrico);
        
        // Simular muchos kilómetros para activar alerta
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Viaje #" + i + " ---");
            suCoche.avanzar();
        }
        
        // Realizar mantenimiento necesario
        suCoche.irAlTaller();
        
        // Continuar después del mantenimiento
        suCoche.avanzar();
    }
}
