package clasep2102025;

public class Rueda {
    private double diametro;
    private String fabricante;

    public Rueda(double diametro, String fabricante) {
        this.diametro = diametro;
        this.fabricante = fabricante;
    }

    public void girar() {
        System.out.println("La Rueda es: " + this.diametro + " El fabricante es " + this.fabricante + " Esta girando muy bien");
    }
}
