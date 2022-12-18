package kg.megacom.springauthservice.service;

import kg.megacom.springauthservice.models.Account;
import kg.megacom.springauthservice.models.dto.AccountDto;
import kg.megacom.springauthservice.models.request.AuthRequest;

public interface AccountService extends BasicService<AccountDto>{
    String auth(AuthRequest request);
}
