package ua.kiev.kmrf.scheduler.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.kiev.kmrf.scheduler.entity.schedule.PairSchedule;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lessons")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PairSchedule> pairSchedules = new ArrayList<>();
}
