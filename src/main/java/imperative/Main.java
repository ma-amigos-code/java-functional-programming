package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.Female;
import static imperative.Main.Gender.Male;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Male),
                new Person("Maria", Female),
                new Person("Aisha", Female),
                new Person("Alex", Male),
                new Person("Alice", Female)
        );

        System.out.println("// Imperative approach");
        // Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person: people) {
            if (Female.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person person: females) {
            System.out.println(person);
        }

        System.out.println("\n// Declarative approach");
        // Declarative approach

        Predicate<Person> personPredicate = person -> Female.equals(person.gender);

        people.stream()
                .filter(personPredicate)
                //.collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        Male, Female
    }
}
