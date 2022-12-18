package kg.megacom.springauthservice.models.dto;

import kg.megacom.springauthservice.models.enums.AccountStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AccountDto {
    Long id;
    String login;
    String password;
    Date addDate;
    Date updateDate;
    boolean active;
    int count;
    AccountStatus status;

}
