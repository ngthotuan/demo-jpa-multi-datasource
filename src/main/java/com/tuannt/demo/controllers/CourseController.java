package com.tuannt.demo.controllers;

import com.tuannt.demo.dtos.CreateCourseReqDto;
import com.tuannt.demo.dtos.GetCourseResDto;
import com.tuannt.demo.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuannt7 on 23/09/2025
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public void createCourse(@RequestBody CreateCourseReqDto reqDto) {
        courseService.createCourse(reqDto);
    }

    @GetMapping("/{id}")
    public GetCourseResDto getCourseById(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/{id}/release")
    public void releaseCourse(@PathVariable Long id) {
        courseService.releaseCourse(id);
    }

}
