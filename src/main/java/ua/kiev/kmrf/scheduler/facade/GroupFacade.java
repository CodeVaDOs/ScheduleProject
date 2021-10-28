package ua.kiev.kmrf.scheduler.facade;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.kiev.kmrf.scheduler.dto.request.GroupRequest;
import ua.kiev.kmrf.scheduler.dto.response.GroupResponse;
import ua.kiev.kmrf.scheduler.entity.group.Group;

import javax.annotation.PostConstruct;


@Component
public class GroupFacade extends GeneralFacade<Group, GroupRequest, GroupResponse> {
    @PostConstruct
    public void init() {
        super.getMm().typeMap(Group.class, GroupResponse.class).addMapping(Group::getCountStudents, GroupResponse::setCountStudents);
    }
}
