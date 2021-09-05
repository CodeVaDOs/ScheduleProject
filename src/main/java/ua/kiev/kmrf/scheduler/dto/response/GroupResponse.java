package ua.kiev.kmrf.scheduler.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class GroupResponse extends BaseEntity {
    private String name;
}
