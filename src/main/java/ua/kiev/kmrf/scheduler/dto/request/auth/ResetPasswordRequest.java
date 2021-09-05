package ua.kiev.kmrf.scheduler.dto.request.auth;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class ResetPasswordRequest {
    @Email(message = "not email")
    private String email;
}