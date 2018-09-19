package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.OnsiteCourseRepository;
import org.projectschool.school.core.eis.bo.OnsiteCourse;
import org.projectschool.school.core.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(onsiteCourseRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OnsiteCourse en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "Operación realizada correctamente.", onsiteCourseRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveOnsiteCourse(@RequestBody(required = true) OnsiteCourse onsiteCourse){
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "OnsiteCourse registrado correctamente.", this.onsiteCourseRepository.save(onsiteCourse));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editOnsiteCourse(@PathVariable("id") Long id, @RequestBody(required = true) OnsiteCourse newOnsiteCourse){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(onsiteCourseRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OnsiteCourse en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "OnsiteCourse editado correctamente.", onsiteCourseRepository.save(newOnsiteCourse));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteOnsiteCourse(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(onsiteCourseRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OnlineCourse en la DB.");
        }

        onsiteCourseRepository.delete(id);

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "OnsiteCourse eliminado correctamente.");
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
