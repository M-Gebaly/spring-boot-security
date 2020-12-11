package com.gebaly.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Mustafa Gebaly"),
            new Student(2, "Khaled Mohamed"),
            new Student(3, "Mahmoud Rashdan")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable(value = "studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student" + studentId + "doesn't exists"));
    }

    @GetMapping
    public void test(){
        System.out.println("Testing");
    }
}
