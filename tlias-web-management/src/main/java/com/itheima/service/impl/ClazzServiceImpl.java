package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> rows = clazzMapper.list(clazzQueryParam);
        LocalDate today = LocalDate.now();
        for (Clazz clazz : rows) {
            LocalDate begin = clazz.getBeginDate();
            LocalDate end = clazz.getEndDate();

            String status;
            if (today.isBefore(begin)) {
                status = "未开班";
            } else if (today.isAfter(end)) {
                status = "已结课";
            } else {
                status = "在读中";
            }
            clazz.setStatus(status);
        }
        Page<Clazz> p = (Page<Clazz>) rows;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getInfoById(Integer id) {
        Clazz clazz = clazzMapper.getInfoById(id);
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);

    }

    @Override
    public List<Clazz> getAllClazzs() {
        List<Clazz> clazzList = clazzMapper.getAllClazzs();
        return clazzList;
    }
}
