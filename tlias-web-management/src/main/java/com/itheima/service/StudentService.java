package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfoById(Integer id);

    void update(Student student);

    void deleteByIds(List<Integer> ids);

    void vioById(Integer id, Integer score);
}
