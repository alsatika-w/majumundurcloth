package enigacamp.Maju_Mundur_Cloth.repository;

import enigacamp.Maju_Mundur_Cloth.entity.Customer;
import enigacamp.Maju_Mundur_Cloth.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Query("SELECT DISTINCT t.customer FROM Transaction t JOIN t.transactionDetails td WHERE td.product.id = :productId")
    List<Customer> findCustomersByProductId(@Param("productId") Long productId);
}
