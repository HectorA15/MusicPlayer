package linkediterador;

import java.util.LinkedList;
import java.util.ListIterator;

public class Iterador {

    private LinkedList<Cancion> list = new LinkedList<>();
    private ListIterator<Cancion> it = list.listIterator();
    private Cancion actual = null;
    private int indice = 0;

    public Iterador() {
    }

    // ------------------ Reiniciar -----------------------
    public void reiniciar() {
        if (list.isEmpty()) {
            actual = null;
            indice = -1;
            it = list.listIterator();
        } else {
            indice = 0;
            actual = list.get(0);
            it = list.listIterator(1);
        }
    }

    // ------------------ Agregar -----------------------
    public void agregarCancion(Cancion cancion) {
        list.add(cancion);

        if (actual == null) {
            // si no hay actual, reiniciamos reproducción a la primera canción 
            indice = 0;
            actual = list.get(0);
            it = list.listIterator(indice + 1);
        } else {
            int pos = list.indexOf(actual);
            if (pos >= 0) {
                it = list.listIterator(pos + 1);
            }
        }

    }

    public void agregarEn(int index, Cancion cancion) {

        //comprobar que no se salga de los limites
        if (index < 0 || index > list.size()) {
            return;
        }

        list.add(index, cancion);

        // si actual es null, inicializamos
        if (actual == null && !list.isEmpty()) {
            it = list.listIterator();

            //para que comience en la primera cancion
            if (it.hasNext()) {
                actual = it.next();
            }
        }
    }

    public void agregarPrimero(Cancion cancion) {
        list.addFirst(cancion);   // o tambien ---> agregarEn(0, cancion);
    }

    public void agregarUltimo(Cancion cancion) {
        list.addLast(cancion);
    }

    // ------------------ Navegar -----------------------
    public Cancion siguiente() {
        if (list.isEmpty()) {
            reiniciar();
            return null;
        }
        if (indice == -1) {
            indice = 0;                         // si no había actual, empezamos en la primera
        } else {
            indice = (indice + 1) % list.size();
        }
        actual = list.get(indice);
        it = list.listIterator(indice + 1);     //se pone el iterador despues del actual
        return actual;
    }

    public Cancion anterior() {
        if (list.isEmpty()) {
            reiniciar();
            return null;
        }
        if (indice == -1) {
            indice = list.size() - 1;           // si no había actual, empezamos en la última
        } else {
            indice = (indice - 1 + list.size()) % list.size();
        }

        actual = list.get(indice);
        it = list.listIterator(indice + 1);     //se pone el iterador despues del actual
        return actual;
    }

    // ------------------ Eliminar -----------------------
    public Cancion eliminarEn(int posicion) {

        if (list.isEmpty()) {
            return null;                //si no hay canciones retorna null (no cambia nada)
        }
        Cancion eliminado = list.remove(posicion);      //guarda lo que se elimino en "eliminado"

        //si la lista esta vacia despues de eliminar la cancion, reiniciamos todo
        if (list.isEmpty()) {
            reiniciar();
            return eliminado;
        }

        //reposicionamos el indice y el la cancion actual
        if (posicion < list.size()) {
            indice = posicion;
            actual = list.get(indice);
        } else {
            //si se eliminó el último, tomamos la nueva última
            indice = list.size() - 1;
            actual = list.get(indice);
        }

        it = list.listIterator(indice + 1);
        return eliminado;
    }

    public Cancion eliminarPrimero() {
        return eliminarEn(0);
    }

    public Cancion eliminarUltimo() {

        return eliminarEn(list.size() - 1);
    }

    // ------------------ Mostrar -----------------------
    public Cancion mostrarPosicion(int pos) {
        if (pos < 0 || pos >= list.size()) {
            return null;
        }
        return list.get(pos);
    }

    public Cancion mostrarPrimera() {
        return list.isEmpty() ? null : list.getFirst();
    }

    public Cancion mostrarUltima() {
        return list.isEmpty() ? null : list.getLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isVacia() {
        return list.isEmpty();
    }

    public Cancion getActual() {
        return actual;
    }

    public int getIndex() {
        return indice;
    }

    public void mostrarTodo() {
        if (list.isEmpty()) {
            System.out.println("La playlist esta vacia.");
            return;
        }
        int i = 0;
        for (Cancion cancion : list) {
            System.out.println(i + ": " + cancion.toString());
            i++;
        }

    }

    public LinkedList<Cancion> getCanciones() {
        return this.list;
    }
}
