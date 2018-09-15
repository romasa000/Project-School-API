package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.OnsiteCourseRepository;
import org.projectschool.school.core.eis.bo.OnsiteCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/onsite-course", produces = MediaType.APPLICATION_JSON_VALUE)
public class OnsiteCourseController {

    @Autowired
    private OnsiteCourseRepository onsiteCourseRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnsiteCourse> getOnsiteCourses(){
        return onsiteCourseRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOneOnsiteCourse(@PathVariable("id") Long id){
        return onsiteCourseRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveOnsiteCourse(@RequestBody(required = true) OnsiteCourse onsiteCourse){
        return this.onsiteCourseRepository.save(onsiteCourse);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editOnsiteCourse(@PathVariable("id") Long id, @RequestBody(required = true) OnsiteCourse newOnsiteCourse){
        return onsiteCourseRepository.save(newOnsiteCourse);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOnsiteCourse(@PathVariable("id") Long id){
        onsiteCourseRepository.delete(id);
    }

    /* Format base JSON
    * {
        "courseId": 2,
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
        "days":"Lunes, miercoles y viernes",
        "time":"2018-09-15T18:30:00"
      }
    * */

}
