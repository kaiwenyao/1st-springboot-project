package com.itheima.controller;

import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;
    @GetMapping("/page")
    public Result page(@RequestParam Integer page, @RequestParam Integer pageSize) {
        PageResult<OperateLog> pageResult = logService.page(page, pageSize);

        return Result.success(pageResult);
    }
}
