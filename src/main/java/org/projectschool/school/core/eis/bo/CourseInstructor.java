package org.projectschool.school.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity

@Table(name = "course_instructor")
public class CourseInstructor implements Serializable {
    @EmbeddedId
    private CourseInstructorId courseInstructorId;
    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false,insertable = false,updatable = false)
    private Person person;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false,insertable = false,updatable = false)
    private Course course;

}
