package main.java;

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

}