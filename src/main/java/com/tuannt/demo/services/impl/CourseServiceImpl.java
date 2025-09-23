package com.tuannt.demo.services.impl;

import com.tuannt.demo.dtos.CreateCourseReqDto;
import com.tuannt.demo.dtos.GetCourseResDto;
import com.tuannt.demo.dtos.StudentDto;
import com.tuannt.demo.entities.CourseEntity;
import com.tuannt.demo.entities.StudentEntity;
import com.tuannt.demo.repositories.CoursePrdRepository;
import com.tuannt.demo.repositories.CourseRepository;
import com.tuannt.demo.services.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by tuannt7 on 23/09/2025
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CoursePrdRepository coursePrdRepository;

    @Override
    public void createCourse(CreateCourseReqDto reqDto) {
        log.info("Creating course: {}", reqDto);
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(reqDto.getName());
        Set<StudentEntity> students = reqDto.getStudents().stream()
                .map(s -> {
                    StudentEntity student = new StudentEntity();
                    student.setName(s.getName());
                    student.setCourse(courseEntity);
                    return student;
                })
                .collect(Collectors.toSet());
        courseEntity.setStudents(students);
        courseRepository.save(courseEntity);
    }

    @Override
    public GetCourseResDto getCourse(Long courseId) {
        log.info("Getting course {}", courseId);
        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Set<StudentDto> studentDtos = course.getStudents().stream()
                .map(s -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(s.getId());
                    studentDto.setName(s.getName());
                    return studentDto;
                })
                .collect(Collectors.toSet());
        GetCourseResDto resDto = new GetCourseResDto();
        resDto.setId(course.getId());
        resDto.setName(course.getName());
        resDto.setStudents(studentDtos);
        return resDto;
    }

    @Override
    @Transactional
    public void releaseCourse(Long courseId) {
        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        CourseEntity prdCourse =  new CourseEntity();
        prdCourse.setName(course.getName());
        Set<StudentEntity> students = course.getStudents().stream()
                .map(s -> {
                    StudentEntity student = new StudentEntity();
                    student.setName(s.getName());
                    student.setCourse(prdCourse);
                    return student;
                })
                .collect(Collectors.toSet());
        prdCourse.setStudents(students);

        coursePrdRepository.save(prdCourse);
    }
}
