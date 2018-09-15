package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.OnlineCourseRespository;
import org.projectschool.school.core.eis.bo.OnlineCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/online-course", produces = MediaType.APPLICATION_JSON_VALUE)
public class OnlineCourseController {

    @Autowired
    private OnlineCourseRespository onlineCourseRespository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnlineCourse> getOnlineCourses(){
        return onlineCourseRespository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOneOnlineCourse(@PathVariable("id") Long id){
        return onlineCourseRespository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveOnlineCourse(@RequestBody(required = true) OnlineCourse onlineCourse){
        return this.onlineCourseRespository.save(onlineCourse);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editOnlineCourse(@PathVariable("id") Long id, @RequestBody(required = true) OnlineCourse newOnlineCourse){
        return onlineCourseRespository.save(newOnlineCourse);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOnlineCourse(@PathVariable("id") Long id){
        onlineCourseRespository.delete(id);
    }

    /* Format base JSON
     * {
          "courseId": 1,
          "title": "Java SE",
          "credits": 35,
          "department": 1,
          "url": "www.coursera.com/java-se"
        }
     **/

}
