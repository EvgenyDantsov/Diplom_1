import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static String name;
    private static float price;
    Faker faker;
    Random random;
    Bun bun;

    @Before
    public void setBun() {
        faker = new Faker();
        random = new Random();
        name = faker.funnyName().name();
        price = random.nextFloat();
        bun = new Bun(name, price);
    }

    @Test
    @Description("Name assignment check")
    public void getNameCheckTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    @Description("Price assignment check")
    public void getPriceCheckTest() {
        assertEquals(price, bun.getPrice(), 0);
    }
}