package ua.kiev.kmrf.scheduler.entity.schedule;

import lombok.*;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;
import ua.kiev.kmrf.scheduler.entity.group.Group;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pair_schedules")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Weekday weekday;

    @Enumerated(EnumType.STRING)
    private WeekParity parity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pair_id")
    private Pair pair;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson_type_id")
    private LessonType lessonType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "audience_id")
    private Audience audience;
}
