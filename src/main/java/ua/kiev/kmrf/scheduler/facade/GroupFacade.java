package ua.kiev.kmrf.scheduler.facade;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.kiev.kmrf.scheduler.dto.request.GroupRequest;
import ua.kiev.kmrf.scheduler.dto.response.GroupResponse;
import ua.kiev.kmrf.scheduler.entity.group.Group;
import ua.kiev.kmrf.scheduler.service.GroupService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupFacade implements Facade<Group, GroupResponse, GroupRequest> {
    private final ModelMapper mapper;

    private final GroupService service;

    public GroupFacade(GroupService service, ModelMapper modelMapper) {
        this.service = service;
        this.mapper = modelMapper;
    }

    @Override
    public GroupResponse toDTOResponse(GroupRequest groupRequest) {
        return mapper.map(groupRequest, GroupResponse.class);
    }

    @Override
    public GroupRequest toDTORequest(GroupResponse groupResponse) {
        return mapper.map(groupResponse, GroupRequest.class);
    }

    @Override
    public GroupResponse fromEntity(Group entity) {
        return mapper.map(entity, GroupResponse.class);
    }

    @Override
    public Group toEntity(GroupRequest groupRequest) {
        return mapper.map(groupRequest, Group.class);
    }

    public List<GroupResponse> getAll() {
        return service.getAllGroups()
                .stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    public GroupResponse createGroup(GroupRequest groupRequest) {
        return fromEntity(
                service.createGroup(
                        toEntity(groupRequest)
                )
        );
    }
}
