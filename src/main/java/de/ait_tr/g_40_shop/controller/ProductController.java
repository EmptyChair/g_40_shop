package de.ait_tr.g_40_shop.controller;

import de.ait_tr.g_40_shop.domain.dto.ProductDto;
import de.ait_tr.g_40_shop.domain.entity.Product;
import de.ait_tr.g_40_shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
//note for postman-requests
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    //CRUD - Create (Post), Read (Get), Update (Put), Delete (Delete-requests in Postman)

    //@PostMapping("/example")
    //endpoint POST - localhost:8080/products/example
    //make sure requests with the same mapping have multiple endpoints!!!

    @PostMapping
    //@Request body to make sure JSON is transformed into object
    public ProductDto save (@RequestBody ProductDto product) {
        //problem - turning product back into JSON
        //solution: Spring will automatically turn Product product into JSON request using Jackson
        return service.save(product);
    }

    @GetMapping
    public List<ProductDto> getProduct(@RequestParam(required = false) Long id) {
        if (id == null) {
            return service.getAllActiveProducts();
        }  else {
            //if product doesn't exist
            ProductDto product = service.getById(id);
            return product == null ? null : List.of(service.getById(id));
        }
    }

    @PutMapping
    public ProductDto updateProduct(@RequestParam ProductDto product) {
        return service.update(product);
    }

    @DeleteMapping
    public void delete(@RequestParam(required = false) Long id,
                       @RequestParam(required = false) String title) {
        if (id != null) {
            service.deleteById(id);
        } else if (title != null) {
            service.deleteByTitle(title);
        }
    }

    /*
    //no longer needed since we united two methods due to limitations on mapping/endpoint combinations
    @DeleteMapping
    public void delete(@RequestParam String title){
        service.deleteByTitle(title);
    }

     */

    @PutMapping("/restore")
    public void restore(@RequestParam Long id) {
        service.restoreById(id);
    }
    @GetMapping("/quantity")
    public long getQuantity() {
        return service.getActiveProductsQuantity();
    }

    @GetMapping("/total-price")
    public BigDecimal getTotalPrice() {
        return service.getActiveProductsTotalPrice();
    }

    @GetMapping("/average-price")
    public BigDecimal getAveragePrice() {
        return service.getActiveProductsTotalPrice();
    }






    /*
    @GetMapping("/test")
    public void test(){
        System.out.println("tested Product controller!");
    }

     */

    /*
    // GEt products - get - localhost:8080/products/3/gjffgjgh instead of  ?id=3
    @GetMapping("/{id]") //meaning first after 8080/products
    public void getById(@Pathvariable Long id){
        System.out.println("tested Product controller!");
    }

     */


}
