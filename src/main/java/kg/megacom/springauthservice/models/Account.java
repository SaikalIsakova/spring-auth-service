package kg.megacom.springauthservice.models;

import kg.megacom.springauthservice.models.enums.AccountStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String password;
    Date addDate;
    Date updateDate;
    boolean active;
    int count;
    AccountStatus status;

    @PreUpdate
    protected void onUpdate(){
        updateDate=new Date();
    }

    @PrePersist
    protected void onCreate(){
        status=AccountStatus.ACTIVE;
        addDate=new Date();
        updateDate=new Date();
        active=true;
        count=0;
    }
}
