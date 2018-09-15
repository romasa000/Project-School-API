package org.projectschool.school.core.controller;


import org.projectschool.school.core.bs.dao.DepartmentRepository;
import org.projectschool.school.core.eis.bo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/department", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOneDepartment(@PathVariable("id") Long id){
        return departmentRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveDepartment(@RequestBody(required = true) Department department){
        return this.departmentRepository.save(department);
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PATCH)
    public Object editDepartment(@PathVariable("id") Long id, @RequestBody(required = true) Department newDepartment){
        return departmentRepository.save(newDepartment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDepartment(@PathVariable("id") Long id){
        departmentRepository.delete(id);
    }

    /* -Format base Json
    *   {
          "departmentId": 1,
          "name": "Informática",
          "budget": 214.45,
          "startDate": 1516924800000,
          "administrador": 4
        }
    * */
}
