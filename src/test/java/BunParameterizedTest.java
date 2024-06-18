import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
        private final String bunName;
        private final float bunPrice;
        private Bun bun;


        public BunParameterizedTest(String bunName, float bunPrice) {
            this.bunName = bunName;
            this.bunPrice = bunPrice;
        }

        @Parameterized.Parameters(name = "{index}: Bun - Name: {0}, Price: {1}")
        public static Object[][] getAccordionHeader() {
            return new Object[][]{
                    {"Plain Bun", 1.0f},
                    {"Bun123", 4.0f},
                    {"123", 5.0f},
                    {null, 6.0f},
                    {"", 7.0f},
                    {"Bun with cheesе, chicken, bacon, beef and cucumber", 8.0f},
                    {"#$% Bun with symbols", 8.0f},
                    {"Special Bun with symbols #$%", 9.0f},
                    {"Cheap bun", Float.MIN_VALUE},
                    {"Expensive bun", Float.MAX_VALUE}
            };
        }
    @Before
    public void setBun() {
        bun = new Bun(bunName, bunPrice);
    }
        @Test
        public void testBunName() {
            assertEquals(bunName, bun.getName());
        }

        @Test
        public void testBunPrice() {
            assertEquals(bunPrice, bun.getPrice(), 0.001);
        }
}