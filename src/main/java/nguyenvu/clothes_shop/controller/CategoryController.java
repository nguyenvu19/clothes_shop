package nguyenvu.clothes_shop.controller;

import nguyenvu.clothes_shop.payload.response.BaseResponse;
import nguyenvu.clothes_shop.service.CategoryService;
import nguyenvu.clothes_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    private ResponseEntity<?> getAllCategories(){
        BaseResponse response = new BaseResponse();
        response.setData(categoryService.getAllCategory());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
