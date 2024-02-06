package EjercitoRuso;

import InteligenciaArtificial.IABOT;

public class SRExpertoEspanol  implements ISRExperto{
    private static String srNombreExpertoEsp;
    public SRExpertoEspanol(){
        SRExpertoEspanol.srNombreExpertoEsp= "Oscar";
    }
    public static String srGetNombreExpertoEspañol(){
        return srNombreExpertoEsp;
    }
    public static void srEnsenarIdioma(IABOT srAlumnoEsp){
        System.out.println(srAlumnoEsp.srAprenderIdiomaEsp());
    }
}
