package exercise5_1.data;

import exercise5_1.models.TestUser;
import org.example.ConfigReader;

public class TestDataFactory {
    public static ConfigReader configReader = new ConfigReader();
    public static TestUser getNormalUser() {
        return new TestUser.UserBuilder()
                .username(configReader.getDataInput("USERNAME"))
                .password(configReader.getDataInput("PASSWORD"))
                .role("USER")
                .active(true)
                .build();
    }
}
