package enigacamp.Maju_Mundur_Cloth.service;

import enigacamp.Maju_Mundur_Cloth.entity.Customer;
import enigacamp.Maju_Mundur_Cloth.entity.Product;
import enigacamp.Maju_Mundur_Cloth.entity.Transaction;
import enigacamp.Maju_Mundur_Cloth.entity.TransactionDetail;
import enigacamp.Maju_Mundur_Cloth.repository.CustomerRepository;
import enigacamp.Maju_Mundur_Cloth.repository.ProductRepository;
import enigacamp.Maju_Mundur_Cloth.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    private TransactionRepository transactionRepository;

    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void processTransaction(Transaction transaction) {
        // Calculate totalAmount from transactionDetails
        double totalAmount = transaction.getTransactionDetails().stream()
                .mapToDouble(TransactionDetail::getTotalAmount)
                .sum();
        transaction.setTotalAmount((long) totalAmount);

        // Save transaction
        transactionRepository.save(transaction);

        // Update customer reward points
        Customer customer = transaction.getCustomer();
        if (totalAmount > 100) {
            customer.setRewardPoint(customer.getRewardPoint() + 40);
        } else {
            customer.setRewardPoint(customer.getRewardPoint() + 20);
        }
        customerRepository.save(customer);
    }

    public List<Customer> getCustomersByProduct(Long productId) {
        return transactionRepository.findCustomersByProductId(productId);
    }

}
