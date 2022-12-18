package kg.megacom.springauthservice.dao;

import kg.megacom.springauthservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<Users,Long>{
}
