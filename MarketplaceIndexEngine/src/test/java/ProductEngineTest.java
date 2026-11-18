import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductEngineTest {

    @Test
    void testAddAndSearch() {
        Product prodact1 = new Product("Nike", "boots", 562);
        ProductEngine.add(prodact1);
        ProductEngine.add(new Product("Adidas", "boots", 678));

        SearchKey key = new SearchKey(prodact1.getArticul(), "Nike");

        Product found = ProductEngine.search(key);
        assertSame(prodact1, found);
    }
}