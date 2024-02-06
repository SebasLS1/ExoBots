package Exoesqueleto;

public class SRFuentePoder {
    public static int srNivelEnergia=100; 
    public static void srRecargar(){
        String carga[] = { "0oo", "o0o", "oo0", "o0o" };
            for (int porcentaje = 0; porcentaje <= 100; porcentaje++) {
                    String c = carga[porcentaje % 4];
                    System.out.print("\r" + "... " + porcentaje + "% " + c);
    
                    try {
                            Thread.sleep(30);
                    } catch (InterruptedException ie) {
                    }
            }
            System.out.println();
        srNivelEnergia= 100; 
        System.out.println("Recarga de energía completa.");
    }
    public static void srRestarEnergia(int cantidad) {
        if (srNivelEnergia > cantidad) {
            srNivelEnergia -= cantidad;
            System.out.println();
            System.out.println("Nivel de energía restante: "+ (srNivelEnergia));
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Nivel de energía insuficiente para completar la actividad D: .");
            srRecargar();
            
        }
    }
   
}

