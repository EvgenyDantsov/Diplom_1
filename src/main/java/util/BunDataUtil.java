package util;

import com.github.javafaker.Faker;

import java.util.Random;

public class BunDataUtil {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static String getName() {
        return faker.funnyName().name();
    }

    public static float getPrice() {
        return random.nextFloat();
    }
}