package org.projectschool.school.core.bs.dao;

import org.projectschool.school.core.eis.bo.OnlineCourse;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OnlineCourseRespository extends PagingAndSortingRepository<OnlineCourse, Long> {
}
