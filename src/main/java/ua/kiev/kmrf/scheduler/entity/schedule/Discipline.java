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
@Table(name = "disciplines")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discipline extends BaseEntity {
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    private List<Schedule> pairSchedules = new ArrayList<>();
}
