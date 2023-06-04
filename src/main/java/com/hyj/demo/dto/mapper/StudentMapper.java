package com.hyj.demo.dto.mapper;

import com.hyj.demo.dto.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface StudentMapper {
    /**
     * 添加学生
     */
    void add(@Param("student") Student student);

    /**
     * 修改学生
     */
    void update(@Param("student") Student student);

    /**
     * 修改学生
     */
    void delete(@Param("id") Long id);

    /**
     * 修改学生
     */
    Student select(@Param("id") Long id);
}
