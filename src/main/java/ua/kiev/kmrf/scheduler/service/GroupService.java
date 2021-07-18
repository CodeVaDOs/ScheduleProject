package ua.kiev.kmrf.scheduler.service;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.entity.Group;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
