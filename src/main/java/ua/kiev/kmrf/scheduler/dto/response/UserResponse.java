package ua.kiev.kmrf.scheduler.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.kiev.kmrf.scheduler.entity.group.Group;
import ua.kiev.kmrf.scheduler.entity.user.Role;
import ua.kiev.kmrf.scheduler.entity.user.User;

import java.util.Date;

//@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse  {
    private Long id;
    private Role role;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String group;
}
