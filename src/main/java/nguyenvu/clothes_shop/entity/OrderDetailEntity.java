package nguyenvu.clothes_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nguyenvu.clothes_shop.entity.ids.OrderDetailIds;

import javax.persistence.*;

@Entity(name = "order_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailIds ids;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false,updatable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false,updatable = false)
    private OrderEntity order;
}
