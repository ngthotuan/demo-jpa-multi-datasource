package com.tuannt.demo.repositories;

import com.tuannt.demo.configs.PrdRepositoryMarker;
import com.tuannt.demo.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tuannt7 on 23/09/2025
 */
@PrdRepositoryMarker
public interface CoursePrdRepository extends JpaRepository<CourseEntity, Long> {
}
