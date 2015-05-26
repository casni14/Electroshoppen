package elektroshoppen;

/**
 *
 * @author Bogs
 */
import java.util.ArrayList;
public class ShoppingCart {
    private ArrayList<Product> contents;
    public ShoppingCart() {
        contents = new ArrayList();
    }
    
    public void addToCart(Product product) {
    contents.add(product);
        
    }
    public ArrayList getContents() {
        return contents;
    }
    
}
