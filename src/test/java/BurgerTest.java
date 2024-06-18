import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final float BUN_PRICE = 2.0f; // Цена булочки
    private static final float INGREDIENT_PRICE = 1.0f; // Цена ингредиентов
    List<Ingredient> expectedIngredients;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;
    private Burger burger;

    @Before
    public void setBurger() {
        burger = new Burger();
        expectedIngredients= new ArrayList<>();
    }

    @Test
    @Description("Test setting buns")
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    @Description("Test adding ingredients")
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    @Description("Test removing ingredients")
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }
    @Test
    @Description("Test moving ingredients")
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);
        // Проверяем, что ингредиенты переместились в правильном порядке
        expectedIngredients.add(ingredient2);
        expectedIngredients.add(ingredient1);

        assertEquals(expectedIngredients, burger.ingredients);
    }
    @Test
    @Description("Test getting price with ingredients")
    public void getPriceTest() {
        // Устанавливаем поведение моков
        when(bun.getPrice()).thenReturn(BUN_PRICE);
        when(ingredient1.getPrice()).thenReturn(INGREDIENT_PRICE);
        when(ingredient2.getPrice()).thenReturn(INGREDIENT_PRICE);

        // Добавляем моки ингредиентов в бургер
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Вызываем getPrice и проверяем результат
        float expectedPrice = BUN_PRICE * 2 + INGREDIENT_PRICE * burger.ingredients.size();
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    @Description("Test getting receipt with ingredients")
    public void getReceiptTest() {
        // Устанавливаем поведение моков
        when(bun.getName()).thenReturn("Sesame Bun");
        when(bun.getPrice()).thenReturn(2.0f);

        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("Cheese");
        when(ingredient1.getPrice()).thenReturn(1.0f);

        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Mayonnaise");
        when(ingredient2.getPrice()).thenReturn(1.5f);

        // Добавляем моки ингредиентов в бургер
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Вызываем getReceipt и проверяем результат
        String expectedReceipt = String.format("(==== %s ====)%n" +
                "= filling %s =%n" +
                "= sauce %s =%n" +
                "(==== %s ====)%n" +
                "%n" +
                "Price: %f%n", "Sesame Bun", "Cheese", "Mayonnaise", "Sesame Bun", 6.5f);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}