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
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false,   updatable = false)
    private Person person;

/* Format Base Json
*
* {
     "courseInstructorId":{
     "courseId": 1,
     "personId": 1
        },
    "course":{
        "courseId": 1,
        "title": "Java SE",
        "credits": 35,
        "department": {
          "departmentId": 1,
          "name": "Informática",
          "budget": 214.45,
          "startDate": 1516924800000,
          "administrador": 4
        },
        "location": "Villa Nueva",
        "days": "Lunes, miercoles y viernes",
        "time": "12:30:00"
      },
    "person": {
        "personId": 1,
        "lastName": "Sánchez",
        "firstName": "José",
        "hireDate": 1514937600000,
        "enrollmentDate": 1515974400000,
        "officeAssignment": {
          "instructorId": 1,
          "location": "Villa Nueva",
          "timestamp": 1520232350000
        }
      }
    }
*
*
* * */

}
