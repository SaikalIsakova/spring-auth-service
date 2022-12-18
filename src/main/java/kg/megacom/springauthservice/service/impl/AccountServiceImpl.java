package kg.megacom.springauthservice.service.impl;

import kg.megacom.springauthservice.dao.AccountRep;
import kg.megacom.springauthservice.mappers.AccountMapper;
import kg.megacom.springauthservice.models.Account;
import kg.megacom.springauthservice.models.dto.AccountDto;
import kg.megacom.springauthservice.models.enums.AccountStatus;
import kg.megacom.springauthservice.models.request.AuthRequest;
import kg.megacom.springauthservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRep rep;

    AccountMapper mapper=AccountMapper.INSTANCE;
    @Override
    public AccountDto save(AccountDto account) {
        return mapper.toDto(rep.save(mapper.toEntity(account)));
    }

    @Override
    public AccountDto findById(Long id) {

        return mapper.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Аккаунт не найден")));
    }

    @Override
    public List<AccountDto> findAll() {

        return (List<AccountDto>) mapper.toDto((Account) rep.findAll());
    }

    @Override
    public AccountDto delete(Long id) {
        AccountDto account = findById(id);
        account.setActive(false);
        return save(account);
    }


    @Override
    public String auth(AuthRequest request) {
        AccountDto account= mapper.toDto(rep.findByLogin(request.getLogin()).orElseThrow(()->(new RuntimeException("Пользователь не найден"))));
        switch (account.getStatus()){
            case ACTIVE:
                break;
            case BLOCKED:
                if (checkDate(account.getUpdateDate())){
                    account.setCount(0);
                    account.setStatus(AccountStatus.ACTIVE);
                    break;
                }
                throw new RuntimeException("Ваш аккаунт заблокирован");
            case DELETED:

                throw new RuntimeException("Ваш аккаунт удален");
        }
        if (account.getPassword().equals(request.getPassword())){
            account.setCount(0);
            save(account);
            return "Success";
        }else {

            if (account.getCount()>=3){
                account.setStatus(AccountStatus.BLOCKED);
                save(account);
                throw new RuntimeException("Вы заблокированы.Повторите попытку через час");
            }
            account.setCount(account.getCount()+1);
            save(account);
            throw new RuntimeException("Вы ввели неверный пароль");
        }


    }

    private boolean checkDate(Date updateDate) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(updateDate);
        calendar.add(Calendar.HOUR,1);
        return new Date().after(calendar.getTime());
    }
}
