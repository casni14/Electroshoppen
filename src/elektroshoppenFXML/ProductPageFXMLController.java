/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elektroshoppenFXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import elektroshoppen.*;

/**
 * FXML Controller class
 *
 * @author Bogs
 */
public class ProductPageFXMLController implements Initializable {
    Product product;
    Webshop webshop;
    CustomerAccount customer;
    @FXML
    private TextArea descriptiveTextArea;
    @FXML
    private Label productName;
    @FXML
    private Label productPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    public void initData(Product selectedItem, Webshop webshop, CustomerAccount customer) {
    this.product = selectedItem;
    this.webshop = webshop;
    this.customer = customer;
    productName.setText(webshop.getProductName(product));
    productPrice.setText("" + webshop.getProductPrice(product) + " kr");
    descriptiveTextArea.setText(webshop.getProductPage(product));
    }
    
    @FXML
    private void addToCart(ActionEvent event) {
        webshop.addToCart(customer, product);
    }
    
}
