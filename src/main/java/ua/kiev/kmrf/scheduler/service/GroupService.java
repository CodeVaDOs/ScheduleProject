package ua.kiev.kmrf.scheduler.service;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.entity.group.Group;
import ua.kiev.kmrf.scheduler.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService extends GeneralService<Group> {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

}
