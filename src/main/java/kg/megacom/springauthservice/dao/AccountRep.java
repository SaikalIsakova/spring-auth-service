package kg.megacom.springauthservice.dao;

import kg.megacom.springauthservice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRep extends JpaRepository<Account,Long> {

    Optional<Account> findByLogin(String login);
}
