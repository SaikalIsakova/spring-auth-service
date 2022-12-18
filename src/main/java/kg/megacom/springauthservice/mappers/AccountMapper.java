package kg.megacom.springauthservice.mappers;

import kg.megacom.springauthservice.models.Account;
import kg.megacom.springauthservice.models.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE= Mappers.getMapper(AccountMapper.class);

    Account toEntity(AccountDto accountDto);
    AccountDto toDto(Account account);
}
