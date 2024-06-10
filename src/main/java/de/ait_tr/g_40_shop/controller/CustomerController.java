package de.ait_tr.g_40_shop.controller;

import de.ait_tr.g_40_shop.domain.entity.Customer;
import de.ait_tr.g_40_shop.domain.entity.Product;
import de.ait_tr.g_40_shop.service.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomer(@RequestParam(required = false) Long id){
        if (id == null) {
            return customerService.getAllActiveCustomers();
        }   else {
            return List.of(customerService.getActiveCustomerById(id));
        }
    }

    @PutMapping
    public Customer updateCustomerById(@RequestParam(required = true) Long id){
        return customerService.updateCustomerById(id);
    }

    @DeleteMapping
    public void deleteCustomer(@RequestParam(required = false) Long id,
                                   @RequestParam(required = false) String title){
        if (id != null) {
            customerService.deleteCustomerById(id);
        } else if (title!=null) {
            customerService.deleteCustomerByName(title);
        }
    }

    @PutMapping("/restore-customer")
    public void restore(@RequestParam Long id) {
        customerService.restoreCustomerById(id);
    }

    @GetMapping("/quantity-customers")
    public long getActiveCustomerQuantity() {
        return customerService.getActiveCustomersQuantity();
    }

    @GetMapping("/cart-cost")
    public BigDecimal getCustomerProductsTotalPriceById(@RequestParam Long id) {
        return customerService.getCustomerProductsTotalPriceById(id);
    }

    @GetMapping("/cart-average-price")
    public BigDecimal getCustomerProductsAveragePriceById(@RequestParam Long id) {
        return customerService.getCustomerProductsAveragePriceById(id);
    }

    @PutMapping
    public Product addProductByCustomerId(@RequestParam Long id, Product product) {
        return customerService.addProductByCustomerId(id, product);
    }

    @DeleteMapping
    public void deleteProductByCustomerId(@RequestParam Long id, Product product){
        customerService.deleteProductByCustomerId(id, product);
    }

    @DeleteMapping
    public void removeAllProductsByCustomerId(@RequestParam Long id){
        customerService.removeAllProductsByCustomerId(id);
    }

}
