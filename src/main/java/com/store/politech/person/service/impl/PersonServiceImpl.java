package com.store.politech.person.service.impl;

import org.springframework.stereotype.Service;

import com.store.politech.person.entity.Person;
import com.store.politech.person.repository.PersonRepository;
import com.store.politech.person.service.PersonService;
import com.store.politech.person.util.PersonDTO;
import com.store.politech.person.util.PersonDTO.Create;
import com.store.politech.person.util.PersonDTO.Filters;
import com.store.politech.person.util.PersonDTO.Update;
import com.store.politech.person.util.PersonMapper;
import com.store.politech.shared.BaseServiceImpl;

@Service
public class PersonServiceImpl extends
        BaseServiceImpl<Person, Create, Update, PersonDTO, Filters>
        implements PersonService {

    public PersonServiceImpl(PersonRepository repository,
            PersonMapper mapper) {
        super(repository, mapper);

    }

}