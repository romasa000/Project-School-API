package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.OnlineCourseRespository;
import org.projectschool.school.core.eis.bo.OnlineCourse;
import org.projectschool.school.core.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(onlineCourseRespository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OnlineCourse en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "Operación realizada correctamente.", onlineCourseRespository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveOnlineCourse(@RequestBody(required = true) OnlineCourse onlineCourse){
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "OnlineCourse registrado correctamente.", this.onlineCourseRespository.save(onlineCourse));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editOnlineCourse(@PathVariable("id") Long id, @RequestBody(required = true) OnlineCourse newOnlineCourse){

        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(onlineCourseRespository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OnlineCourse en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "OnlineCourse editado correctamente.", onlineCourseRespository.save(newOnlineCourse));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteOnlineCourse(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(onlineCourseRespository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OnlineCourse en la DB.");
        }

        onlineCourseRespository.delete(id);

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "OnlineCourse eliminado correctamente.");

    }

    /* Format base JSON
     * {
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
     **/

}
