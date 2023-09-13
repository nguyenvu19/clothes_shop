package nguyenvu.clothes_shop.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {
    private int id;
    private String image1;
    private String image2;
    private String image3;
}
