package org.user.mapper;

import org.user.domain.UserDomain;
import org.user.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserDomain userDomain);
    UserDomain toDomain(UserEntity userEntity);
}

