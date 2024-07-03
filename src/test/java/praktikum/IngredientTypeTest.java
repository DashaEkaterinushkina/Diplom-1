package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void sauceTest(){
        Assert.assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }
    @Test
    public void fillingTest(){
        Assert.assertEquals("FILLING",IngredientType.FILLING.toString());
    }
}
