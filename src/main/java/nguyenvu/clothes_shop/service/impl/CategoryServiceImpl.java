package nguyenvu.clothes_shop.service.impl;

import nguyenvu.clothes_shop.entity.CategoryEntity;
import nguyenvu.clothes_shop.payload.response.CategoryResponse;
import nguyenvu.clothes_shop.repository.CategoryRepository;
import nguyenvu.clothes_shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        List<CategoryEntity> listCategories = categoryRepository.findAll();

        for(CategoryEntity data : listCategories){
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(data.getId());
            categoryResponse.setName(data.getName());

            categoryResponseList.add(categoryResponse);
        }

        return categoryResponseList;
    }
}
