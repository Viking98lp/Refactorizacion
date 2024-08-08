public class Comparendo {

    private enum Vehiculo {
        CARRO(65, 66, 85),
        CAMION(75, 76, 95),
        MULA(95, 96, 110);

        private final int limiteInferior;
        private final int limiteIntermedio;
        private final int limiteSuperior;

        Vehiculo(int limiteInferior, int limiteIntermedio, int limiteSuperior) {
            this.limiteInferior = limiteInferior;
            this.limiteIntermedio = limiteIntermedio;
            this.limiteSuperior = limiteSuperior;
        }

        public int getLimiteInferior() {
            return limiteInferior;
        }

        public int getLimiteIntermedio() {
            return limiteIntermedio;
        }

        public int getLimiteSuperior() {
            return limiteSuperior;
        }
    }

    public Comparendo() {}

    public void construirFotoMulta(int velocidad, String tipoVehiculo) {
        int cpa = calcularComparendo(velocidad, tipoVehiculo);
        String txt = enviarCorreoFotomulta(tipoVehiculo);
        if (cpa == -1) {
            System.out.println("No hay cálculo para el tipo de vehículo " + tipoVehiculo + " corre: " + txt);
        } else {
            System.out.println("---- El tipo de comparendo es: " + cpa + " ---- Cuerpo del correo: " + txt);
        }
    }

    public int calcularComparendo(int ve, String tp) {
        Vehiculo vehiculo = obtenerVehiculo(tp);
        if (vehiculo == null) {
            return -1;
        }

        if (ve <= vehiculo.getLimiteInferior()) {
            return 0;
        } else if (ve >= vehiculo.getLimiteIntermedio() && ve <= vehiculo.getLimiteSuperior()) {
            return 1;
        }
        return 2;
    }

    public String enviarCorreoFotomulta(String tipoVehiculo) {
        Vehiculo vehiculo = obtenerVehiculo(tipoVehiculo);
        if (vehiculo == null) {
            return "Enviando correo con vehículo desconocido";
        }

        String cuerpoMensaje = "// Enviando correo para el tipo " + tipoVehiculo.toLowerCase() + ".";
        String asunto = "// Asunto: comparendo " + tipoVehiculo.toLowerCase();
        return asunto + cuerpoMensaje;
    }

    private Vehiculo obtenerVehiculo(String tipoVehiculo) {
        try {
            return Vehiculo.valueOf(tipoVehiculo);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
