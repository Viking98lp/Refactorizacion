public class Main {

    public static void main(String[] args) {
        Comparendo comparendo = new Comparendo();

        String[] tiposVehiculo = {"CARRO", "MULA", "CAMION", "AVION"};
        int[] velocidades = {80, 200, 40, 40};

        for (int i = 0; i < tiposVehiculo.length; i++) {
            comparendo.construirFotoMulta(velocidades[i], tiposVehiculo[i]);
        }
    }
}