package linkediterador;

public class Cancion {

    private String nombre;
    private String artista;
    private int duracionSeg;
    private String rutaImagen;

    public Cancion(String nombre, String artista, int duracionSeg, String rutaImagen) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
        this.rutaImagen = rutaImagen;
    }
    
    public Cancion(String nombre, String artista, int duracionSeg) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
        
    }
    
    public Cancion() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracionSeg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracion(int duracion) {
        this.duracionSeg = duracion;

    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    @Override
    public String toString() {
        return "[" + nombre + " de -" + artista + " " + duracionSeg + "" + ']';
    }

}
