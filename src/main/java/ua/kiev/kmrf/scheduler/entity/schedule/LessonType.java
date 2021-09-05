package ua.kiev.kmrf.scheduler.entity.schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;
import ua.kiev.kmrf.scheduler.entity.schedule.Schedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lesson_types")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonType extends BaseEntity {
    @Column(name = "type")
    private String lessonType;

    @JsonIgnore
    @OneToMany(mappedBy = "lessonType", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Schedule> pairSchedules = new ArrayList<>();
}
