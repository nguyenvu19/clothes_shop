package nguyenvu.clothes_shop.repository;

import nguyenvu.clothes_shop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryId(int idCategory);

    List<ProductEntity> findAll();
}
