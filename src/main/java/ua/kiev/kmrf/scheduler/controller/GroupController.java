package ua.kiev.kmrf.scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.kiev.kmrf.scheduler.entity.Group;
import ua.kiev.kmrf.scheduler.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('getTotal')")
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }
}
