package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student getInfoById(Integer id);

    void update(Student student);

    void deleteByIds(List<Integer> ids);

    void vioById(Integer id, Integer score);
    @MapKey("name")
    List<Map<String, Object>> getStudentCountData();

    List<Map<String, Object>> getStudentDegreeData();
}
