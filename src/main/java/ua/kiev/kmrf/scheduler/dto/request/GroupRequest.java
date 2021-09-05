package ua.kiev.kmrf.scheduler.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.kiev.kmrf.scheduler.dto.request.groups.OnCreate;
import ua.kiev.kmrf.scheduler.dto.request.groups.OnUpdate;
import ua.kiev.kmrf.scheduler.entity.group.Group;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class GroupRequest extends BaseEntity {

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Group name is required")
    private String name;

    public Group toEntity() {
        return Group.builder()
                .name(name)
                .build();
    }

    public Group update(Group g) {
        g.setName(name);
        return g;
    }
}
