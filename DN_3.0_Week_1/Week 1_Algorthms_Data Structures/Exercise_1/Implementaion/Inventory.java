import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> productMap;

    public Inventory() {
        this.productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void deleteProduct(String productId) {
        productMap.remove(productId);
    }

    public Product getProduct(String productId) {
        return productMap.get(productId);
    }
}
