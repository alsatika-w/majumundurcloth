package enigacamp.Maju_Mundur_Cloth.service;

import enigacamp.Maju_Mundur_Cloth.entity.Customer;
import enigacamp.Maju_Mundur_Cloth.entity.Transaction;
import enigacamp.Maju_Mundur_Cloth.entity.TransactionDetail;
import enigacamp.Maju_Mundur_Cloth.repository.CustomerRepository;
import enigacamp.Maju_Mundur_Cloth.repository.ProductRepository;
import enigacamp.Maju_Mundur_Cloth.repository.TransactionDetailRepository;
import enigacamp.Maju_Mundur_Cloth.repository.TransactionRepository;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@RequiredArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;

    private TransactionDetailRepository transactionDetailRepository;

    private ProductRepository productRepository;

    private CustomerRepository customerRepository;

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

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).orElse(null);
    }
}
