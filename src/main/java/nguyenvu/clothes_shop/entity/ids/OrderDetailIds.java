package nguyenvu.clothes_shop.entity.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
