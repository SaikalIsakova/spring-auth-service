package kg.megacom.springauthservice.models.dto;

import kg.megacom.springauthservice.models.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserDto {
    Long id;
    String name;
    Date addDate;
    Date updateDate;
    boolean active;
    AccountDto account;
}
