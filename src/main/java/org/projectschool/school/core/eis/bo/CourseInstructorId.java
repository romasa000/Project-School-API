package org.projectschool.school.core.eis.bo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Data
@Embeddable
public class CourseInstructorId implements Serializable {

    @Column(name = "course_id",nullable = false,insertable = false,updatable = false)
    private Long courseId;

    @Column(name = "person_id",nullable = false,insertable = false,updatable = false)
    private Long personId;
}
