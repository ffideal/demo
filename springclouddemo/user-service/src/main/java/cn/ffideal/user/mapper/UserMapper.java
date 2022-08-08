package cn.ffideal.user.mapper;

import cn.ffideal.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}