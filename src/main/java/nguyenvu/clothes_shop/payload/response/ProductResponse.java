package nguyenvu.clothes_shop.payload.response;

import lombok.Data;

@Data
public class ProductResponse {
    private int id;
    private String name;
    private double price;
    private ImageResponse image;
}
