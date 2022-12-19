package kg.megacom.springauthservice.mappers;

import kg.megacom.springauthservice.models.Users;
import kg.megacom.springauthservice.models.dto.UserDto;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends  BaseMapper<Users,UserDto>{

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

}
