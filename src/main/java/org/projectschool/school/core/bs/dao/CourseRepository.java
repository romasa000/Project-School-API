package org.projectschool.school.core.bs.dao;

import org.projectschool.school.core.eis.bo.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
