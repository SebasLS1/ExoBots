package Exoesqueleto;

import InteligenciaArtificial.IABOT;
import EjercitoRuso.IHumanoExtremidad;
import EjercitoRuso.Soldado;
import java.util.*;

public class ExoBot extends IABOT implements IHumanoExtremidad {

    private SRFuentePoder eFuentePoder;
    private SRTurboReactor eTurboReactor;
    private SRBrazoDerecho eBrazoDerecho;
    private BrazoIzquierdo eBrazoIzquierdo;
    private SRPierna ePiernaDerecha;
    private SRPierna ePiernaIzquierda;
    public static Boolean srFuenteDePoder = true;
    public static Boolean srTurboReactor = true;
    private boolean piernasSacrificadas = false;


    /**
     * <b> exoBot </b> exoEsqueleto cybertron
     *
     * @param iaBot
     */
    public ExoBot(IABOT ia) {
        super(ia);
        eTurboReactor = new SRTurboReactor();
        ePiernaDerecha = new SRPierna();
        ePiernaIzquierda = new SRPierna();

        if (ExoBot.brazoDerecho)
            eBrazoDerecho = new SRBrazoDerecho();

        if (ExoBot.brazoIzquierdo)
            eBrazoIzquierdo = new BrazoIzquierdo();
        if (ExoBot.srFuenteDePoder)
            eFuentePoder = new SRFuentePoder();
        if (ExoBot.srTurboReactor)
            eTurboReactor = new SRTurboReactor();
    }

    public Boolean inicializar() {
        return true;
    }

   
    
    public void unirseSoldado(Soldado soldado) {
        Scanner sc = new Scanner(System.in);
        boolean disparoBrazoDerecho = false;
        boolean disparoBrazoIzquierdo = false;

        do {
            try {
                if (ExoBot.brazoDerecho && eBrazoDerecho != null && !disparoBrazoDerecho) {
                    if (soldado.getHabilidadBrazoDerecho()) {
                        eBrazoDerecho.setArma(new SRArmaLanzaFuego("Lanza-Fuegos"));
                    } else {
                        eBrazoDerecho.setArma(new SRArmaLaser("Arma Laser"));
                    }
                    eBrazoDerecho.arma.srDisparar(30);
                    eFuentePoder.srRestarEnergia(10);
                    disparoBrazoDerecho = true;
                }

                if (ExoBot.brazoIzquierdo && eBrazoIzquierdo != null && !disparoBrazoIzquierdo) {
                    if (soldado.getHabilidadBrazoIzquierdo()) {
                        eBrazoIzquierdo.setArma(new ArmaMetralleta("Metralleta MK61"));
                    } else {
                        eBrazoIzquierdo.setArma(new ArmaBazuca("Bazuca"));
                    }
                    eBrazoIzquierdo.arma.disparar(30);
                    eFuentePoder.srRestarEnergia(10);
                    disparoBrazoIzquierdo = true;
                }

                System.out.println("¿Qué acción desea realizar?");
                System.out.println("1. Disparar nuevamente con ambos brazos");
                System.out.println("2. Realizar acción con las piernas");
                System.out.println("3. Volar");
                System.out.println("4. Salir");

                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        disparoBrazoDerecho = false;
                        disparoBrazoIzquierdo = false;
                        srLimpiarConsola();
                        break;
                    case 2:
                        if (!piernasSacrificadas) {
                            System.out.println("Elija qué acción quiere realizar");
                            System.out.println("1. Correr");
                            System.err.println("2. Saltar");
                            System.out.println("3. Sacrificar las piernas");

                            int opcionPierna = sc.nextInt();
                            srLimpiarConsola();

                            switch (opcionPierna) {
                                case 1:
                                    if (!piernasSacrificadas) {
                                        ePiernaDerecha.srCorrer();
                                    } else {
                                        System.out.println("Ya no tienes piernas, no puedes correr.");
                                    }
                                    break;
                                case 2:
                                    if (!piernasSacrificadas) {
                                        ePiernaDerecha.srSaltar();
                                    } else {
                                        System.out.println("Ya no tienes piernas, no puedes saltar.");
                                    }
                                    break;
                                case 3:
                                    ePiernaDerecha.srSacrificar();
                                    piernasSacrificadas = true;
                                    break;
                                default:
                                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 3.");
                                    break;
                            }
                        } else {
                            System.out.println("Ya no tienes piernas, no puedes realizar acciones con ellas.");
                        }
                        break;
                    case 3:
                        if (ExoBot.srTurboReactor) {
                            eTurboReactor.srVolar();
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción del 1 al 4.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                sc.nextLine(); 
            }

        } while (true);
    }


    private static void srLimpiarConsola() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
}
}
