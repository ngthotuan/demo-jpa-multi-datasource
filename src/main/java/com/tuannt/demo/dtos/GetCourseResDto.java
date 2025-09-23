package com.tuannt.demo.dtos;

import lombok.Data;

import java.util.Set;

/**
 * Created by tuannt7 on 23/09/2025
 */

@Data
public class GetCourseResDto {
    private long id;
    private String name;
    private Set<StudentDto> students;
}
