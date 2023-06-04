package com.hyj.demo.service.serviceImpl;

import com.hyj.demo.dto.Student;
import com.hyj.demo.dto.mapper.StudentMapper;
import com.hyj.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String add(Student student) {
        studentMapper.add(student);
        return "添加成功";
    }

    @Override
    public String update(Student student) {
        studentMapper.update(student);
        return "修改成功";
    }

    @Override
    public String delete(Long id) {
        studentMapper.delete(id);
        return "删除成功";
    }

    @Override
    public Student select(Long id) {
        return studentMapper.select(id);
    }
}