import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import util.BunDataUtil;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static String name;
    private static float price;
    Bun bun;

    @Before
    public void setBun() {
        name = BunDataUtil.getName();
        price = BunDataUtil.getPrice();
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