import jdk.jfr.Description;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    @Description("Check ingredient type FILLING")
    public void getFillingCheckTest() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

    @Test
    @Description("Check ingredient type SAUCE")
    public void getSauceCheckTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }
}