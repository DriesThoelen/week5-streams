package be.pxl.streams;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class DemoStreams {
    public static void main(String[] args) {
        IntStream.range(5, 26).filter(n -> n % 2 == 0).map(n -> n * n).forEach(n -> System.out.print(n + " "));
        System.out.println();
        OptionalDouble result = IntStream.of(18,15,12,14,13).average();
        if (result.isPresent()) {
            System.out.println("Average: " + result.getAsDouble());
        } else {
            System.out.println("No average available.");
        }
        int sum = IntStream.of(15,18,12,14).sum();
        System.out.println("Sum: " + sum);

        ArrayList<String> animals = new ArrayList<>();
        animals.add("aardvarken");
        animals.add("wombat");
        animals.add("gordeldier");
        animals.add("panda");

        animals.stream().filter(s -> s.contains("o")).forEach(s -> System.out.print(s + " "));
        System.out.println();
        animals.stream().mapToInt(s -> s.length()).max().ifPresent(System.out::println);

        animals.add("zebra");
        animals.add("orka");
        animals.add("panda");

        System.out.println("Dieren eidinigend op a :");
        animals.stream().filter(s -> s.endsWith("a")).distinct().peek(s -> System.out.println("###" + s)).sorted().forEach(System.out::println);

        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Hasselt", 77651, 102.24));
        cities.add(new City("Genk", 66110, 87.85));
        cities.add(new City("Bree", 16005, 64.96));
        cities.add(new City("Opglabbeek", 10332, 24.98));
        cities.add(new City("Diepenbeek", 19137, 41.19));

        int somAantalInwoners = cities.stream().mapToInt(c -> c.getNumberOfCitizens()).sum();
        int somAantalInwonersVanOpglabbeekEnDiepenbeek = cities.stream().filter(c -> c.getName().endsWith("beek")).mapToInt(c -> c.getNumberOfCitizens()).sum();
        double somOppervlakte = cities.stream().mapToDouble(c -> c.getArea()).sum();

        System.out.println("Som inwoners : " + somAantalInwoners);
        System.out.println("Som inwoners van Opglabbeek en Diepenbeek : " + somAantalInwonersVanOpglabbeekEnDiepenbeek);
        System.out.println("Som oppervlakte : " + somOppervlakte);
    }
}