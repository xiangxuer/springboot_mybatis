package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    //查询所有
    List<User> findAll();

    //根据 id 查询
    User findById(Integer userId);

    //保存数据
    int saveUser(User user);

    //更新数据
    int updateUser(User user);

    //删除数据
    int deleteUser(Integer userId);

    //根据名称模糊查询
    List<User> findByName(String username);

    //分页加模糊查询
    public Integer selectCount2(String keywords);
    public List<User> selectForPage4(Map<String, Object> map);
}
