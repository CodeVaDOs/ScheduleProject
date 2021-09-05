package ua.kiev.kmrf.scheduler.facade;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.kiev.kmrf.scheduler.dto.request.UserRequest;
import ua.kiev.kmrf.scheduler.dto.response.UserResponse;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.service.UserService;

@Component
public class UserFacade implements Facade<User, UserResponse, UserRequest> {
    private final ModelMapper mapper;
    private final UserService service;

    public UserFacade(UserService service, ModelMapper modelMapper) {
        this.service = service;
        this.mapper = modelMapper;
        this.mapper.typeMap(User.class, UserResponse.class).addMapping(User::getGroupName, UserResponse::setGroup);
    }

    @Override
    public UserResponse toDTOResponse(UserRequest userRequest) {
        return mapper.map(userRequest, UserResponse.class);
    }

    @Override
    public UserRequest toDTORequest(UserResponse userResponse) {
        return mapper.map(userResponse, UserRequest.class);
    }

    @Override
    public UserResponse fromEntity(User entity) {
        return mapper.map(entity, UserResponse.class);
    }

    @Override
    public User toEntity(UserRequest userRequest) {
        return mapper.map(userRequest, User.class);
    }

    public UserResponse getProfile(String email) {
        return fromEntity(
                service.getUserByEmail(email)
        );
    }
}
