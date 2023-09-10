package nguyenvu.clothes_shop.controller;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @GetMapping("")
    public ResponseEntity<?> blog(){
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String strKey  = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(strKey);
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}
