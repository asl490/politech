package com.store.politech.person.service;

import com.store.politech.person.util.PersonDTO;
import com.store.politech.shared.BaseService;

public interface PersonService
        extends BaseService<PersonDTO.Create, PersonDTO.Update, PersonDTO, PersonDTO.Filters> {
}