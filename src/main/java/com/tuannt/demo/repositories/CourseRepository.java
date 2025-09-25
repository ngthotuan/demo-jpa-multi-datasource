package com.tuannt.demo.repositories;

import com.tuannt.demo.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by tuannt7 on 23/09/2025
 */
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
