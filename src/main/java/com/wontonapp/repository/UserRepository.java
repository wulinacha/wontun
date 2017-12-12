package com.wontonapp.repository;

import com.wontonapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Modifying // 说明该方法是修改操作
    @Transactional // 说明该方法是事务性操作
    // @Param注解用于提取参数
    @Query("update UserEntity us set us.name=:qname,us.sex=:qsex,us.age=:qage,us.phone=:qphone where us.id=:qid")
    void update(@Param("qname") String name,@Param("qage") Integer age,@Param("qsex") Integer sex,@Param("qphone") String phone,
                        @Param("qid") Integer id);
}
