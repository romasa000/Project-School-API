package org.projectschool.school.core.bs.dao;

import org.projectschool.school.core.eis.bo.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
