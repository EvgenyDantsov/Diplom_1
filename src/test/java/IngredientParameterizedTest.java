import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private Ingredient ingredient;

    public IngredientParameterizedTest(IngredientType ingredientType,String ingredientName, float ingredientPrice) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientType = ingredientType;
    }
    @Parameterized.Parameters(name = "{index}: Ingredient -Type: {0}, Name: {1}, Price: {2}")
    public static Object[][] getAccordionHeader() {
        return new Object[][]{
                {IngredientType.SAUCE, "Lettuce", 0.5f},
                {IngredientType.FILLING, "#$% Bacon", 1.5f},
                {IngredientType.SAUCE, "Cheese #$%", 0.8f},
                {IngredientType.SAUCE, "123 Ketchup", 0.2f},
                {IngredientType.FILLING, "Chicken", Float.MIN_VALUE},
                {IngredientType.SAUCE, "Milk", Float.MAX_VALUE},
                {IngredientType.FILLING, "Tomato123", 2.0f},
                {IngredientType.SAUCE, "Milk Tomato Cheese Ketchup", 3.5f},
                {IngredientType.FILLING, "", 0.0f},
                {IngredientType.SAUCE, null, 1.0f}
        };
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }
    @Test
    @Description("Price assignment check")
    public void getPriceTest() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    @Description("Name assignment check")
    public void getNameTest() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    @Description("Type assignment check")
    public void getTypeTest() {
        assertEquals(ingredientType, ingredient.getType());
    }
}