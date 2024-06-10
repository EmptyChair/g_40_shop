package de.ait_tr.g_40_shop.service;

import de.ait_tr.g_40_shop.domain.entity.Customer;
import de.ait_tr.g_40_shop.domain.entity.Product;
import de.ait_tr.g_40_shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return null;
    }

    @Override
    public Customer getActiveCustomerById(Long id) {
        return null;
    }

    @Override
    public Customer updateCustomerById(Long id) {
        return null;
    }

    @Override
    public void deleteCustomerById(Long id) {

    }

    @Override
    public void deleteCustomerByName(String name) {

    }

    @Override
    public Customer restoreCustomerById(Long id) {
        return null;
    }

    @Override
    public long getActiveCustomersQuantity() {
        return 0;
    }

    @Override
    public BigDecimal getCustomerProductsTotalPriceById(Long id) {
        return null;
    }

    @Override
    public BigDecimal getCustomerProductsAveragePriceById(Long id) {
        return null;
    }

    @Override
    public Product addProductByCustomerId(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProductByCustomerId(Long id, Product product) {

    }

    @Override
    public void removeAllProductsByCustomerId(Long id) {

    }
}
