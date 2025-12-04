package com.adrian.domain;

import java.time.LocalDate;

public class Camper {
    private String nombre;
    private int edad;
    private LocalDate fecha;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Camper(String nombre, int edad, LocalDate fecha) {
        this.nombre = nombre;
        this.edad = edad;
        this.fecha = fecha;
    }

    public Camper(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
