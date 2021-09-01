package ua.kiev.kmrf.scheduler.entity.schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "audiences")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audience extends BaseEntity {
    @Column(name = "audience_number")
    private String audienceNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "audience", fetch = FetchType.LAZY)
    private List<Schedule> pairSchedules = new ArrayList<>();
}
