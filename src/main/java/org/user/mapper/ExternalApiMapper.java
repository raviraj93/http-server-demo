package org.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.user.domain.ExternalApiDomain;
import org.user.response.ExternalApiResponse;

@Mapper(componentModel = "spring")
public interface ExternalApiMapper {
    ExternalApiMapper INSTANCE = Mappers.getMapper(ExternalApiMapper.class);

    @Mapping(source = "userId", target = "externalUserId")
    @Mapping(source = "id", target = "taskId")
    @Mapping(source = "title", target = "taskTitle")
    @Mapping(source = "completed", target = "isCompleted")
    ExternalApiDomain toDomain(ExternalApiResponse externalApiResponse);
}
