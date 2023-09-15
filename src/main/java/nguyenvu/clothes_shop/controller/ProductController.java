package nguyenvu.clothes_shop.controller;

import nguyenvu.clothes_shop.payload.response.BaseResponse;
import nguyenvu.clothes_shop.payload.response.ProductResponse;
import nguyenvu.clothes_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    private ResponseEntity<?> getAllProduct(){
        List<ProductResponse> listProducts = productService.getALlProducts();
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(listProducts);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/category/${id}")
    private ResponseEntity<?> getProductByCategoryId(@PathVariable int idCategory){
        List<ProductResponse> listProducts = productService.getProductByCategoryId(idCategory);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(listProducts);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
