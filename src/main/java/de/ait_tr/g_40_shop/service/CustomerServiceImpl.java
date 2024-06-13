package de.ait_tr.g_40_shop.service;

import de.ait_tr.g_40_shop.domain.dto.CustomerDto;
import de.ait_tr.g_40_shop.domain.entity.Customer;
import de.ait_tr.g_40_shop.domain.entity.Product;
import de.ait_tr.g_40_shop.repository.CustomerRepository;
import de.ait_tr.g_40_shop.service.interfaces.CustomerService;
import de.ait_tr.g_40_shop.service.mapping.CustomerMappingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMappingService customerMappingService;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMappingService customerMappingService) {
        this.customerRepository = customerRepository;
        this.customerMappingService = customerMappingService;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = customerMappingService.mapCustomerDtoToCustomer(customerDto);
        customerRepository.save(customer);
        return customerMappingService.mapCustomerToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        //only active customers
        return customerRepository.findAll()
                .stream()
                .filter(Customer::isActive)
                .map(customerMappingService::mapCustomerToCustomerDto)
                .toList();
    }

    @Override
    public CustomerDto getActiveCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null || !customer.isActive() ) {
            return null;
        }
        return customerMappingService.mapCustomerToCustomerDto(customer);
    }

    @Override
    public CustomerDto updateCustomerById(Long id, CustomerDto customer) {
        return null;
    }

    @Override
    public void deleteCustomerById(Long id) {

    }

    @Override
    public void deleteCustomerByName(String name) {

    }

    @Override
    public CustomerDto restoreCustomerById(Long id) {
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
