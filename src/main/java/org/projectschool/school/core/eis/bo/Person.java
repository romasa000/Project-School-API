package org.projectschool.school.core.eis.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "hire_date")
    private Calendar hireDate;
    @Column(name = "enrollment_date")
    private Calendar enrollmentDate;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
    private OfficeAssignment officeAssignment;
    @JsonIgnore // AQUI
    @OneToMany(mappedBy = "person")
    private Set<StudentGrade> studentGrades;
    @JsonIgnore // AQUI
    @OneToMany(mappedBy = "person")
    private Set<CourseInstructor> courseInstructors;
}
