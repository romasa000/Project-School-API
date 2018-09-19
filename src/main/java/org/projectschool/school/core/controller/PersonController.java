package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.PersonRepository;
import org.projectschool.school.core.eis.bo.Person;
import org.projectschool.school.core.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Person> getPerson(){
        return personRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOnePerson(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(personRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese Person en la DB.");
        }

        return new BaseResponse(HttpStatus.FOUND.value(), HttpStatus.FOUND, "Operación realizada correctamente.", personRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object savePerson(@RequestBody(required = true) Person person){
        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "Person registrado correctamente.", this.personRepository.save(person));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editPerson(@PathVariable("id") Long id, @RequestBody(required = true) Person newPerson){

        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(personRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese Person en la DB.");
        }

        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "Person editado correctamente.", personRepository.save(newPerson));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deletePerson(@PathVariable("id") Long id){
        if(id == null || id <= 0){
            return new BaseResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT, "Debe mandar un id válido. ¡El id: " + id + " no se reconoce en la DB.!");
        }

        if(personRepository.findOne(id) == null){
            return new BaseResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,"No se encuentra ese person en la DB.");
        }

        personRepository.delete(id);

        return new BaseResponse(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED, "Person eliminado correctamente.");
    }

    /* Format base JSOn
     *
     * {
          "personId": 1,
          "lastName": "Sánchez",
          "firstName": "José",
          "hireName": 1514937600000,
          "enrollmentDate": 1515974400000,
          "officeAssignment": null,
          "studentGrades": null,
          "courseInstructors": null
          }
     *
     **/

}
