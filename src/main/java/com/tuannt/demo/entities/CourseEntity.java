package com.tuannt.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by tuannt7 on 23/09/2025
 */

@Getter
@Setter
@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<StudentEntity> students;
}
