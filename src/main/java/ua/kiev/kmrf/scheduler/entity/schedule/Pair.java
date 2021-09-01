package ua.kiev.kmrf.scheduler.entity.schedule;

import lombok.*;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pairs")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair extends BaseEntity {
    @Column(name = "pair_order")
    private Integer pairOrder;

    @Column(name = "start_pair")
    private LocalTime startPair;

    @Column(name = "end_pair")
    private LocalTime endPair;

    @OneToMany(mappedBy = "pair", fetch = FetchType.LAZY)
    private List<Schedule> pairSchedules = new ArrayList<>();
}
