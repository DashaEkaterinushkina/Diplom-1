package praktikum;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    public Ingredient ingredient;
    @Mock
    public Ingredient ingredient1;
    @Mock
    private Bun bun;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    @DisplayName("Check call set Bun")
    public void checkCallMethodSetBunTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Неверный инградиент", bun, burger.bun);
    }
    @Test
    @DisplayName("Check call add ingredient")
    public void checkCallAddIngredientTest(){
        burger.addIngredient(ingredient1);
        Assert.assertEquals("Неверное добавление инградиент-1",List.of(ingredient1),burger.ingredients);
    }

    @Test
    @DisplayName("Check remove ingredient")
    public void checkRemoveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertEquals("Неверное удаление инградиента-1", List.of(),burger.ingredients);
    }

    @Test
    @DisplayName("Check move ingredient")
    public void checkMoveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        Assert.assertEquals("Неверное перемещение инградиентов - 0 и 1", ingredient1, burger.ingredients.get(0));
    }

    @Test
    @DisplayName("Check get price and receipt burger")
    public void checkGetPriceAndReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List <Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        Assert.assertEquals("Неверный рецепт",receipt.toString(),burger.getReceipt());
    }
}