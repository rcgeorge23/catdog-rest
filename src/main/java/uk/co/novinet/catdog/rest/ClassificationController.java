package uk.co.novinet.catdog.rest;

import com.novinet.catdog.ClassificationService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController("/classify")
public class ClassificationController {

    private final static Logger LOGGER = Logger.getLogger(ClassificationController.class);

    @PostMapping
    public ResponseEntity<?> classify(@RequestParam(value="image") MultipartFile multipartFile) {
        LOGGER.info("Request received...");

        if (multipartFile.isEmpty()) {
            return new ResponseEntity("please select a file!", OK);
        }

        try {
            return new ResponseEntity(new ClassificationService().classify(multipartFile.getInputStream()), new HttpHeaders(), OK);
        } catch (IOException e) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
    }
}