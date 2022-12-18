package kg.megacom.springauthservice.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestDto {
    String name;
    String data;
    MultipartFile photo;
}
