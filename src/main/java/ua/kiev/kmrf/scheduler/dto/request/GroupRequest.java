package ua.kiev.kmrf.scheduler.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ua.kiev.kmrf.scheduler.dto.request.groups.OnCreate;
import ua.kiev.kmrf.scheduler.dto.request.groups.OnUpdate;
import ua.kiev.kmrf.scheduler.entity.group.Group;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {
    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Group name is required")
    private String name;
}
