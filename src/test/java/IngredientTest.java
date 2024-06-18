import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import util.BunDataUtil;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private static String name;
    private static float price;
    private IngredientType type;

    Ingredient ingredient;

    @Before
    public void setIngredient() {
        name = BunDataUtil.getName();
        price = BunDataUtil.getPrice();
        type = IngredientType.SAUCE;
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    @Description("Price assignment check")
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    @Description("Name assignment check")
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    @Description("Type assignment check")
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }
}