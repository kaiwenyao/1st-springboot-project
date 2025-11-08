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
    //该接口用于根据主键ID查询学员的信息
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable Integer id){
        Student student = studentService.getInfoById(id);
        return Result.success(student);
    }

    // 该接口用于修改学员的数据信息
    @PutMapping
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }
    // 该接口用于批量删除学员信息
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        studentService.deleteByIds(ids);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        studentService.vioById(id, score);
        return Result.success();
    }
}
