package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
    // 该接口用于添加班级信息
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        clazzService.save(clazz);
        return Result.success();
    }

    // 该接口用于根据主键ID查询班级的信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Clazz clazz = clazzService.getInfoById(id);
        return Result.success(clazz);
    }
    // 该接口用于修改班级的数据信息
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }

    // 该接口用于删除班级信息
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }


}
