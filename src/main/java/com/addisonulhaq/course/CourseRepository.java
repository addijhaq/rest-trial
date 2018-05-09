package com.addisonulhaq.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    @RestResource(rel = "title-search", path = "byTitle")
    Page<Course> findByTitleContaining(@Param("title") String tite, Pageable page);
}