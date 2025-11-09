package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("select operate_log.id, operate_emp_id, operate_time, class_name, method_name, " +
            "method_params, return_value, cost_time, emp.name operateEmpName from operate_log" +
            " join emp on emp.id = operate_log.operate_emp_id")
    public List<OperateLog> list(Integer page, Integer pageSize);
}
