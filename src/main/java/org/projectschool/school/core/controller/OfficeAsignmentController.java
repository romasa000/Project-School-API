package org.projectschool.school.core.controller;


import org.projectschool.school.core.bs.dao.OfficeAssignmentRepository;
import org.projectschool.school.core.eis.bo.OfficeAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/office-assignment", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeAsignmentController {

    @Autowired
    private OfficeAssignmentRepository officeAssignmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OfficeAssignment> getOfficeAsignment(){
        return officeAssignmentRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOneOfficeAssignment(@PathVariable("id") Long id){
        return officeAssignmentRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object saveOfficeAssignment(@RequestBody(required = true) OfficeAssignment officeAssignment){
        return this.officeAssignmentRepository.save(officeAssignment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editOfficeAssignment(@PathVariable("id") Long id, @RequestBody(required = true) OfficeAssignment newOfficeAssignment){
        return officeAssignmentRepository.save(newOfficeAssignment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOfficeAssigment(@PathVariable("id") Long id){
        officeAssignmentRepository.delete(id);
    }

}
