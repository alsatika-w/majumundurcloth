package enigacamp.Maju_Mundur_Cloth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;
    private String password;
    private int rewardPoint;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;
}
