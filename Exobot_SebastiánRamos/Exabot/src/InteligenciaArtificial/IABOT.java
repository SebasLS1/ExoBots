package InteligenciaArtificial;
import java.util.Hashtable;
public class IABOT {
    private static String nombre; 
    private static IABOT instanciabot;

    private IABOT(){
    }

    protected IABOT(IABOT ia) {
        if(ia != null){
            instanciabot=ia;
        }
    }

    public static IABOT getInstancia(String nombre){
        if(instanciabot== null){
            instanciabot= new IABOT();
            IABOT.nombre=  nombre; 
        }
        return instanciabot; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
       this.nombre= nombre;
    }

    Hashtable<Integer, String> srLista= new Hashtable<>();
    public String srAprenderIdiomaEsp(){
        srLista.put(1, "Espanol");
        return "Aprendiendo espanol";
    }

    public String srAprenderIdiomaIng(){
        srLista.put(2, "Ingles");
        return "Aprendiendo ingles";
    }

    public void srMostrarIdiomas(){
        System.out.println("Idiomas aprendidos: ");
        srLista.forEach((k, v) -> {
            System.out.print(v + " , ");
        });
        System.out.println();
    }
}
