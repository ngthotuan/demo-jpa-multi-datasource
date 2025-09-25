package com.tuannt.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by tuannt7 on 23/09/2025
 */

@Getter
@Setter
@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity {
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private CourseEntity course;
}
