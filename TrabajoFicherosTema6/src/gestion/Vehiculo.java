package gestion;

import java.util.Objects;

/**
 * Clase que representa a un vehiculo dentro del sistema de gestion el cual implement Comparable para ordenar los vehiculos por marca
 */
public class Vehiculo implements Comparable<Vehiculo>{

    protected String matricula;
    protected String marca;
    protected String modelo;
    protected boolean alquilado;

    /**
     * Constructor inicial
     * @param matricula
     * @param marca
     * @param modelo
     */
    public Vehiculo(String matricula, String marca, String modelo) {
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("La matrícula no puede ser nula ni vacía.");
        }
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.alquilado = false;
    }

    //Getters
    public String getMatricula() { return matricula; }
    
    public String getMarca() { return marca; }
    
    public String getModelo() { return modelo; }
    
    public boolean isAlquilado() { return alquilado; }

    @Override
    /**
     * Implementacion del metodo toString para mostrar los datos del vehiculo.
     */
    public String toString() {
        return matricula + " " + marca + " " + modelo + " " +
               (alquilado ? "No Disponible" : "Disponible");
    }

    @Override
    /**
     * Implementacion del metodo equals para que los vehiculos con igual matricula sean iguales
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Vehiculo other = (Vehiculo) obj;
        return Objects.equals(matricula, other.matricula);
    }

    @Override
    /**
     * Implementación del metodo compareTo ordenandolo por marca
     */
    public int compareTo(Vehiculo otro) {
        int aMarca = this.marca.compareToIgnoreCase(otro.marca);
        if (aMarca != 0) return aMarca;
        return this.modelo.compareToIgnoreCase(otro.modelo);
    }
}
