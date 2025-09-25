package com.tuannt.demo.services;

import com.tuannt.demo.dtos.CreateCourseReqDto;
import com.tuannt.demo.dtos.GetCourseResDto;

import java.util.UUID;

/**
 * Created by tuannt7 on 23/09/2025
 */

public interface CourseService {
    void createCourse(CreateCourseReqDto reqDto);
    GetCourseResDto getCourse(UUID courseId);
    void releaseCourse(UUID courseId);
}
