package org.projectschool.school.core.bs.dao;

import org.projectschool.school.core.eis.bo.StudentGrade;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentGradeRepository extends PagingAndSortingRepository<StudentGrade, Long> {
}
