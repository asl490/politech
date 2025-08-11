package com.store.politech.person.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.politech.person.service.PersonService;
import com.store.politech.person.util.PersonDTO;
import com.store.politech.shared.BaseController;

@RestController
@RequestMapping("/person")
public class PersonController
        extends BaseController<PersonDTO.Create, PersonDTO.Update, PersonDTO, PersonDTO.Filters> {

    public PersonController(PersonService service) {
        super(service);
    }

}