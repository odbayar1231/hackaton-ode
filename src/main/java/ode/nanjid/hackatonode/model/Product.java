package ode.nanjid.hackatonode.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.StringJoiner;

@Entity
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull(message = " * Product Number is required")
    @Digits(integer = 9, fraction = 0, message = "* Product number must be numeric; and a positive, integral value")
    @Column(unique = true, nullable = false)
    private Long productNumber;

    @NotBlank(message = "* Product Name cannot be empty or blank space(s)")
    @Column(nullable = false)
    private String name;

    @Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format such as 'x,xxx/xx'")
    @NumberFormat(pattern = "#,###.##")
    @Column(nullable = true)
    private Double unitPrice;

    @Digits(integer = 6, fraction = 0, message = "* Quantity must be numeric; and a positive, integral value")
    private Integer quantityInStock;

    @NotNull(message = "* Date Supplied is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSupplied;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    public Product(Long productId, Long productNumber, String name, Double unitPrice, Integer quantityInStock, LocalDate dateSupplied, Supplier supplier) {
        this.productId = productId;
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
        this.supplier = supplier;
    }

    public Product(Long productId) {
        this.productId = productId;
    }

    public Product() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("productId=" + productId)
                .add("productNumber=" + productNumber)
                .add("name='" + name + "'")
                .add("unitPrice=" + unitPrice)
                .add("quantityInStock=" + quantityInStock)
                .add("dateSupplied=" + dateSupplied)
                .add("supplier=" + supplier)
                .toString();
    }
}
