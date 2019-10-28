package org.wlxy.example.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.wlxy.example.model.User;

import java.util.List;

@Mapper
@Repository("userDao")
public interface UserDao {


   @Select("select * from account")
    List<User> getAllUser(User u);

   @Delete("delete from account where id = #{id}")
    int removeUserById(int id);

    @Insert("insert into account (id,userName)values(#{id},#{userName})")
    int addUser(User user);

    @Update("update account set name=#{name},where id=#{id}")
    int updateUser(User user);

    @Select("select * from account where id =#{id}")
    User getUserById(int id);
}
