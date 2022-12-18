package kg.megacom.springauthservice.models;

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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Date addDate;
    Date updateDate;
    boolean active;
    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

    @PreUpdate
    protected void onUpdate(){
        updateDate=new Date();
    }

}
