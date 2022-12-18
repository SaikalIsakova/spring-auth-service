package kg.megacom.springauthservice.controller;

import io.swagger.annotations.Api;
import kg.megacom.springauthservice.models.Account;
import kg.megacom.springauthservice.models.dto.AccountDto;
import kg.megacom.springauthservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags="Аккаунт")
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    AccountService service;
    @PostMapping()
    AccountDto save(@RequestBody AccountDto account){
       return service.save(account);
    }

    @GetMapping("/findById")
    AccountDto findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    List<AccountDto> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    AccountDto delete(@RequestParam Long id){
        return service.delete(id);
    }
}
