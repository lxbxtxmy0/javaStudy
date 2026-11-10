import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductEngine {
    private static final HashMap<SearchKey, Product> engine = new HashMap<>();

    private ProductEngine() {}

    public static void add(Product product) {
        engine.put(new SearchKey(product.getArticul(), product.getBrand()), product);
    }

    public static Product search(SearchKey key) {
        return engine.get(key);
    }
}
