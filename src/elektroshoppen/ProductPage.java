package elektroshoppen;
import java.io.Serializable;

/**
 *
 * @author Bogs
 */
public class ProductPage implements Serializable {
    private String description;
    // to be added: video og billeder, i senere iteration
    public ProductPage (String desc) {
        description = desc;
    }
    public String getDescription() {
        return description + "";
    }
    
}
