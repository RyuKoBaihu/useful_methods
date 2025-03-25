package StreamData;

import java.util.*;
import java.util.stream.*;

public class StreamExamples {

    public static void filterExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("FILTER CHALLENGE");
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("----------------");
    }

    public static void mapExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("MAP CHALLENGE");
        System.out.println("Squares: " + squares);
        System.out.println("----------------");
    }

    public static void distinctExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("DISTINCT CHALLENGE");
        System.out.println("Distinct numbers: " + distinctNumbers);
        System.out.println("----------------");
    }

    public static void forEachExample() {
        List<String> names = Arrays.asList("Ana", "John", "Maria","Amanda","Janis Joplin");

        names.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(name -> System.out.println("Hello, " + name + "!"));
    }

    public static void collectExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Set<Integer> squareSet = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toSet());

        System.out.println("Squares in a Set: " + squareSet);
    }

    public static void reduceExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce(Integer::sum);

        sum.ifPresent(s -> System.out.println("Sum: " + s));
    }

    public static void sortedExample() {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        System.out.println("Sorted numbers: " + sortedNumbers);
    }

    public static void findOldestPersonExample() {
        // Map with persons
        Map<String, Integer> persons = new HashMap<>();
        persons.put("João", 28);
        persons.put("Maria", 35);
        persons.put("Carlos", 92);
        persons.put("Ana", 31);

        // Using
        String olderPerson = persons.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // find older
                .map(Map.Entry::getKey)  // extract name
                .orElse("Didn't find old one");

        int age = persons.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // find older
                .map(Map.Entry::getValue)  // extract age
                .orElseThrow(() -> new IllegalArgumentException("Didn't find old one"));

        System.out.println("The older one is: " + olderPerson);
        System.out.println("The age is: " + age);
    }


}
