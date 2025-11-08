package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.ClazzService;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    // 该接口用于学员列表数据的条件分页查询
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }
    // 该接口用于添加学员信息
    @PostMapping
    public Result save(@RequestBody Student student) {
        studentService.save(student);
        return Result.success();
    }
}
