package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.StudentGradeRepository;
import org.projectschool.school.core.eis.bo.StudentGrade;
import org.projectschool.school.core.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/student-grade", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentGradeController {

    @Autowired
    private StudentGradeRepository studentGradeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StudentGrade> getStudentGrades(){
        return studentGradeRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOneStudentGrade(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(studentGradeRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese StudentGrade en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "Operación realizada correctamente.", studentGradeRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveStudentGrade(@RequestBody(required = true) StudentGrade studentGrade){
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "StudentGrade registrado correctamente.", this.studentGradeRepository.save(studentGrade));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editStudentGrade(@PathVariable("id") Long id, @RequestBody(required = true) StudentGrade newStudentGrade){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(studentGradeRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese StudentGrade en la DB.");
        }

        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "StudentGrade editado correctamente.", studentGradeRepository.save(newStudentGrade));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteStudentGrade(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(studentGradeRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese StudentGrade en la DB.");
        }

        studentGradeRepository.delete(id);

        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "StudentGrade eliminado correctamente.");

    }
}
