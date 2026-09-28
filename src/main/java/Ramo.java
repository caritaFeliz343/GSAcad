

import java.util.ArrayList;

public class Ramo {
    private String nombre;
    private ArrayList<Evaluacion> evaluaciones;
    public Ramo(String nombre) {
        this.nombre = nombre;
        this.evaluaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void agregarEvaluacion(Evaluacion eval) {
        evaluaciones.add(eval);
    }

    public Evaluacion eliminarEvaluacion(int indice) {
        return evaluaciones.remove(indice);
    }
}