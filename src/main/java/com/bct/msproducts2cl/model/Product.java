package com.bct.msproducts2cl.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name="Product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private Integer id;

    private String name;

    private String description;

    private Integer quantity;

    private Double price;

    private String type;

    @Column(name = "supplier_id", updatable = false)
    private Integer supplierId;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", supplierId=" + supplierId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return  Objects.equals(getName(), product.getName()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getType(), product.getType()) &&
                Objects.equals(getSupplierId(), product.getSupplierId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getQuantity(), getPrice(), getType(), getSupplierId());
    }
}
