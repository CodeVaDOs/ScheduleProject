package ua.kiev.kmrf.scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.kiev.kmrf.scheduler.dto.request.GroupRequest;
import ua.kiev.kmrf.scheduler.dto.request.groups.OnCreate;
import ua.kiev.kmrf.scheduler.dto.response.GroupResponse;
import ua.kiev.kmrf.scheduler.facade.GroupFacade;
import ua.kiev.kmrf.scheduler.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupService groupService;
    private final GroupFacade groupFacade;

    public GroupController(GroupService groupService, GroupFacade groupFacade) {
        this.groupService = groupService;
        this.groupFacade = groupFacade;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    @Validated(OnCreate.class)
    public ResponseEntity<GroupResponse> createGroup(@RequestBody GroupRequest groupRequest) {
        return ResponseEntity.ok(groupFacade.createGroup(groupRequest));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('getTotal')")
    public ResponseEntity<List<GroupResponse>> getAllGroups() {
        return ResponseEntity.ok(groupFacade.getAll());
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('write')")
    public ResponseEntity<Long> deleteGroup(@RequestParam Long id) {
        return ResponseEntity.ok(groupService.deleteGroup(id));
    }
}
