package com.hyj.demo.service;

import com.hyj.demo.dto.Student;

public interface StudentService {
    /**
     * 添加学生
     */
     String add(Student student);

    /**
     * 修改学生
     */
     String update(Student student);

    /**
     * 删除学生
     */
     String delete(Long id);

    /**
     * 添加学生
     */
    Student select (Long id);
}
