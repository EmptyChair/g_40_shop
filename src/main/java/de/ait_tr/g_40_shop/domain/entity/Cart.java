package de.ait_tr.g_40_shop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

//@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //@OneToOne
    private Customer customer;
    //@OnetoMany
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(customer, cart.customer) && Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, products);
    }



    @Override
    public String toString() {
        return String.format("Cart: id - %d, contains %d products", id, products == null ? 0 : products.size() );
    }

    public void addProduct(Product product) {
        if (product.isActive()) {
            products.add(product);
        } else {
            System.out.println("Product inactive, unable to add.");
        }
    }

    public List<Product> getAllProducts() {
        return products.stream()
                .filter(Product::isActive)
                .toList();
    }

    public void deleteProductById(Long productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(productId)) {
                iterator.remove();
                return;
            }
        }
        /*
         products = products.stream()
                .filter(x->x.getId()!=productId)
                .toList();

         */
    }

    public void deleteAllProducts() {
        products.clear();
    }

    public BigDecimal getTotalActivePrice() {
        if (products!=null) {
            BigDecimal totalPrice = products.stream()
                    .filter(Product::isActive)
                    .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPrice;
        }
        return BigDecimal.valueOf(0);
    }

    public BigDecimal getAverageActivePrice() {
        long activeNumber = products.stream()
                .filter(Product::isActive)
                .count();
        //if there are any active numbers
        if (activeNumber > 0) {
            return getTotalActivePrice()
                    .divide(BigDecimal.valueOf(activeNumber));
        }
        //if none
        return BigDecimal.valueOf(0);
    }
}
