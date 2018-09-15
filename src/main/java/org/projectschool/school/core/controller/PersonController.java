package org.projectschool.school.core.controller;

import org.projectschool.school.core.bs.dao.PersonRepository;
import org.projectschool.school.core.eis.bo.Person;
import org.springframework.beans.factory.annotation.Autowired;
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
        return personRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object savePerson(@RequestBody(required = true) Person person){
        return this.personRepository.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Object editPerson(@PathVariable("id") Long id, @RequestBody(required = true) Person newPerson){
        return personRepository.save(newPerson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") Long id){
        personRepository.delete(id);
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
