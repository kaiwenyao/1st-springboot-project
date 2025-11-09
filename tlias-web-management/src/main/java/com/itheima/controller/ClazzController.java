package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    // 该接口用于分页查询班级信息
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
        /**
     * 添加班级信息
     * @param clazz 班级信息对象
     * @return 操作结果，成功时返回成功状态
     */
    // 该接口用于添加班级信息
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        clazzService.save(clazz);
        return Result.success();
    }


    /**
     * 根据主键ID查询班级信息
     * @param id 班级主键ID
     * @return 班级信息查询结果
     */
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

    // 该接口用于查询所有班级信息
    @GetMapping("/list")
    public Result getAllClazzs() {
        List<Clazz> clazzList = clazzService.getAllClazzs();
        return Result.success(clazzList);
    }

}
