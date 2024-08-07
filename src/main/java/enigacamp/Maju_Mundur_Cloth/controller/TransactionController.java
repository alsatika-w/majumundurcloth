package enigacamp.Maju_Mundur_Cloth.controller;

import enigacamp.Maju_Mundur_Cloth.entity.Transaction;
import enigacamp.Maju_Mundur_Cloth.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/transaction")
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping
    public void processTransaction(@RequestBody Transaction transaction) {
        transactionService.processTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable String id) {
        return transactionService.getTransactionById(id);
    }
}
