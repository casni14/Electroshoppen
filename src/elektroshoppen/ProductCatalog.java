package elektroshoppen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bogs
 */
public class ProductCatalog {
   private  ArrayList<Product> products;
    public ProductCatalog() {
        loadProducts();
}
    private void loadProducts(){
        products = new ArrayList();
        PIM pim = new PIM();
        ResultSet rs = pim.getPIMProducts();
       try {
           while(rs.next()) {
               Product product = new Product(rs.getInt(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4));
               products.add(product);
               
           }
       } catch (SQLException ex) {
           Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
 
    public ArrayList browseProducts(ProductType type, double minPrice, double maxPrice) {
        ArrayList<Product> results = new ArrayList();
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getType()==type && products.get(i).getPrice()>=minPrice && products.get(i).getPrice()<=maxPrice) {
                results.add(products.get(i));
            }
            
        }
        return results;
    }
    

    public ArrayList getCatalog() {
        return products;
    }
}
