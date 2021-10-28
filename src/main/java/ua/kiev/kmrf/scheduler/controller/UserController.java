package ua.kiev.kmrf.scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.kiev.kmrf.scheduler.dto.response.UserResponse;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.facade.UserFacade;
import ua.kiev.kmrf.scheduler.service.UserService;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

@RequestMapping("api/v1/users")
@Validated
@RestController
public class UserController {
    private final UserFacade userFacade;
    private final UserService userService;
    public UserController(UserFacade userFacade, UserService userService) {
        this.userFacade = userFacade;
        this.userService = userService;
    }

    @GetMapping("profile")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<UserResponse> getProfile(Principal principal) {
        return ResponseEntity.ok(userFacade.getProfile(principal.getName()));
    }

//    @GetMapping
//    public ResponseEntity<List<User>> getUsersByBirthdayBetween(@RequestParam String d1, @RequestParam String d2) throws ParseException {
//        return ResponseEntity.ok(userService.getUsersByBirthdayBetween(d1, d2));
//    }

    @GetMapping
    @PreAuthorize("hasAuthority('getTotal')")
    public ResponseEntity<List<UserResponse>> getUsers(@RequestParam Long groupId) {
        return ResponseEntity.ok(
                userFacade.getUsersByGroup(groupId)
        );
    }
}
