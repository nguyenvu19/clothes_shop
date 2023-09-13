package nguyenvu.clothes_shop.service;

import nguyenvu.clothes_shop.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategory();
}
