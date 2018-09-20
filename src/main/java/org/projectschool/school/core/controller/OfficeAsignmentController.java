package org.projectschool.school.core.controller;


import org.projectschool.school.core.bs.dao.OfficeAssignmentRepository;
import org.projectschool.school.core.eis.bo.OfficeAssignment;
import org.projectschool.school.core.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/office-assignment", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeAsignmentController {

    @Autowired
    private OfficeAssignmentRepository officeAssignmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OfficeAssignment> getOfficeAsignment(
            @RequestParam(value = "pageable", required = false) boolean pageable,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ){
        if(pageable){
            return officeAssignmentRepository.findAll(new PageRequest(page, size));
        } else{
            return officeAssignmentRepository.findAll();
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOneOfficeAssignment(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(officeAssignmentRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OfficeAssignment en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "Operación realizada correctamente.", officeAssignmentRepository.findOne(id));

    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveOfficeAssignment(@RequestBody(required = true) OfficeAssignment officeAssignment){
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "OfficeAssignment registrado correctamente.", this.officeAssignmentRepository.save(officeAssignment));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editOfficeAssignment(@PathVariable("id") Long id, @RequestBody(required = true) OfficeAssignment newOfficeAssignment){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(officeAssignmentRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra OfficeAssignment en la DB.");
        }
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "OfficeAssignment editado correctamente.", officeAssignmentRepository.save(newOfficeAssignment));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteOfficeAssigment(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(officeAssignmentRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese OfficeAssignment en la DB.");
        }

        officeAssignmentRepository.delete(id);

        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "OfficeAssignment eliminado correctamente.");
    }

}
