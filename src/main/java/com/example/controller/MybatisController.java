package com.example.controller;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    //查询所有
 @RequestMapping(method = RequestMethod.GET,value = "/users")

    // 查询所有用户
    //@GetMapping("/user")
    public List<User> findAll(){
       List<User>users= userMapper.findAll();
       return users;


    }
    //根据Id查询一个用户
    @RequestMapping(method = RequestMethod.GET,value = "/users/{id}")

    // 根据id查询用户
   //GetMapping("/user/{id}")
    public User  testFindOne(@PathVariable int id) {
        //6.执行操作
        User user = userMapper.findById(id);
        return user;
    }
    //新增一个用户
   @RequestMapping(method = RequestMethod.POST,value = "/users")

    //@PutMapping("/user")
    public void testSave(@RequestBody User user ){

        userMapper.saveUser(user);

    }

    //更新用户信息
   @RequestMapping(method = RequestMethod.PUT,value = "/users/{userId}/{adress}")
    // 修改用户
   // @PutMapping
    public void testUpdateUser(@PathVariable int userId,@PathVariable String adress )throws Exception{
        //1.根据 id 查询
        User user = userMapper.findById(userId);
        //2.更新操作
        user.setAddress(adress);
        int res = userMapper.updateUser(user);
        System.out.println(res);
    }

   //删除用户信息
  @RequestMapping(method = RequestMethod.DELETE,value = "/users/{id}")
   // 删除用户
   //@DeleteMapping("/{id}")
   public void testDeleteUser(@PathVariable int id) throws Exception {
       //6.执行操作
       int res = userMapper.deleteUser(id);
       System.out.println(res);
   }
}
