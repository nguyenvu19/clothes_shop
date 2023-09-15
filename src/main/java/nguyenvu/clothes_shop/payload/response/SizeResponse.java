package nguyenvu.clothes_shop.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeResponse {
    private int id;
    private String name;
}
