package ua.kiev.kmrf.scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.kmrf.scheduler.dto.response.ResponseUser;
import ua.kiev.kmrf.scheduler.service.UserService;

import java.security.Principal;

@RequestMapping("api/v1/users")
@Validated
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("profile")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<ResponseUser> getProfile(Principal principal) {
        return ResponseEntity.ok(userService.getProfile(principal.getName()));
    }
}
