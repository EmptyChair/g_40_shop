package de.ait_tr.g_40_shop.controller;

import de.ait_tr.g_40_shop.domain.dto.CustomerDto;
import de.ait_tr.g_40_shop.domain.entity.Customer;
import de.ait_tr.g_40_shop.domain.entity.Product;
import de.ait_tr.g_40_shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
//note for postman-requests
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto save(@RequestBody CustomerDto customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<CustomerDto> getCustomer(@RequestParam(required = false) Long id){
        if (id == null) {
            return customerService.getAllActiveCustomers();
        }   else {
            CustomerDto customerDto = customerService.getActiveCustomerById(id);
            return customerDto == null ? null : List.of(customerService.getActiveCustomerById(id));
        }
    }

    @PutMapping
    public CustomerDto updateCustomerById(@RequestParam(required = true) Long id, @RequestParam(required = true) CustomerDto customer){
        return customerService.updateCustomerById(id, customer);
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

    @PutMapping("/restoration")
    public void restore(@RequestParam Long id) {
        customerService.restoreCustomerById(id);
    }

    @GetMapping("/quantity")
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

    @PutMapping("/product-id")
    public Product addProductByCustomerId(@RequestParam Long id, @RequestParam Long productId) {
        return customerService.addProductByCustomerId(id, productId);
    }

    @DeleteMapping("/product-id")
    public void deleteProductByCustomerId(@RequestParam Long id, @RequestParam Long productId){
        customerService.deleteProductByCustomerId(id, productId);
    }

    @DeleteMapping("/all-products-id")
    public void removeAllProductsByCustomerId(@RequestParam Long id){
        customerService.removeAllProductsByCustomerId(id);
    }

}
