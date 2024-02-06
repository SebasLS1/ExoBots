package EjercitoRuso;

import InteligenciaArtificial.IABOT;

public class SRExpertoIngles implements ISRExperto{
    private static String srNombreExpertoIngles;
    public SRExpertoIngles(){
        SRExpertoIngles.srNombreExpertoIngles= "Elton";
    }
    public static String srGetNombreExpertoIngles(){
        return srNombreExpertoIngles; 
    }
    public static void srEnsenarIdioma(IABOT srAlumnoIng){
        System.out.println(srAlumnoIng.srAprenderIdiomaIng() );
    }
}
