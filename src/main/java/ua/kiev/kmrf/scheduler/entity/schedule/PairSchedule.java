package ua.kiev.kmrf.scheduler.entity.schedule;

import lombok.*;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;
import ua.kiev.kmrf.scheduler.entity.Group;
import ua.kiev.kmrf.scheduler.entity.Lesson;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pair_schedules",
        uniqueConstraints = { @UniqueConstraint( columnNames = { "pair_order", "weekday" } ) })
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PairSchedule extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "pair_order")
    private Integer pairOrder;

    @Enumerated(EnumType.STRING)
    private Weekday weekday;
}