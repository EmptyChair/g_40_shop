package de.ait_tr.g_40_shop.service.mapping;

import de.ait_tr.g_40_shop.domain.dto.ProductDto;
import de.ait_tr.g_40_shop.domain.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-15T11:12:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ProductMappingServiceImpl implements ProductMappingService {

    @Override
    public Product mapDtoToEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setTitle( dto.getTitle() );
        product.setPrice( dto.getPrice() );

        product.setActive( true );

        return product;
    }

    @Override
    public ProductDto mapProductToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setTitle( product.getTitle() );
        productDto.setPrice( product.getPrice() );

        return productDto;
    }
}
