package praktikum;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    public String name;
    public float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"black bun", 2.5f},
                {"white bun", 5.5f},
                {null, 3f},
                {"135", 7.4f},
                {"", 2f},
                {"Spec symbol @#$%&", 0.4f},
                {"Expensive bun", Float.MAX_VALUE},
                {"Cheap bun", Float.MIN_VALUE}
        };
    }
    @Before
    public void setUp() {
        bun = new Bun(name,price);
    }

    @Test
    @DisplayName("Check get name bun")
    public void checkGetNameBunTest() {
        Assert.assertEquals("Неверное имя булочки",name, bun.getName());   //Следование элементов исправлено
    }

    @Test
    public void checkGetPriceBunTest() {
        Assert.assertEquals("Неправильная цена булочки",price, bun.getPrice(),3.4f);
    }
}