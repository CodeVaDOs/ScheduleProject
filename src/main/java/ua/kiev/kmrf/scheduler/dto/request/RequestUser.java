package ua.kiev.kmrf.scheduler.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.kiev.kmrf.scheduler.dto.request.groups.OnCreate;
import ua.kiev.kmrf.scheduler.dto.request.groups.OnUpdate;
import ua.kiev.kmrf.scheduler.entity.group.Group;
import ua.kiev.kmrf.scheduler.entity.user.Role;
import ua.kiev.kmrf.scheduler.entity.user.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RequestUser extends BaseEntity {
    @NotNull(groups = OnUpdate.class, message = "user id is required")
    private Long id;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "email is required")
    @Email(groups = {OnCreate.class, OnUpdate.class}, message = "not email")
    private String email;

    @NotBlank(groups = OnCreate.class, message = "password is require")
    @Size(groups = OnCreate.class, min = 4, message = "password is too short")
    private String password;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "first name is required")
    private String firstName;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "last name is required")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "group is required")
    private Group group;

    public User toEntity() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

        return User.builder()
                .password(bCryptPasswordEncoder.encode(password))
                .email(this.email)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .birthday(this.birthday)
                .group(this.group)
                .build();
    }

    public User update(User u){
        u.setEmail(this.email);
        u.setFirstName(this.firstName);
        u.setLastName(this.lastName);
        u.setGroup(this.group);
//        if (urlAvatar !=null) u.setUrlAvatar(urlAvatar);
        if (this.birthday != null) u.setBirthday(this.birthday);
//        if (this.language != null) u.setLanguage(this.language);
//        if (this.currency != null) u.setCurrency(this.currency);
        return u;
    }
}