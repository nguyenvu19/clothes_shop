package nguyenvu.clothes_shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "u_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    @JsonIgnore
    private Date date;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailEntity> orderDetails;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;
}