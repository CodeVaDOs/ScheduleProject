package ua.kiev.kmrf.scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.kiev.kmrf.scheduler.dto.request.GroupRequest;
import ua.kiev.kmrf.scheduler.dto.response.GroupResponse;
import ua.kiev.kmrf.scheduler.entity.group.Group;
import ua.kiev.kmrf.scheduler.facade.GroupFacade;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/groups")
@Validated
@RestController
public class GroupController {
    private final GroupFacade groupFacade;

    public GroupController(GroupFacade groupFacade) {
        this.groupFacade = groupFacade;
    }

    @PreAuthorize("hasAuthority('write')")
    @PostMapping
    public ResponseEntity<GroupResponse> createGroup(@RequestBody @Valid GroupRequest groupRequest) {
        return ResponseEntity.ok(groupFacade.save(
                groupFacade.convertToEntity(groupRequest)
        ));
    }

    @PreAuthorize("hasAuthority('read')")
    @GetMapping
    public ResponseEntity<List<GroupResponse>> getGroups() {
        return ResponseEntity.ok(groupFacade.findAll());
    }
}
