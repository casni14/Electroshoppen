package elektroshoppen;
import java.util.*;

/**
 *
 * @author Bogs
 */
public class Webshop {
    ProductCatalog catalog;
    CustomerAccount user;
    public Webshop() {
        catalog = new ProductCatalog();
    }
    public ArrayList browseProducts(ProductType type, double minPrice, double maxPrice) {
        return catalog.browseProducts(type, minPrice, maxPrice);
    }
    public String getProductPage(Product product) {
        return product.getProductPage().getDescription();
    }
    public String getProductName(Product product) {
        return product.getName();
    }
    public double getProductPrice(Product product) {
       return product.getPrice();
    }
    public void addToCart(CustomerAccount acc, Product product) {
        acc.getCart().addToCart(product);
    }
    public ArrayList getCartContents(CustomerAccount acc) {
        return acc.getCart().getContents();
    }
            
    


}