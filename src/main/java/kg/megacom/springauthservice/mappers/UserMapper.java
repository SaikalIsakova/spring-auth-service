package kg.megacom.springauthservice.mappers;

import kg.megacom.springauthservice.models.Users;
import kg.megacom.springauthservice.models.dto.UserDto;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDto toDto(Users users);
    Users toEntity(UserDto userDto);
}
