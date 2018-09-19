package org.projectschool.school.core.controller;


import com.fasterxml.jackson.databind.deser.Deserializers;
import org.projectschool.school.core.bs.dao.DepartmentRepository;
import org.projectschool.school.core.eis.bo.Department;
import org.projectschool.school.core.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(departmentRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese departamento en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "Operación realizada correctamente.", departmentRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveDepartment(@RequestBody(required = true) Department department){
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "Departamento registrado correctamente.", this.departmentRepository.save(department));
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.PATCH)
    public Object editDepartment(@PathVariable("id") Long id, @RequestBody(required = true) Department newDepartment){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(departmentRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese departamento en la DB.");
        }

        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "Departamento editado correctamente.", departmentRepository.save(newDepartment));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteDepartment(@PathVariable("id") Long id){

        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(departmentRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese departamento en la DB.");
        }

        departmentRepository.delete(id);

        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "Departamento eliminado correctamente.");
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
