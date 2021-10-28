package ua.kiev.kmrf.scheduler.entity.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;
import ua.kiev.kmrf.scheduler.entity.schedule.Schedule;
import ua.kiev.kmrf.scheduler.entity.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "groups")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group extends BaseEntity {
    private String name;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<User> students = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Schedule> pairSchedules = new ArrayList<>();


    public Integer getCountStudents() {
        return students.size();
    }
}
