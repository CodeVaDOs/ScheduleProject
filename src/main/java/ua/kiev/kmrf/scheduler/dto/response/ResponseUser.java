package ua.kiev.kmrf.scheduler.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.kiev.kmrf.scheduler.entity.Group;
import ua.kiev.kmrf.scheduler.entity.user.Role;
import ua.kiev.kmrf.scheduler.entity.user.User;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseUser extends BaseEntity  {
    private Role role;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String group;

    public ResponseUser(User u) {
        super(u);
        this.role = u.getRole();
        this.email = u.getEmail();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.birthday = u.getBirthday();
        this.group = u.getGroup().getName();
    }
}
