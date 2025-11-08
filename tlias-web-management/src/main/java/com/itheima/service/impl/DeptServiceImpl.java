package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        int rows = deptMapper.deleteIfNoEmployees(id);
        if (rows == 0) {
            throw new IllegalStateException("该部门下存在员工，无法删除");
        }
    }
/*    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }*/

    @Override
    public void add(Dept dept) {
        // 补全基础属性：create time, update time
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 调用mapper借口
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        // 补全基础属性
        dept.setUpdateTime(LocalDateTime.now());
        // 调用mapper来更新
        deptMapper.update(dept);
    }


}
