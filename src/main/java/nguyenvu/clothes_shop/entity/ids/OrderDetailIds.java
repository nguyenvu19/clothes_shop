package nguyenvu.clothes_shop.entity.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailIds implements Serializable {
    @Column(name = "product_id")
    private int productId;

    @Column(name = "order_id")
    private int orderId;
}