package enigacamp.Maju_Mundur_Cloth.repository;

import enigacamp.Maju_Mundur_Cloth.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
