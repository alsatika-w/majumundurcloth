package enigacamp.Maju_Mundur_Cloth.repository;

import enigacamp.Maju_Mundur_Cloth.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
