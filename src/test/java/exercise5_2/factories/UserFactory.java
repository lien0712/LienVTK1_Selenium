package exercise5_2.factories;

import com.github.javafaker.Faker;
import exercise5_2.models.User;

public class UserFactory {
    private static final Faker faker = new Faker();

    public static User createValidUser() {
        return new User(
                "student",
                "Aa@123456" ,
                "SUCCESS");
    }

    public static User createUserInvalid() {
        return new User(
                faker.name().username(),
                "Aa@" + faker.number().digits(6),
                "FAIL");
    }

    public static User createUserWithEmptyPassword() {
        return new User(
                faker.name().username(),
                "",
                "FAIL");
    }
}
