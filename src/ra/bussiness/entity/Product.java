package ra.bussiness.entity;

import java.time.LocalDate;

public class Product {
    private String productid;
    private String productName;
    private float price;
    private String description;
    private LocalDate created;
    private int catalogId;
    private ProductStatus status;

    public enum ProductStatus {
        ACTIVE("đang bán"),
        BLOCK("hết hàng"),
        INACTIVE("không bán");

        private String status;

        private ProductStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }

    public Product() {
    }

    public Product(String productid, String productName, float price, String description, LocalDate created, int catalogId, ProductStatus status) {
        this.productid = productid;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.status = status;
    }

    // Getters and Setters for the fields

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Description: %s | Price: %.2f | Created: %s | Catalog: %d | Status: %s",
                productid, productName, description, price, created.toString(), catalogId, status.getStatus());
    }

}