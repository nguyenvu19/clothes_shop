package nguyenvu.clothes_shop.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String name;
    private double price;
    private String description;
    private ImageResponse image;
    private SizeResponse size;
    private ColorResponse color;
    private CategoryResponse category;
}
