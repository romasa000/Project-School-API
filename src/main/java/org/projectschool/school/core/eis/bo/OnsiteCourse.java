package org.projectschool.school.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "course_id")
public class OnsiteCourse extends Course {
    @Column(name = "location")
    private String location;
    @Column(name = "days")
    private String days;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
}
