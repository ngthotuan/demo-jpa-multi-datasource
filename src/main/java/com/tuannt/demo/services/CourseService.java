package com.tuannt.demo.services;

import com.tuannt.demo.dtos.CreateCourseReqDto;
import com.tuannt.demo.dtos.GetCourseResDto;

/**
 * Created by tuannt7 on 23/09/2025
 */

public interface CourseService {
    void createCourse(CreateCourseReqDto reqDto);
    GetCourseResDto getCourse(Long courseId);
    void releaseCourse(Long courseId);
}
