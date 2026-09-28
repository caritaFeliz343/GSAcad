package main.java;

public class Evaluacion {
    private String nombre;
    private int prioridad;

    public Evaluacion(String nombre, int prioridad) {
        this.nombre = nombre;
        setPrioridad(prioridad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad <= 3) {
            this.prioridad = prioridad;
        } else {
            this.prioridad = 1;
        }
    }

    public String getPrioridadTexto() {
        switch (prioridad) {
            case 1: return "Baja";
            case 2: return "Media";
            case 3: return "Alta";
            default: return "Baja";
        }
    }

    @Override
    public String toString() {
        return "Evaluación: " + nombre + " | Prioridad: [" + prioridad + " - " + getPrioridadTexto() + "]";
    }
}