package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.StudentGradeRepository;
import org.projectschool.school.core.eis.bo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
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
        return studentGradeRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveStudentGrade(@RequestBody(required = true) StudentGrade studentGrade){
        return this.studentGradeRepository.save(studentGrade);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editStudentGrade(@PathVariable("id") Long id, @RequestBody(required = true) StudentGrade newStudentGrade){
        return studentGradeRepository.save(newStudentGrade);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentGrade(@PathVariable("id") Long id){
        studentGradeRepository.delete(id);
    }
}
