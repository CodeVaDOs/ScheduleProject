package ua.kiev.kmrf.scheduler.facade;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kiev.kmrf.scheduler.dto.request.UserRequest;
import ua.kiev.kmrf.scheduler.dto.response.GroupResponse;
import ua.kiev.kmrf.scheduler.dto.response.UserResponse;
import ua.kiev.kmrf.scheduler.entity.group.Group;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.service.ServiceInterface;
import ua.kiev.kmrf.scheduler.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserFacade extends GeneralFacade<User, UserRequest, UserResponse> {
    @Autowired
    private UserService service;

    @PostConstruct
    public void init() {
        super.getMm().typeMap(User.class, UserResponse.class).addMapping(src -> src.getGroup().getName(), UserResponse::setGroup);
    }

    @Override
    public UserResponse convertToDto(User entity) {
        super.getMm().getTypeMaps().forEach((m -> {
            System.out.println(m.getMappings());
        }));
        return super.getMm().map(entity, UserResponse.class);
    }

    public UserResponse getProfile(String email) {
        return convertToDto(
                service.getUserByEmail(email)
        );
    }

    public List<UserResponse> getUsersByGroup(Long id) {
        return service.getUsersByGroup(id).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
