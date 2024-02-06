package Exoesqueleto;

public class SRArmaDerechaImpl implements ISRArmaDerechaha {
    protected String tipo; 
    public SRArmaDerechaImpl(String tipo){
        this.tipo= tipo; 
        System.out.println(tipo);
    }
    @Override
    public void srDisparar(int cantidadBalas){
        for (int i = 0; i < cantidadBalas; i++) {
            System.out.print(" - ");
        }
    }
    @Override
    public String srGetTipo(){
        return tipo; 
    }
    @Override
    public void srSetTipo(String tipo){
        this.tipo= tipo; 
    }
}
