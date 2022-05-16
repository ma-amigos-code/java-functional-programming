package combinatorpattern;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+523344668899",
                LocalDate.of(2000, 1, 1)
        );

        // normal java
        System.out.println( new CustomerValidatorService().isValid(customer) );

        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
