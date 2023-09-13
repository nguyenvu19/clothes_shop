package nguyenvu.clothes_shop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RuntimeException extends java.lang.RuntimeException {
    private String message;
}
