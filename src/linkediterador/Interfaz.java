
package linkediterador;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Interfaz extends JPanel {

    JButton botonAnterior;
    JButton botonDetener;
    JButton botonPausa;
    JButton botonSiguiente;
    JButton botonUltimo;
    JButton botonPrimero;

    JLabel artista;
    JLabel nombre;
    JLabel logo;
    JLabel reproduciendo;

    private int tiempoSegundos;
    private Timer actualizador;
    boolean estaPausado;
    JProgressBar barraTiempo;

    private Iterador play;
    private Cancion actual;
    private final JList<String> listaCanciones;

    public Interfaz() {
        // --------------------------- Inicializacion de la playlist ---------------------------
        play = new Iterador();

        // --------------------------- Configuracion del panel ---------------------------
        this.setLayout(null);
        this.setBackground(new Color(40, 42, 84));//El color del fondo

        // --------------------------- Carga de iconos ---------------------------
        URL urlIconoPausa = getClass().getResource("/linkediterador/icons/Pausa.png");
        URL urlSiguiente = getClass().getResource("/linkediterador/icons/Siguiente.png");
        URL urlAnterior = getClass().getResource("/linkediterador/icons/Anterior.png");
        URL urlPlay = getClass().getResource("/linkediterador/icons/Play.png");
        URL urlDetener = getClass().getResource("/linkediterador/icons/NuevoDetemer.png");
        URL urlUltimo = getClass().getResource("/linkediterador/icons/Ultimo.png");
        URL urlPrimero = getClass().getResource("/linkediterador/icons/Primero.png");

        // --------------------- Verificacion de carga de iconos ---------------------
        if (urlIconoPausa == null) {
            System.err.println("No se encontró: /linkediterador/icons/Pausa.png");
        }
        if (urlSiguiente == null) {
            System.err.println("No se encontró: /linkediterador/icons/Siguiente.png");
        }
        if (urlAnterior == null) {
            System.err.println("No se encontró: /linkediterador/icons/Anterior.png");
        }
        if (urlPlay == null) {
            System.err.println("No se encontró: /linkediterador/icons/Play.png");
        }
        if (urlDetener == null) {
            System.err.println("No se encontró: /linkediterador/icons/NuevoDetemer.png");
        }
        if (urlUltimo == null) {
            System.err.println("No se encontró: /linkediterador/icons/Ultimo.png");
        }
        if (urlPrimero == null) {
            System.err.println("No se encontró: /linkediterador/icons/Primero.png");
        }

        // --------------------------- Creacion de iconos ---------------------------
        ImageIcon iconoPausa = urlIconoPausa != null ? new ImageIcon(urlIconoPausa) : new ImageIcon();
        ImageIcon iconoSiguiente = urlSiguiente != null ? new ImageIcon(urlSiguiente) : new ImageIcon();
        ImageIcon iconoAtras = urlAnterior != null ? new ImageIcon(urlAnterior) : new ImageIcon();
        ImageIcon iconoPlay = urlPlay != null ? new ImageIcon(urlPlay) : new ImageIcon();
        ImageIcon iconoDetener = urlDetener != null ? new ImageIcon(urlDetener) : new ImageIcon();
        ImageIcon iconoUltimo = urlUltimo != null ? new ImageIcon(urlUltimo) : new ImageIcon();
        ImageIcon iconoPrimero = urlPrimero != null ? new ImageIcon(urlPrimero) : new ImageIcon();

        //--------------------------- Creacion de canciones ---------------------------
        Cancion c1 = new Cancion("Inmortals", "Fall out boy", 189, "/linkediterador/logo/big.jpg");
        Cancion c2 = new Cancion("Carta a dios", "GREEN A", 249, "/linkediterador/logo/carta.jpg");
        Cancion c3 = new Cancion("Fnaf", "The living Tombsone", 200, "/linkediterador/logo/fnaf.jpg");
        Cancion c4 = new Cancion("No me etiquetes", "Grean A", 240, "/linkediterador/logo/etiqueta.jpeg");
        Cancion c5 = new Cancion("Thunder", "Imagine Dragons", 187, "/linkediterador/logo/img.jpg");
        Cancion c6 = new Cancion("Hayloft II", "Mother Mother", 215, "/linkediterador/logo/mm.jpeg");
        Cancion c7 = new Cancion("My kind of woman", "Mac de Marco", 190, "/linkediterador/logo/king.jpeg");
        Cancion c8 = new Cancion("if you want love", "NF", 199, "/linkediterador/logo/nf.jpeg");
        Cancion c9 = new Cancion("Beautiful Things", "Benson Boon", 5, "/linkediterador/logo/BeautifulThings.png");

        //--------------------------- Agregar canciones a la playlist ---------------------------
        play.agregarCancion(c1);
        play.agregarCancion(c2);
        play.agregarCancion(c3);
        play.agregarCancion(c4);
        play.agregarCancion(c5);
        play.agregarCancion(c6);
        play.agregarCancion(c7);
        play.agregarCancion(c8);
        play.agregarCancion(c9);

        // Pedimos la primera canción a la playlist
        actual = play.mostrarPrimera();
        
        //--------------------------- Creacion de la lista de canciones ---------------------------
        listaCanciones = new JList<>();
        listaCanciones.setBackground(new Color(40, 42, 94));
        listaCanciones.setForeground(Color.WHITE);
        listaCanciones.setFont(new Font("Arial", Font.BOLD, 14));
        listaCanciones.setOpaque(false);

        //--------------------------- Actualizacion de la lista ---------------------------
        actualizarLista();
        

        //--------------------------- Creacion de los componentes ---------------------------
        JScrollPane scrollLista = new JScrollPane(listaCanciones);
        botonAnterior = new JButton(redimensionarIcono(iconoAtras, 45, 45));
        botonDetener = new JButton(redimensionarIcono(iconoDetener, 45, 45));
        botonPausa = new JButton(redimensionarIcono(iconoPlay, 45, 45));
        botonSiguiente = new JButton(redimensionarIcono(iconoSiguiente, 45, 45));
        botonUltimo = new JButton(redimensionarIcono(iconoUltimo, 45, 45));
        botonPrimero = new JButton(redimensionarIcono(iconoPrimero, 45, 45));
        artista = new JLabel();
        nombre = new JLabel();
        reproduciendo = new JLabel();
        logo = new JLabel();

        // --------------------------- Configuracion de letra ---------------------------
        artista.setForeground(Color.white);
        artista.setFont(new Font("Arial", Font.BOLD, 10));

        nombre.setForeground(Color.white);
        nombre.setFont(new Font("Arial", Font.BOLD, 18));

        reproduciendo.setForeground(Color.white);
        reproduciendo.setFont(new Font("Arial", Font.BOLD, 18));

        barraTiempo = new JProgressBar(0, 100);
        barraTiempo.setStringPainted(true);
        barraTiempo.setBackground(Color.WHITE);
        barraTiempo.setBorderPainted(false);
        barraTiempo.setStringPainted(true);
        barraTiempo.setBounds(300, 80, 420, 15);

        //--------------------------- posición de botones ---------------------------
        int x = 50;
        int y = 200;
        botonPrimero.setBounds(x, y, 50, 45);
        botonAnterior.setBounds(x + 60, y, 50, 45);
        botonDetener.setBounds(x + 120, y, 50, 45);
        botonPausa.setBounds(x + 180, y, 50, 45);
        botonSiguiente.setBounds(x + 240, y, 50, 45);
        botonUltimo.setBounds(x + 300, y, 50, 45);
        barraTiempo.setBounds(x - 15, y + 60, 380, 30);

        scrollLista.setBounds(480, 0, 300, 350);

        logo.setBounds(x, 110, 80, 80);
        nombre.setBounds(x + 110, 130, 250, 34);
        artista.setBounds(x + 110, 150, 150, 30); //x.y/ancho , alto

        //--------------------------- configuración de los botones ---------------------------
        JButton miBotonConIcono = new JButton(iconoPlay);
        scrollLista.setBorder(null);
        scrollLista.setOpaque(false);

        botonAnterior.setContentAreaFilled(false);
        botonAnterior.setBorderPainted(false);
        botonAnterior.setFocusPainted(false);

        botonDetener.setContentAreaFilled(false);
        botonDetener.setBorderPainted(false);
        botonDetener.setFocusPainted(false);

        botonSiguiente.setContentAreaFilled(false);
        botonSiguiente.setBorderPainted(false);
        botonSiguiente.setFocusPainted(false);

        botonPausa.setContentAreaFilled(false);
        botonPausa.setBorderPainted(false);
        botonPausa.setFocusPainted(false);

        botonPrimero.setContentAreaFilled(false);
        botonPrimero.setBorderPainted(false);
        botonPrimero.setFocusPainted(false);

        botonUltimo.setContentAreaFilled(false);
        botonUltimo.setBorderPainted(false);
        botonUltimo.setFocusPainted(false);

        //--------------------------- Agregar a la interfaz ---------------------------
        this.add(artista);
        this.add(nombre);
        this.add(botonAnterior);
        this.add(botonDetener);
        this.add(botonPausa);
        this.add(botonSiguiente);
        this.add(logo);
        this.add(miBotonConIcono);
        this.add(botonPrimero);
        this.add(botonUltimo);
        this.add(scrollLista);
        this.estaPausado = true;
        this.add(barraTiempo);

        // Mostrar la canción actual inicial 
        mostrarActual(actual);

        //--------------------------- Acciones de los botones ---------------------------
        actualizador = new Timer(1000, e -> {
            if (actual == null) {
                return; // seguridad
            }
            int duracionTotal = actual.getDuracion();
            if (!estaPausado) {
                if (tiempoSegundos <= duracionTotal) {
                    tiempoSegundos++;
                    barraTiempo.setMaximum(duracionTotal);
                    barraTiempo.setValue(tiempoSegundos);
                    barraTiempo.setString(convertidor(tiempoSegundos) + " / " + convertidor(duracionTotal));
                }
            }

            if (tiempoSegundos > duracionTotal) {
                Cancion cancionSiguiente = play.siguiente();
                if (cancionSiguiente != null) {
                    mostrarActual(cancionSiguiente);
                    tiempoSegundos = 0;
                    actual = cancionSiguiente;
                } else {
                    // lista vacía o error -> limpiar UI
                    actual = null;
                    mostrarActual(null);
                }
            }

        });

        botonAnterior.addActionListener(e -> {
            Cancion cancionAnterior = play.anterior();
            if (cancionAnterior != null) {
                mostrarActual(cancionAnterior);
                tiempoSegundos = 0;
                actual = cancionAnterior;
            }
            botonAnterior.setFocusable(false);
        });

        botonSiguiente.addActionListener(e -> {
            Cancion cancionSiguiente = play.siguiente();
            if (cancionSiguiente != null) {
                mostrarActual(cancionSiguiente);
                tiempoSegundos = 0;
                actual = cancionSiguiente;
            }
            botonSiguiente.setFocusable(false);
        });

        botonDetener.addActionListener(e -> {
            System.exit(0);
        });

        botonPausa.addActionListener(e -> {
            if (estaPausado) {
                actualizador.start();
                botonPausa.setIcon(redimensionarIcono(iconoPausa, 45, 45));
                estaPausado = false;
            } else {
                actualizador.stop();
                botonPausa.setIcon(redimensionarIcono(iconoPlay, 45, 45));
                estaPausado = true;
            }
        });

        botonPrimero.addActionListener(e -> {
            Cancion primera = play.mostrarPrimera();
            if (primera != null) {
                mostrarActual(primera);
                actual = primera;
                tiempoSegundos = 0;
            }
            botonPrimero.setFocusable(false);
        });

        botonUltimo.addActionListener(e -> {
            Cancion ultima = play.mostrarUltima();
            if (ultima != null) {
                mostrarActual(ultima);
                actual = ultima;
                tiempoSegundos = 0;
            }
            botonUltimo.setFocusable(false);
        });
    }

    //--------------------------- Métodos auxiliares ---------------------------
    private void mostrarActual(Cancion cancion) {
        if (cancion != null) {
            artista.setText(cancion.getArtista());
            nombre.setText(cancion.getNombre());
            URL urlImagen = getClass().getResource(cancion.getRutaImagen());
            ImageIcon nuevaImagen = urlImagen != null ? new ImageIcon(urlImagen) : new ImageIcon();
            logo.setIcon(redimensionarIcono(nuevaImagen, 80, 80));
            int duracionTotal = cancion.getDuracion();
            barraTiempo.setMaximum(duracionTotal);
            barraTiempo.setValue(0);
            barraTiempo.setString("00:00 / " + convertidor(duracionTotal));
        } else {
            // limpiar UI si no hay canción
            artista.setText("");
            nombre.setText("");
            logo.setIcon(null);
            barraTiempo.setValue(0);
            barraTiempo.setString("00:00 / 00:00");
        }
    }
    private void actualizarLista() {
        DefaultListModel<String> titulo = new DefaultListModel<>();
        for (Cancion cancion : play.getCanciones()) {
            String mostrarTodo = ("<html>" + "<br>" + cancion.getNombre() + "<br>" + cancion.getArtista() + "</html>"); // el <br> es como si fuera un /n para la lista
            titulo.addElement(mostrarTodo);
        }
        listaCanciones.setModel(titulo);

    }
    
    private ImageIcon redimensionarIcono(ImageIcon iconoAtras, int ancho, int altura) {
        Image imagen = iconoAtras.getImage();
        Image nuevaImagen = imagen.getScaledInstance(ancho, altura, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }

    private String convertidor(int totalSegundos) {
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
    
    
}
