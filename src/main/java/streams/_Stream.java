package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.Female;
import static streams._Stream.Gender.Male;
import static streams._Stream.Gender.PREFER_NOT_TO_SAY;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Male),
                new Person("Maria", Female),
                new Person("Aisha", Female),
                new Person("Alex", Male),
                new Person("Alice", Female),
                new Person("bOB", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println();

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println();

        Function<Person, String> personStringFunction = person -> person.name;

        people.stream()
                .map(personStringFunction)
                .mapToInt(name -> name.length())
                .forEach(System.out::println);

        System.out.println();
        Predicate<Person> personPredicate = person -> Female.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);
        System.out.println(containsOnlyFemales);

        System.out.println();
        boolean containsOnlyFemales2 = people.stream()
                .anyMatch(personPredicate);
        System.out.println(containsOnlyFemales2);

        System.out.println();
        boolean containsOnlyFemales3 = people.stream()
                .noneMatch(personPredicate);
        System.out.println(containsOnlyFemales3);

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
        Male, Female, PREFER_NOT_TO_SAY
    }
}
