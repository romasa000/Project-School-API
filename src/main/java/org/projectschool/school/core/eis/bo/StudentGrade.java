package org.projectschool.school.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "student_grade")
public class StudentGrade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;
    private int grade;
    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
