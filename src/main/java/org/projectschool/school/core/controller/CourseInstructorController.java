package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.CourseInstructorRepository;
import org.projectschool.school.core.eis.bo.CourseInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/course-instructor", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseInstructorController {

    @Autowired
    private CourseInstructorRepository courseInstructorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CourseInstructor> getCourseInstructors(){
        return courseInstructorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveCourseInstructor(@RequestBody(required = true) CourseInstructor courseInstructor){
        return this.courseInstructorRepository.save(courseInstructor);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public Object editCourseInstructor(@RequestBody(required = true) CourseInstructor newCourseInstructor){
        return courseInstructorRepository.save(newCourseInstructor);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteCourseInstructor(@RequestBody(required = true) CourseInstructor courseInstructor){
        courseInstructorRepository.delete(courseInstructor);
    }

    /* Format base JSON
    * {
        "courseInstructorId": {},
        "person": {
          "personId": 1,
          "lastName": "Sánchez",
          "firstName": "José",
          "hireName": 1514937600000,
          "enrollmentDate": 1515974400000,
          "officeAssignment": null
        },
        "course": {
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
          "url": "www.coursera.com/java-se"
        }
      }
    **/

}
