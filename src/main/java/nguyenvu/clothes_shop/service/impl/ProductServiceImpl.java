package nguyenvu.clothes_shop.service.impl;

import nguyenvu.clothes_shop.entity.ProductEntity;
import nguyenvu.clothes_shop.payload.response.ImageResponse;
import nguyenvu.clothes_shop.payload.response.ProductResponse;
import nguyenvu.clothes_shop.repository.ProductRepository;
import nguyenvu.clothes_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductByCategoryId(int idCategory) {

        List<ProductEntity> listProducts = productRepository.findByCategoryId(idCategory);
        List<ProductResponse> productResponseList = new ArrayList<>();

        for (ProductEntity product : listProducts){
            ProductResponse productResponse = new ProductResponse();
            ImageResponse imageResponse = new ImageResponse();

            // Map value to product DAO
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());

            // Map value to image DAO
            imageResponse.setId(product.getImage().getId());
            imageResponse.setImage1(product.getImage().getImage1());
            imageResponse.setImage2(product.getImage().getImage2());
            imageResponse.setImage3(product.getImage().getImage3());

            // Set image entity to product DAO
            productResponse.setImage(imageResponse);

            // Add to list
            productResponseList.add(productResponse);

        }

        return productResponseList;
    }

    @Override
    public List<ProductResponse> getALlProducts() {
        List<ProductEntity> listProducts = productRepository.findAll();
        List<ProductResponse> listProductsResponse = new ArrayList<>();

        for (ProductEntity product : listProducts ){
            ProductResponse productResponse = new ProductResponse();
            ImageResponse imageResponse = new ImageResponse();

            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());

            if(product.getImage() != null){
                imageResponse.setId(product.getImage().getId());
                imageResponse.setImage1(product.getImage().getImage1());
                imageResponse.setImage2(product.getImage().getImage2());
                imageResponse.setImage3(product.getImage().getImage3());
            }

            productResponse.setImage(imageResponse);

            listProductsResponse.add(productResponse);
        }
        return listProductsResponse;
    }
}
