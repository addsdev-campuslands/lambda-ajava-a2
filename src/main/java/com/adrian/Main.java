package com.adrian;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.adrian.domain.Camper;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> mercado = Map.of(
                "Pollo", 3,
                "Arroz", 7,
                "Frutas", 2,
                "Banano", 20);

        List<Camper> campers = Arrays.asList(
                new Camper("Juan", 21, LocalDate.of(1998, 11, 6)),
                new Camper("Sara", 17, LocalDate.of(2000, 10, 30)),
                new Camper("Laura", 27, LocalDate.of(1995, 5, 12)),
                new Camper("Cristian", 20, LocalDate.of(2005, 2, 2)));

        Comparator<Camper> comparatorAsc = (p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad());
        Comparator<Camper> comparatorDesc = (p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad());
        Comparator<Camper> comparatorDate = (p1, p2) -> p2.getFecha().compareTo(p1.getFecha());

        Consumer<Camper> print = (c) -> {
            System.out.println("Informacion Camper");
            System.out.println("Nombre:\t" + c.getNombre());
            System.out.println("Edad:\t" + c.getEdad());
        };

        Consumer<Camper> printWithDate = (c) -> {
            System.out.println("Informacion Camper");
            System.out.println("Nombre:\t" + c.getNombre());
            System.out.println("Edad:\t" + c.getEdad());
            System.out.println("Fecha:\t" + c.getFecha().toString());
        };


        mostrarDatos(campers, comparatorDate, printWithDate);
        System.out.println("+++++++++++++++++++++++++++++");
        mostrarDatos(campers, comparatorAsc, print);
        System.out.println("+++++++++++++++++++++++++++++");
        mostrarDatos(campers, comparatorDesc, printWithDate);

        System.out.println("=============================");
        BiConsumer<String, Integer> printMap = (k,v) -> {
            System.out.println("Mercado Libre: ");
            System.out.println(k+ ":\t" + v + " u");
        };
        mostrarDatos(mercado, printMap);

        Supplier<Integer> edad = () -> {
            campers.sort((c1,c2) -> c1.getEdad() - c2.getEdad());
            return campers.get(0).getEdad();
        };

        System.out.println("La edad mayor del grupo de campers es: " + edadMayor(campers));
        System.out.println("La edad mayor del grupo de campers es: " + edad.get());


    }

    public static int edadMayor(List<Camper> datos) {
        datos.sort((c1,c2) -> c1.getEdad() - c2.getEdad());
        return datos.get(0).getEdad();
    } 

    public static void mostrarDatos(Map<String,Integer> datos, BiConsumer<String,Integer> print) {
        datos.forEach(print);
    }

    public static void mostrarDatos(List<Camper> datos, Comparator<Camper> orden, Consumer<Camper> print) {
        datos.sort(orden);
        datos.forEach(print);
    }
}