package nguyenvu.clothes_shop.service;

import nguyenvu.clothes_shop.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProductByCategoryId(int idCategory);
    List<ProductResponse> getALlProducts();
}
