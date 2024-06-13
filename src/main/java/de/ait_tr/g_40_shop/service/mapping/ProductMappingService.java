package de.ait_tr.g_40_shop.service.mapping;

import de.ait_tr.g_40_shop.domain.dto.ProductDto;
import de.ait_tr.g_40_shop.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

//@Service - this only works with classes, not interfaces
@Mapper(componentModel = "spring")
public interface ProductMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    Product mapDtoToEntity(ProductDto dto);
    ProductDto mapProductToDto(Product product);

    //Manual Version
    /*
    //Entering backend - no id should be accepted
    public Product mapDtoToEntity(ProductDto dto){
        Product entity = new Product();
        //to prevent accepting wrong id from the client
        //entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        //as per the task limitations
        entity.setActive(true);
        return entity;
    }

    //exiting backend - taking id with us
    public ProductDto mapProductToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setTitle(product.getTitle());
        return dto;
    }

     */
}
