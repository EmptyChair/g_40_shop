package de.ait_tr.g_40_shop.service.interfaces;

import de.ait_tr.g_40_shop.domain.entity.Customer;
import de.ait_tr.g_40_shop.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    List<Customer> getAllActiveCustomers();
    Customer getActiveCustomerById(Long id);
    Customer updateCustomerById(Long id, Customer customer);
    void deleteCustomerById(Long id);
    void deleteCustomerByName(String name);
    Customer restoreCustomerById(Long id);
    long getActiveCustomersQuantity();
    BigDecimal getCustomerProductsTotalPriceById(Long id);
    BigDecimal getCustomerProductsAveragePriceById(Long id);
    Product addProductByCustomerId(Long id, Long productId);
    void deleteProductByCustomerId(Long id, Long productId);
    void removeAllProductsByCustomerId(Long id);

}
