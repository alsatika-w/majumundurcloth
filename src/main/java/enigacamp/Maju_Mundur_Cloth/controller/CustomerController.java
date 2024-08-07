package enigacamp.Maju_Mundur_Cloth.controller;

import enigacamp.Maju_Mundur_Cloth.entity.Customer;
import enigacamp.Maju_Mundur_Cloth.entity.Product;
import enigacamp.Maju_Mundur_Cloth.entity.Transaction;
import enigacamp.Maju_Mundur_Cloth.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return customerService.getAllProducts();
    }

    @PostMapping("/transaction")
    public void processTransaction(@RequestBody Transaction transaction) {
        customerService.processTransaction(transaction);
    }

    @GetMapping("/{productId}/customer")
    public List<Customer> getCustomersByProduct(@PathVariable Long productId) {
        return customerService.getCustomersByProduct(productId);
    }
}
