package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import java.util.*;
import java.util.Set;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {

        // Task 2
        // Stwórz dwa HashSety integerów i zaimplementuj dla nich następujące działania rachunków zbiorów:
        // suma, część wspólna, różnica, suma bez części wspólnej.
        // Wynik działania powinien trafić do trzeciego zbioru.

        Set<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(5);
        setA.add(6);
        setA.add(7);
        setA.add(31);
        setA.add(2);

        Set<Integer> setB = new HashSet<>();
        setB.add(4);
        setB.add(5);
        setB.add(7);
        setB.add(21);
        setB.add(30);

        Set<Integer> setUnion = new HashSet<>();
        for (Integer a : setA) {
            setUnion.add(a);
        }
        for (Integer b : setB) {
            setUnion.add(b);
        }

        System.out.println("Union of setA and setB:");
        System.out.println(setUnion);

        Set<Integer> setIntersection = new HashSet<>();
        for (Integer a : setA) {
            for (Integer b : setB) {
                if (a == b) {
                    setIntersection.add(a);
                }
            }
        }
        System.out.println("Intersection of setA and setB:");
        System.out.println(setIntersection);

        Set<Integer> setDifferenceAB = new HashSet<>();
        for (Integer a : setA) {
            boolean found = false;
            for (Integer b : setB) {
                if (a == b) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                setDifferenceAB.add(a);
            }
        }

        System.out.println("Difference of setA and setB:");
                System.out.println(setDifferenceAB);

        Set<Integer> setDifferenceBA = new HashSet<>();
        for (Integer b : setB) {
            boolean found = false;
            for (Integer a : setA) {
                if (b == a) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                setDifferenceBA.add(b);
            }
        }
        System.out.println("Difference of setB and setA:");
                System.out.println(setDifferenceBA);

        Set<Integer> setSymmetricDifference = new HashSet<>();
        for (Integer a : setA) {
            boolean found = false;
            for (Integer b : setB) {
                if (a == b) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                setSymmetricDifference.add(a);
            }
        }
        for (Integer b : setB) {
            boolean found = false;
            for (Integer a : setA) {
                if (b == a) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                setSymmetricDifference.add(b);
            }
        }

        System.out.println("SymmetricDifference of setB and setA:");
        System.out.println(setSymmetricDifference);

// Task 3 Stwórz dwie HashMapy<String, Integer> (jak w liście zakupów) i zaimplementuj ich sumowanie.
// Np jedna mapa to Jajka: 3; Mleko: 1, a druga to Jajka: 2; Kiełbasa: 2, wynik to Jajka: 5; Mleko: 1; Kiełbasa: 2

        Map<String, Integer> mapA = new HashMap<>();
        mapA.put("Eggs",3);
        mapA.put("Milk",1);
        mapA.put("Cookies",2);

        Map<String, Integer> mapB = new HashMap<>();
        mapB .put("Eggs",2);
        mapB .put("Sausage",2);
        mapB .put("Cookies",5);

        Map<String, Integer> mapUnion = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            mapUnion.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : mapB.entrySet()) {
            if (mapUnion.containsKey(entry.getKey())) {
                mapUnion.put(entry.getKey(), mapUnion.get(entry.getKey()) + entry.getValue());
            } else {
                mapUnion.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Sum of MapA and MapB:");
        System.out.println(mapUnion);


// Task 4 Zaimplementuj pozostałe działania rachunku zbiorów (część wspólna, różnica, suma bez części wspólnej)
// dla HashMap z listami zakupów.

        Map<String, Integer> mapIntersection = new HashMap<>();
        for (Map.Entry<String, Integer> entryA : mapA.entrySet()) {
            if (mapB.containsKey(entryA.getKey())) {
                Integer valueA = entryA.getValue();
                Integer valueB = mapB.get(entryA.getKey());
                Integer valueDiff = valueA > valueB ? valueA - valueB : valueB - valueA;
                mapIntersection.put(entryA.getKey(), valueDiff);
            }
        }

        System.out.println("Intersection of MapA and MapB:");
        System.out.println(mapIntersection);

        Map<String, Integer> mapDifferenceAB = new HashMap<>();
        for (Map.Entry<String, Integer> entryA : mapA.entrySet()) {
            if (!mapB.containsKey(entryA.getKey())) {
                mapDifferenceAB.put(entryA.getKey(), entryA.getValue());
            }
        }

        System.out.println("Difference of MapA and MapB:");
        System.out.println(mapDifferenceAB);

        Map<String, Integer> mapDifferenceBA = new HashMap<>();
        for (Map.Entry<String, Integer> entryB : mapB.entrySet()) {
            if (!mapA.containsKey(entryB.getKey())) {
                mapDifferenceBA.put(entryB.getKey(), entryB.getValue());
            }
        }
        System.out.println("Difference of MapB and MapA:");
        System.out.println(mapDifferenceBA);


        Map<String, Integer> mapSymmetricDifference = new HashMap<>();
        for (Map.Entry<String, Integer> entryA : mapA.entrySet()) {
            if (!mapB.containsKey(entryA.getKey())) {
                mapSymmetricDifference.put(entryA.getKey(), entryA.getValue());
            }
        }
        System.out.println("Symetric difference of MapA and MapB:");
        System.out.println(mapSymmetricDifference);

        //------------Praca własna na zajęciach : kod poniżej------------

        /*
        // Stwórz dwa HashSety integerów i zaimplementuj dla nich następujące działania rachunków zbiorów:
        // suma, część wspólna, różnica, suma bez części wspólnej.
        // Wynik działania powinien trafić do trzeciego zbioru.

        Set<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(5);
        setA.add(6);
        setA.add(7);
        setA.add(31);
        setA.add(2);

        Set<Integer> setB = new HashSet<>();
        setB.add(4);
        setB.add(5);
        setB.add(7);
        setB.add(21);
        setB.add(30);

        //suma
        Set<Integer> setC= new HashSet<>();
        System.out.println("Zbiór A:");
        for (Integer numberA : setA) {
            System.out.println(numberA);
            setC.add(numberA);
        }
        System.out.println("Zbiór B:");
        for (Integer numberB : setB) {
            System.out.println(numberB);
            setC.add(numberB);
        }
        System.out.println("Zbiór C, który jest sumą zbiorów A i B:");
        System.out.println(setC);

        //czesc wspolna
        System.out.println("Część wspólna zbiorów A i B:");
        Set<Integer> setD= new HashSet<>();
        for (Integer numberA : setA ) {
            for (Integer numberB : setB) {
                if (numberA == numberB) {
                    setD.add(numberA);
                }
        }
        }
        System.out.println(setD);


        //roznica A\B
        System.out.println("Różnica zbioru A i B:");
        Set<Integer> setE= new HashSet<>();
        for (Integer numberA : setA ) {
            Boolean inSetB=false;
            for (Integer numberB : setB) {
                if (numberA==numberB){
                    inSetB=true;
                    break;
                }
            }
            if (inSetB==false) {
            setE.add(numberA);
            }
        }
        System.out.println(setE);

        //roznica B\A
        System.out.println("Różnica zbioru B i A:");
        Set<Integer> setF= new HashSet<>();
        for (Integer numberB : setB ) {
            Boolean inSetA=false;
            for (Integer numberA : setA) {
                if (numberB==numberA){
                    inSetA=true;
                    break;
                }
            }
            if (inSetA==false) {
                setF.add(numberB);
            }
        }
        System.out.println(setF);


        //suma bez części wspólnej
        System.out.println("Suma zbioru A i B bez cześci wspólnej:");

        //suma a i b
        Set<Integer> setG= new HashSet<>();
            //suma
             for (Integer numberA : setA) {
            setG.add(numberA);
            }
             for (Integer numberB : setB) {
            setG.add(numberB);
        }

             //czesc wspolna
        Set<Integer> setH= new HashSet<>();
        for (Integer numberA : setA ) {
            for (Integer numberB : setB) {
                if (numberA == numberB) {
                    setH.add(numberA);
                }
            }
        }

        //roznica G\H
        Set<Integer> setK= new HashSet<>();
        for (Integer numberG : setG ) {
            Boolean inSetH=false;
            for (Integer numberH : setH) {
                if (numberG==numberH){
                    inSetH=true;
                    break;
                }
            }
            if (inSetH==false) {
                setK.add(numberG);
            }
        }
        System.out.println(setK);



        //Zadanie 2. Stwórz dwie HashMapy<String, Integer> (jak w liście zakupów) i zaimplementuj ich sumowanie.
        // Np jedna mapa to Jajka: 3; Mleko: 1, a druga to Jajka: 2; Kiełbasa: 2, wynik to Jajka: 5; Mleko: 1; Kiełbasa: 2

        Map<String, Integer> groceriesA = new HashMap<>();
        groceriesA.put("Eggs",3);
        groceriesA.put("Milk",1);
        groceriesA.put("Cookies",2);

        Map<String, Integer> groceriesB = new HashMap<>();
        groceriesB .put("Eggs",2);
        groceriesB .put("Sausage",2);
        groceriesB .put("Cookies",5);

        Map<String, Integer> groceriesSum = new HashMap<>();
        for(Map.Entry<String, Integer> entryA: groceriesA.entrySet()) {
            String keyA = entryA.getKey();
            Integer valueA = entryA.getValue();
            groceriesSum.put(keyA, valueA);

            for(Map.Entry<String, Integer> entryB: groceriesB.entrySet()) {
                String keyB = entryB.getKey();
                Integer valueB = entryB.getValue();
                //System.out.println(keyB + ": " + valueB);
                //Boolean inKeyB = false;
                if (keyA != keyB) {
                    groceriesSum.put(keyB, valueB);
                }
            }

             }

        System.out.println("Wynik sumy");
        System.out.println(groceriesSum);
        //komentarz




        //Zaimplementuj pozostałe działania rachunku zbiorów (część wspólna, różnica, suma bez części wspólnej) dla HashMap z listami zakupów.
        */
    }
}