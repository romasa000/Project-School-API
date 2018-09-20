package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.CourseInstructorRepository;
import org.projectschool.school.core.eis.bo.Course;
import org.projectschool.school.core.eis.bo.CourseInstructor;
import org.projectschool.school.core.eis.bo.Person;
import org.projectschool.school.core.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/course-instructor", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseInstructorController {

    @Autowired
    private CourseInstructorRepository courseInstructorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CourseInstructor> getCourseInstructors(
        @RequestParam(value = "pageable", required = false) boolean pageable,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "size", required = false) Integer size
    ){
        if(pageable){
            return courseInstructorRepository.findAll(new PageRequest(page, size));
        } else{
            return courseInstructorRepository.findAll();
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveCourseInstructor(@RequestBody(required = true) CourseInstructor courseInstructor){
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "CourseInstructor registrado correctamente.", this.courseInstructorRepository.save(courseInstructor));
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
        "courseInstructorId": {
          "courseId": 1,
          "personId": 1
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
        },
        "person": {
          "personId": 1,
          "lastName": "Sánchez",
          "firstName": "José",
          "hireDate": null,
          "enrollmentDate": 1515974400000,
          "officeAssignment": {
            "instructorId": 1,
            "location": "Villa Nueva",
            "timestamp": 1525305600000
          }
        }
      }
    **/

}
