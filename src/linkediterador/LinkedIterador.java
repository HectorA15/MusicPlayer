package linkediterador;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class LinkedIterador {

    public static void main(String[] args) {
        
        Iterador play = new Iterador();
        
        //interfaz ya establecida
        /*
        JFrame r1 = new JFrame("Reproductor");
        r1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        r1.setSize(850, 350);
        Interfaz ventana = new Interfaz();
        r1.add(ventana);
        r1.setResizable(false);
        r1.setLocationRelativeTo(null);
        r1.setVisible(true);
         */

        Cancion c1 = new Cancion("Inmortals", "Fall out boy", 189);
        Cancion c2 = new Cancion("Carta a dios", "GREEN A", 249);
        Cancion c3 = new Cancion("No me etiquetes", "Grean A", 240);
        Cancion c4 = new Cancion("Thunder", "Imagine Dragons", 187);
        Cancion c5 = new Cancion("Hayloft II", "Mother Mother", 215);
        Cancion c6 = new Cancion("My kind of woman", "Mac de Marco", 190);
        Cancion c7 = new Cancion("if you want love", "NF", 199);
        Cancion c8 = new Cancion("Beautiful Things", "Benson Boon", 5);
        
        
        play.mostrarTodo();
        
        System.out.println("------------------------- 1 -----------------------");
        play.agregarCancion(c1);
        play.agregarCancion(c2);
        play.agregarCancion(c3);
        play.mostrarTodo();
        System.out.println();
        
        System.out.println("------------------------- 2 -----------------------");
        play.agregarUltimo(c4);
        play.agregarUltimo(c5);
        play.mostrarTodo();
        System.out.println();
        
        System.out.println("------------------------- 3 -----------------------");
        play.agregarPrimero(c6);
        play.agregarPrimero(c7);
        play.mostrarTodo();
        System.out.println();
        
        System.out.println("------------------------- 4 -----------------------");
        play.agregarEn(5, c8);
        play.mostrarTodo();
        System.out.println();
        
        System.out.println("------------------------- 5 -----------------------");
        play.eliminarUltimo();
        play.mostrarTodo();
        System.out.println();
        
        System.out.println("------------------------- 6 -----------------------");
        play.eliminarEn(2);
        play.mostrarTodo();
        System.out.println();
        
        System.out.println("------------------------- 7 -----------------------");
        play.eliminarPrimero();
        play.mostrarTodo();
        System.out.println();
        
        System.out.println("------------------------- 8 -----------------------");
        play.mostrarPosicion(4);
        play.mostrarPrimera();
        play.mostrarUltima();
        System.out.println();
    }
    
}
