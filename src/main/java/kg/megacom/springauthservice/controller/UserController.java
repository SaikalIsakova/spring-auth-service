package kg.megacom.springauthservice.controller;

import io.swagger.annotations.Api;
import kg.megacom.springauthservice.models.Account;
import kg.megacom.springauthservice.models.Users;
import kg.megacom.springauthservice.models.dto.UserDto;
import kg.megacom.springauthservice.service.AccountService;
import kg.megacom.springauthservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags="Пользователь")
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UsersService service;
    @PostMapping()
    UserDto save(@RequestBody UserDto user){
        return service.save(user);
    }

    @GetMapping("/findById")
    UserDto findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    List<UserDto> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    UserDto delete(@RequestParam Long id){
        return service.delete(id);
    }
}
