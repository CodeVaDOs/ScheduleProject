package ua.kiev.kmrf.scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kiev.kmrf.scheduler.dto.response.UserResponse;
import ua.kiev.kmrf.scheduler.facade.UserFacade;

import java.security.Principal;

@RequestMapping("api/v1/users")
@Validated
@RestController
public class UserController {
    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("profile")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<UserResponse> getProfile(Principal principal) {
        return ResponseEntity.ok(userFacade.getProfile(principal.getName()));
    }
}
