package Utils;

import org.openqa.selenium.Cookie;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CookieUtils {
    public static void saveCookies(Set<Cookie> cookies, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Cookie cookie : cookies) {
                writer.write(
                        cookie.getName() + ";" +
                                cookie.getValue() + ";" +
                                cookie.getDomain() + ";" +
                                cookie.getPath() + ";" +
                                cookie.getExpiry() + ";" +
                                cookie.isSecure()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<Cookie> loadCookies(String filePath) {
        Set<Cookie> cookies = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");

                Cookie cookie = new Cookie.Builder(data[0], data[1])
                        .domain(data[2])
                        .path(data[3])
                        .isSecure(Boolean.parseBoolean(data[5]))
                        .build();

                cookies.add(cookie);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cookies;
    }

    public static void saveToken(String token, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(token);
        } catch (IOException e) {
            throw new RuntimeException("Cannot save token: " + e.getMessage());
        }
    }

    public static String loadToken(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return null;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Cannot load token: " + e.getMessage());
        }
    }
}
