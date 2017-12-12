package com.wontonapp.repository;

import com.wontonapp.model.AccountEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Integer> {
    @Query("select act from AccountEntity act where act.name=:qaccountname and act.password=:qpassword")
    AccountEntity findByAccountNameAndPassword(@Param("qaccountname") String accountName,@Param("qpassword") String password);

    @Query("select act from AccountEntity act where act.name=:qaccountname")
    AccountEntity findByAccountName(@Param("qaccountname") String accountName);

    @Query("select act from AccountEntity act where act.userid=:quserid")
    List<AccountEntity> findALLByUserid(@Param("quserid") int userid);
    @Modifying // 说明该方法是修改操作
    @Transactional // 说明该方法是事务性操作
    @Query("update AccountEntity act set act.name=:qname,act.password=:qpassword where act.id=:qid")
    void update(@Param("qname") String name, @Param("qpassword") String password, @Param("qid") Integer Id);
}

