import java.net.Socket;
import java.util.Scanner;

import EjercitoRuso.Mecatronico;
import EjercitoRuso.SRExpertoEspanol;
import EjercitoRuso.SRExpertoIngles;
import EjercitoRuso.Soldado;
import Exoesqueleto.ExoBot;
import InteligenciaArtificial.IABOT;

public class SRWhiterun {
        public void iniciar() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("                                         |\r\n" + //
            "                                         |\r\n" + //
            "                                         |\r\n" + //
            "                                         |\r\n" + //
            "   _______                   ________    |\r\n" + //
            "  |ooooooo|      ____       | __  __ |   |\r\n" + //
            "  |[]+++[]|     [____]      |/  \\/  \\|   |\r\n" + //
            "  |+ ___ +|     ]()()[      |\\__/\\__/|   |\r\n" + //
            "  |:|   |:|   ___\\__/___    |[][][][]|   |\r\n" + //
            "  |:|___|:|  |__|    |__|   |++++++++|   |\r\n" + //
            "  |[]===[]|   |_|_/\\_|_|    | ______ |   |\r\n" + //
            "_ ||||||||| _ | | __ | | __ ||______|| __|\r\n" + //
            "  |_______|   |_|[::]|_|    |________|   \\\r\n" + //
            "              \\_|_||_|_/                  \\\r\n" + //
            "                |_||_|                     \\\r\n" + //
            "               _|_||_|_                     \\\r\n" + //
            "      ____    |___||___|                     \\\r\n" + //
            "     /  __\\          ____                     \\\r\n" + //
            "     \\( oo          (___ \\                     \\\r\n" + //
            "     _\\_o/           oo~)/\r\n" + //
            "    / \\|/ \\         _\\-_/_\r\n" + //
            "   / / __\\ \\___    / \\|/  \\\r\n" + //
            "   \\ \\|   |__/_)  / / .- \\ \\\r\n" + //
            "    \\/_)  |       \\ \\ .  /_/\r\n" + //
            "     ||___|        \\/___(_/\r\n" + //
            "     | | |          | |  |\r\n" + //
            "     | | |          | |  |\r\n" + //
            "     |_|_|          |_|__|\r\n" + //
            "     [__)_)        (_(___]");
            System.out.println("Bienvenido a Whiterun...");
            srEsperarTecla(scanner);
            try {
                srLimpiarConsola();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            

            IABOT IA= IABOT.getInstancia("IA-RUSA");  
            ExoBot e1= new ExoBot(IA);
            Soldado s1= new Soldado("Pepe");
            

            System.out.println( "----- Datos del soldado seleccionado -------" );
                System.out.println( "Nombre: "+ s1.getNombre());

            System.out.println( "\u001B[34m"+ "Para un mejor desenvolvimiento en la batalla, el IAbot del exobot aprenderá los idiomas básicos");
                                        SRExpertoEspanol.srEnsenarIdioma(e1);
                                        SRExpertoIngles.srEnsenarIdioma(e1);
                                        e1.srAprenderIdiomaEsp();
                                        e1.srAprenderIdiomaIng();
                                        e1.srMostrarIdiomas();
        System.out.println("\u001B[0m");

        srEsperarTecla(scanner);
        try {
            srLimpiarConsola();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Mecatronico mecatronico= new Mecatronico("Mecatrónico");
        mecatronico.ensamblar(s1, e1, IA);
        }
        
   
         private static void srLimpiarConsola() throws Exception {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        
        private static void srEsperarTecla(Scanner sc) {
                System.out.print("Presione cualquier tecla para continuar..." );
                sc.nextLine();
        }

}
