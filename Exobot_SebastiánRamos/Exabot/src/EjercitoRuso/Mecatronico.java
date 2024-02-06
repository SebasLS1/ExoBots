package EjercitoRuso;

import Exoesqueleto.ExoBot;
import InteligenciaArtificial.IABOT;

public class Mecatronico extends Humano{
    public Mecatronico (String nombre){
        super(nombre);
    }
    public void ensamblar(Soldado soldado, ExoBot exoBot, IABOT iabot){
        System.out.println(soldado.getHabilidadBrazoIzquierdo());
        System.out.println(soldado.getHabilidadBrazoDerecho());
        exoBot.unirseSoldado(soldado);
        
    }
}
