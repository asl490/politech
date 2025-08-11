package com.store.politech.person.repository;

import org.springframework.stereotype.Repository;

import com.store.politech.person.entity.Person;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface PersonRepository extends BaseJpaRepository<Person> {
}