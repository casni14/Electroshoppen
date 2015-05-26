package elektroshoppen;

import java.io.Serializable;

/**
 *
 * @author Bogs
 */
public class Product implements Serializable {

    private ProductType type;
    private String name;
    private double price;
    private ProductPage page;

    public Product(int type, String name, double price, String desc) {
        setType(type);
        this.name = name;
        this.price = price;
        page = new ProductPage(desc);
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public ProductPage getProductPage() {
        return page;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + price + " kr";
    }

    private void setType(int id) {
        if (id > 1000 && id < 2000) {
            type = ProductType.TV;
        }
        if (id > 2000 && id < 3000) {
            type = ProductType.SPEAKERS;
        }
        if (id > 3000 && id < 4000) {
            type = ProductType.PC;
        }
        if (id > 4000 && id < 5000) {
            type = ProductType.LAPTOP;
        }
        if (id > 5000 && id < 6000) {
            type = ProductType.HARDDISK;
        }
        if (id > 6000 && id < 7000) {
            type = ProductType.CPU;
        }
        if (id > 7000 && id < 8000) {
            type = ProductType.GRAPHICSCARD;
        }
        if (id > 8000 && id < 9000) {
            type = ProductType.RAM;
        }

    }

}
