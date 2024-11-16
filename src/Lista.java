import javax.swing.*;

public class Lista {

    private Nodo inicio;
    private int tamanio;

    public Lista() {
        inicio = null;
        tamanio = 0;
    }

    public void agregar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamanio++;
        actualizarTextArea(textArea);
    }

    public boolean eliminar(int dato, JTextArea textArea) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
            return false;
        }
        if (inicio.dato == dato) {
            inicio = inicio.siguiente;
            tamanio--;
            actualizarTextArea(textArea);
            return true;
        }
        Nodo actual = inicio;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamanio--;
            actualizarTextArea(textArea);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado en la lista.");
        return false;
    }

    public int buscarLineal(int dato,  JTextArea textArea) {
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null) {
            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; // Retorna -1 si no se encuentra
    }

    public void ordenarBurbuja(JTextArea textArea) {
        if (inicio == null || inicio.siguiente == null) return;

        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = inicio;
            Nodo siguiente = inicio.siguiente;
            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    intercambio = true;
                }
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (intercambio);

        actualizarTextArea(textArea); // Actualiza la vista en el JTextArea
    }
    private int[] convertirAArray() {
        int[] array = new int[tamanio];
        Nodo actual = inicio;
        int i = 0;
        while (actual != null) {
            array[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return array;
    }

    public void mostrarLista(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía.");
        } else {
            StringBuilder listaStr = new StringBuilder();
            Nodo actual = inicio;
            while (actual != null) {
                listaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(listaStr.toString());
        }
    }

    private void actualizarTextArea(JTextArea textArea) {
        mostrarLista(textArea);
    }
}