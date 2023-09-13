package nguyenvu.clothes_shop.repository;

import nguyenvu.clothes_shop.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
