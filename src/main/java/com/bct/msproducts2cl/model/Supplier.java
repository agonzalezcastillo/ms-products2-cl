package com.bct.msproducts2cl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name="Supplier")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SUPPLIER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplier implements Serializable {

    @Id
    @Column(name = "supplier_id" , updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id" , referencedColumnName = "supplier_id")
    private List<Product> products;

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(getId(), supplier.getId()) &&
                Objects.equals(getName(), supplier.getName()) &&
                Objects.equals(getProducts(), supplier.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProducts());
    }
}
