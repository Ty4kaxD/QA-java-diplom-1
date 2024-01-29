import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {"bun", 123f},
                {"BLACK BUN", 222f},
                {null, 1f},
                {"asdfg", Float.NaN},
                {"bu n", 100.0f},
                {"hot_bun", 200.9999999f},
                {"*bun-", -123f},
                {"~!@#$%^&*(()_+}{|][/.,.", 0f},
                {"", 222f},
                {"булка", 111f},
                {"qweqwe1eqweqweqdasd1321ewqeqwe213eqwdfdr", Float.MAX_VALUE},
                {"qweqwe1eqweqweqdasd1321ewqeqwe213eqwdfdrgtfhygthjurteryghrthghfghfghfghfdewfdfsdgfdsgdfgdfgdfgdfgdfgdfgdfsgdsfg", Float.MIN_VALUE}

        };

    }

    @Before
    public void startTest() {
        bun = new Bun(name, price);

    }

    @Test
    public void checkGetValidName() {
        assertEquals("Ошибка имени", name, bun.getName());
    }

    @Test
    public void checkGetValidPrice() {
        assertEquals("Ошибка цены", price, bun.getPrice(), 0.0f);
    }
}

