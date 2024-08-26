package com.example.backend_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend_demo.entity.Usr;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsrTable extends BaseMapper<Usr> {
    @Select("SELECT * from usr")
    List<Usr> findAll();

    @Select("SELECT * from usr WHERE id = #{id}")
    Usr findById(int id);

    @Insert("INSERT INTO usr(id, name, password) VALUES(#{id}, #{name}, #{password})")
    void add(Usr usr);

    @Delete("DELETE FROM usr WHERE id = #{id}")
    void delete(int id);

    @Update("UPDATE usr SET name=#{name}, password=#{password} WHERE id = #{id}")
    void update(Usr usr);
}
