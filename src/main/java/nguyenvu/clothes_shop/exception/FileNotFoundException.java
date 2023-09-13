package nguyenvu.clothes_shop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileNotFoundException extends RuntimeException {
    private int status;
    private String message;
}
