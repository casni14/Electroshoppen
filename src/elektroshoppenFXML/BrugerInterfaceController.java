/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elektroshoppenFXML;

import elektroshoppen.*;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.input.ContextMenuEvent;

/**
 * FXML Controller class
 *
 * @author CasperBeese
 */
public class BrugerInterfaceController implements Initializable {

    Webshop webshop = new Webshop();
    ProductType productType;
    ObservableList<Product> productList;
    CustomerAccount customer;
    @FXML
    private TextField minPrice;
    @FXML
    private TextField maxPrice;
    @FXML
    private ListView<Product> resultsList;
    
    private Label productName;
    @FXML
    private ToggleGroup type;
    @FXML
    private TextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customer = new CustomerAccount();
        // TODO
    }

    @FXML
    private void browseProducts(ActionEvent event) {
        productList = FXCollections.observableArrayList((webshop.browseProducts(productType, Double.parseDouble(minPrice.getText()), Double.parseDouble(maxPrice.getText()))));
        resultsList.setItems(productList);
    }

    @FXML
    private void setPC(ActionEvent event) {
        productType = ProductType.PC;
    }

    @FXML
    private void setLaptop(ActionEvent event) {
        productType = ProductType.LAPTOP;
    }

    @FXML
    private void setTV(ActionEvent event) {
        productType = ProductType.TV;
    }

    @FXML
    private void setSpeakers(ActionEvent event) {
        productType = ProductType.SPEAKERS;
    }



    @FXML
    private void getProductPage(MouseEvent event) throws IOException {
        Product selectedItem = (Product) resultsList.getSelectionModel().getSelectedItem();
        resultsList.getSelectionModel().clearSelection();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductPageFXML.fxml"));
        Parent root = (Parent) loader.load();
        ProductPageFXMLController controller = loader.getController();
        controller.initData(selectedItem, webshop, customer);
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
        

    }
}
