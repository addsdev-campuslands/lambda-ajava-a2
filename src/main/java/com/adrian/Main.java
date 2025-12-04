package com.adrian;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.adrian.domain.Camper;
import com.adrian.domain.Sexo;

public class Main {
    public static void main(String[] args) {

        List<Camper> campers = Arrays.asList(
                new Camper("Juan", 21, LocalDate.of(1998, 11, 6)),
                new Camper("Sara", 17, LocalDate.of(2000, 10, 30), Sexo.FEMENINO),
                new Camper("Laura", 27, LocalDate.of(1995, 5, 12), Sexo.FEMENINO),
                new Camper("Cristian", 20, LocalDate.of(2010, 2, 2)),
                new Camper("Chuki", 20, LocalDate.of(2010, 2, 2), Sexo.OTRO));

        filtradoAvanzado(campers);
    }

    public static int edadMayor(List<Camper> datos) {
        datos.sort((c1, c2) -> c1.getEdad() - c2.getEdad());
        return datos.get(0).getEdad();
    }

    public static void mostrarDatos(Map<String, Integer> datos, BiConsumer<String, Integer> print) {
        datos.forEach(print);
    }

    public static void mostrarDatos(List<Camper> datos, Comparator<Camper> orden, Consumer<Camper> print) {
        datos.sort(orden);
        datos.forEach(print);
    }

    public static void filtradoAvanzado(List<Camper> campers) {
        var streamCamers = campers.stream()
                .filter((c) -> {
                    var result = c.getFecha().compareTo(LocalDate.now().minusYears(18)) < 0;
                    // System.out.println(c.getNombre() + " : " + result);
                    return result;
                })
                .filter((c) -> c.getSexo() == Sexo.FEMENINO)
                // .peek(printWithDate)
                .map((c) -> c.getNombre() + " -> " + c.getEdad())
                // .peek((nuevo) -> System.out.println(nuevo))
                .toList();

        System.out.println("Fin del filtrado: " + streamCamers.size());
        System.out.println("Lista original: " + campers.size());

        var total = campers.size();
        var masculinos = campers.stream()
                .filter((camper) -> camper.getSexo() == Sexo.MASCULINO)
                .map((c) -> 1)
                .reduce(0, (acomulador, item) -> acomulador + item);

        var femeninos = campers.stream()
                .filter((camper) -> camper.getSexo() == Sexo.FEMENINO)
                .map((c) -> 1)
                .reduce(0, (acomulador, item) -> acomulador + item);
        var otros = campers.stream()
                .filter((camper) -> camper.getSexo() == Sexo.OTRO)
                .map((c) -> 1)
                .reduce(0, (acomulador, item) -> acomulador + item);

        System.out.println("Total: " + total);
        System.out.println("Masculinos: " + masculinos);
        System.out.println("Femeninos: " + femeninos);
        System.out.println("Otros: " + otros);

        // Filtrar campers mayores de edad
        // Obtener los nombres de las campers
        // Calcular la suma de las edades
        // Calcular el promedio de las edades
        // Calcular el promedio de las edades por Sexo

    }
}