import java.util.HashMap;
import java.util.Map;

public class Task2 {
    static void main() {
        Map<String, Integer> products = new HashMap<>();
        products.put("Носки", 300);
        products.put("Футболка", 1200);


        products.replaceAll((k, v) -> v + 150);

        System.out.println(products);
    }
}
