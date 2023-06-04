package com.hyj.demo.controller;

import com.hyj.demo.dto.Student;
import com.hyj.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api("学生接口")
@Slf4j
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 添加学生
     */
    @PostMapping("/add")
    @ApiOperation("添加学生")
    public String addStudent(@RequestBody Student student){
        String s = studentService.add(student);
        return s;
    }

    /**
     * 修改学生信息
     */
    @PostMapping("/update")
    @ApiOperation("添加学生")
    public String updateStudent(@RequestBody Student student){
        String s = studentService.update(student);
        return s;
    }

    /**
     * 删除学生信息
     */
    @PostMapping("/delete")
    @ApiOperation("添加学生")
    public String deleteStudent(@RequestParam Long id){
        String s = studentService.delete(id);
        return s;
    }

    /**
     * 修改学生信息
     */
    @PostMapping("/select")
    @ApiOperation("添加学生")
    public Student selectStudent(@RequestParam Long id){
        return studentService.select(id);
    }


//    public static void main(String[] args) {
//        StringBuffer sb=new StringBuffer();
//        sb.append('a');
//        sb.append('a');
//
//    }
//    public enum Weekday{
//        MONDAY(1,"星期一");
//
//        private int week;
//        private String name;
//
//        Weekday(int week, String name) {
//            this.week = week;
//            this.name = name;
//        }
//    }
}
