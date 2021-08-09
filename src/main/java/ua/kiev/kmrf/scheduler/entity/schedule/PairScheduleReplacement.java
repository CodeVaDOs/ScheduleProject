package ua.kiev.kmrf.scheduler.entity.schedule;

import lombok.*;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;
import ua.kiev.kmrf.scheduler.entity.group.Group;
import ua.kiev.kmrf.scheduler.entity.lesson.Lesson;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pair_schedule_replacements")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PairScheduleReplacement extends BaseEntity {
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;
}
