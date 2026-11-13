import java.util.Objects;

public class Product implements Comparable<Product> {
    private static int articulOrder;

    private final int articul;
    private final String brand;
    private final String kategory;
    private final double price;

    public Product(String brand, String kategory, double price) {
        Objects.requireNonNull(brand);
        Objects.requireNonNull(kategory);

        articul = Product.articulOrder++;
        this.brand = brand;
        this.kategory = kategory;
        this.price = price;
    }

    public int getArticul() {
        return articul;
    }

    public String getBrand() {
        return brand;
    }

    public String getKategory() {
        return kategory;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        if (product.articul == articul && product.brand.equals(brand)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * Integer.hashCode(articul) + brand.hashCode();
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(price, o.price);
    }
}
