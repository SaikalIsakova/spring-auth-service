package kg.megacom.springauthservice.controller;

import kg.megacom.springauthservice.models.request.AuthRequest;
import kg.megacom.springauthservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private AccountService service;

    @PostMapping("/sign/in")
    String auth(AuthRequest request){
    return service.auth(request);
    }
}
