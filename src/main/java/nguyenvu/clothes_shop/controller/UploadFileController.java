package nguyenvu.clothes_shop.controller;

import nguyenvu.clothes_shop.exception.FileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/file")
public class UploadFileController {
    @Value("${path.root}")
    private String sPath;

    @GetMapping("/{filename}")
    public ResponseEntity<?> loadFile(@PathVariable String filename) {

        try {
            Path rootPath = Paths.get(sPath);
            Resource resource = new UrlResource(rootPath.resolve(filename).toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                                + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                throw new FileNotFoundException(404, "File not found");
            }

        } catch (Exception e) {
            throw new FileNotFoundException(404, "File not found");
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) {
        Path rootPath = Paths.get(sPath);

        try {
            if (Files.exists(rootPath)) {
                Files.createDirectories(rootPath);
            }
            //D:/CyberJava/image
            // resolve <=> /
            // file.getOriginalFilename(): Get file name and dinh dang
            String fileName = file.getOriginalFilename();
            Files.copy(file.getInputStream(), rootPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            throw new FileNotFoundException(500, "File not found");
        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
