package clasep2102025;

public class Motor {

    private String tipo;
    private String Gaso;
    private int caballos;
    private int cantidadCarburante;
    // NUEVO: Sistema de mantenimiento
    private int kilometrosRecorridos;
    private int kilometrosProximoMantenimiento;
    private boolean requiereMantenimiento;

    public Motor(String tipo, String Gaso, int caballos, int cantidadCarburante) {
        this.tipo = tipo;
        this.Gaso = Gaso;
        this.caballos = caballos;
        this.cantidadCarburante = cantidadCarburante;
        // Inicializar sistema de mantenimiento
        this.kilometrosRecorridos = 0;
        this.kilometrosProximoMantenimiento = 5000; // Cada 5000 km
        this.requiereMantenimiento = false;
    }

    public void inyectarCarburante() {
        int consumo = 2; // Consumo estándar

        if (cantidadCarburante >= consumo) {
            System.out.println("Motor " + this.tipo + " con " + this.caballos 
                + " Caballos de fuerza y esta Inyectando carburante " + this.Gaso + ".");
            System.out.println("🔥 Consumo: " + consumo + "L.");
            
            this.cantidadCarburante -= consumo;
            
            System.out.println("Nivel de combustible restante: " + this.cantidadCarburante + "L");
            
            // NUEVO: Registrar kilómetros recorridos
            registrarKilometros(50); // Cada inyección simula 50 km recorridos
        } else {
            System.out.println("El motor " + this.tipo 
                + " está sin suficiente combustible (" + this.cantidadCarburante + "L).");
        }
    }

    // NUEVO: Método para registrar kilómetros y verificar mantenimiento
    private void registrarKilometros(int km) {
        this.kilometrosRecorridos += km;
        System.out.println("📊 Kilómetros totales recorridos: " + this.kilometrosRecorridos + " km");
        
        // Verificar si necesita mantenimiento
        if (this.kilometrosRecorridos >= this.kilometrosProximoMantenimiento) {
            this.requiereMantenimiento = true;
            System.out.println("⚠️ ALERTA: El motor requiere mantenimiento!");
        }
    }

    // NUEVO: Método para realizar mantenimiento
    public void realizarMantenimiento() {
        if (this.requiereMantenimiento) {
            System.out.println("\n🔧 Realizando mantenimiento al motor " + this.tipo + "...");
            System.out.println("   - Cambio de aceite");
            System.out.println("   - Revisión de filtros");
            System.out.println("   - Inspección general");
            
            this.requiereMantenimiento = false;
            this.kilometrosProximoMantenimiento += 5000;
            
            System.out.println("✅ Mantenimiento completado!");
            System.out.println("📅 Próximo mantenimiento en: " + this.kilometrosProximoMantenimiento + " km\n");
        } else {
            System.out.println("ℹ️ El motor no requiere mantenimiento aún.");
            System.out.println("   Próximo mantenimiento en: " 
                + (this.kilometrosProximoMantenimiento - this.kilometrosRecorridos) + " km\n");
        }
    }

    // NUEVO: Getter para verificar estado
    public boolean necesitaMantenimiento() {
        return this.requiereMantenimiento;
    }
}
