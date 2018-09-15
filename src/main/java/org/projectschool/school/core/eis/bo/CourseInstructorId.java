package org.projectschool.school.core.eis.bo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Embeddable
public class CourseInstructorId implements Serializable {
    //@GeneratedValue
    @Column(name = "course_id",nullable = false,insertable = false,updatable = false)
    private Long courseId;
    //@GeneratedValue
    @Column(name = "person_id",nullable = false, updatable = false,insertable = false)
    private Long PersonId;
}
