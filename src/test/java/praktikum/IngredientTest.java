package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    public IngredientType type;
    public String name;
    public float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "sauce", 100},
                {IngredientType.SAUCE, "cream", 200},
                {IngredientType.FILLING, "cutlet", 100}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetPriceTest(){
        Assert.assertEquals(price,ingredient.getPrice(),100);
    }

    @Test
    public void checkGetNameIngrTest(){
        Assert.assertEquals(name,ingredient.getName());
    }

    @Test
    public void checkGetTypeIngrTest(){
        Assert.assertEquals(type,ingredient.getType());
    }
}
