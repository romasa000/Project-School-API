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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object getOneCourseInstructor(@PathVariable("id") Long id){
        return courseInstructorRepository.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Object saveCourseInstructor(@RequestBody(required = true) CourseInstructor courseInstructor){
        return this.courseInstructorRepository.save(courseInstructor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editCourseInstructor(@PathVariable("id") Long id, @RequestBody(required = true) CourseInstructor courseInstructor){
        return courseInstructorRepository.save(courseInstructor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCourseInstructor(@PathVariable("id") Long id){
        courseInstructorRepository.delete(id);
    }

}
