package kg.megacom.springauthservice.service.impl;

import kg.megacom.springauthservice.dao.UserRep;
import kg.megacom.springauthservice.mappers.UserMapper;
import kg.megacom.springauthservice.models.Account;
import kg.megacom.springauthservice.models.Users;
import kg.megacom.springauthservice.models.dto.AccountDto;
import kg.megacom.springauthservice.models.dto.UserDto;
import kg.megacom.springauthservice.service.AccountService;
import kg.megacom.springauthservice.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {

    UserMapper mapper=UserMapper.INSTANCE;

    @Autowired
    private UserRep rep;
    @Autowired
    private AccountService accountService;
    @Override
    public UserDto save(UserDto users) {
        AccountDto account = new AccountDto();
        account.setLogin(users.getAccount().getLogin());
        account.setPassword(users.getAccount().getPassword());
        account=accountService.save(account);
        users.setAccount(account);
        if(users.getName().isEmpty()){
            throw new RuntimeException("Имя не может быть пустым");
        }

        return mapper.toDto(rep.save(mapper.toEntity(users)));

    }

    @Override
    public UserDto findById(Long id) {

        return mapper.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Пользователь не найден")));
    }

    @Override
    public List<UserDto> findAll() {

        return (List<UserDto>) mapper.toDto((Users) rep.findAll());
    }

    @Override
    public UserDto delete(Long id) {
        UserDto users=findById(id);
        users.setActive(false);
        return save(users);
    }
}
