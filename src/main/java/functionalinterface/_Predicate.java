package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09000000000"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));

        System.out.println(
                "is Phone Number Valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(constainsNumber3).test("09000000030")
        );
        System.out.println(
                "is Phone Number Valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(constainsNumber3).test("07000300000")
        );
        System.out.println(
                "is Phone Number Valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.or(constainsNumber3).test("07000000000")
        );
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> constainsNumber3 = phoneNumber -> phoneNumber.contains("3");

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
}
