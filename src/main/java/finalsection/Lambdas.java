package finalsection;

import javax.naming.Name;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCasetName = name -> {
                // logic
                if (name.isBlank())
                    throw new IllegalStateException("");
                return name.toUpperCase();
        };

        System.out.println(upperCasetName.apply("esther"));
    }

    class Service {
        public Consumer<String> blah = s -> {

        };
    }
}
