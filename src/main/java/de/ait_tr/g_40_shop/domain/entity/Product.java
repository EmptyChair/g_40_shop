package de.ait_tr.g_40_shop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity //such object are stored in DB
@Table(name="product") //objects are saved in table "product"
public class Product {
    //if we want id field to be ignored when object is being made from JSON request, use
    //@JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB automatically generates autoincemented IDs
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="active")
    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return active == product.active && Objects.equals(id, product.id) && Objects.equals(title, product.title) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, active);
    }

    @Override
    public String toString() {
        return String.format("PRODUCT: id - %d, title - %s, price - %s, active - %s",
                id, title, price, active ? "yes" : "no");
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
