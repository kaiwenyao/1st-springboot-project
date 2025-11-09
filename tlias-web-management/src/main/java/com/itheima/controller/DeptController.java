package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
//        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        log.info("查询全部部门数据");
        return Result.success(deptList);
    }
    @Log
    @DeleteMapping
    public Result delete(Integer id) {
        deptService.deleteById(id);
//        System.out.println("根据ID删除部门：" + id);
        log.info("根据ID删除部门: {}", id);
        return Result.success();
    }
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
//        System.out.println("新增部门：" + dept);
        log.info("新增部门: {}", dept);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
//        System.out.println("根据ID查询部门：" + id);
        log.info("根据ID查询部门数据：{}", id);
        return Result.success(dept);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
//        System.out.println("修改部门：" + dept);
        log.info("修改部门数据：{}", dept);
        return Result.success();
    }


}
