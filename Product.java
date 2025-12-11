public class Product {
    private int id;
    private String name;
    private String barcode;
    private double price;
    private int stock;

    public Product(int id, String name, String barcode, double price, int stock) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
