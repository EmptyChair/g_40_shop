package de.ait_tr.g_40_shop.repository;

import de.ait_tr.g_40_shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//Product long because Product has ID Long
// Spring will create class and object, makes it bean and put it in context
public interface ProductRepository extends JpaRepository<Product, Long> {
}
