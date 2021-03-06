package ua.kiev.kmrf.scheduler.dto.request.auth;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class PasswordRequest {
    @Size(min = 4, message = "password is too short")
    private String password;
}