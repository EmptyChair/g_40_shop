package de.ait_tr.g_40_shop.service;

import de.ait_tr.g_40_shop.domain.entity.Customer;
import de.ait_tr.g_40_shop.domain.entity.Product;
import de.ait_tr.g_40_shop.repository.CustomerRepository;
import de.ait_tr.g_40_shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setId(null);
        customer.setActive(true);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        //only active customers
        return customerRepository.findAll()
                .stream()
                .filter(Customer::isActive)
                .toList();
    }

    @Override
    public Customer getActiveCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null || !customer.isActive() ) {
            return null;
        }
        return customer;
    }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
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
    public Product addProductByCustomerId(Long id, Long productId) {
        return null;
    }

    @Override
    public void deleteProductByCustomerId(Long id, Long productId) {

    }

    @Override
    public void removeAllProductsByCustomerId(Long id) {

    }
}
