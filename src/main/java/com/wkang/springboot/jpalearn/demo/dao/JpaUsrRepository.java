package com.wkang.springboot.jpalearn.demo.dao;

import com.wkang.springboot.jpalearn.demo.pojo.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author wkang
 * @date 2019/2/13
 */
@Repository
public interface JpaUsrRepository extends JpaRepository<UserDO, Long> {

    /**
     * 传入用户名 返回sql查询出的用户列表
     *
     * @param name 用户名
     * @return 用户列表
     */
    @Query(nativeQuery = true, value = "select * from auth_user where name= :name1")
    List<UserDO> findSql(@Param("name1") String name);

    /**
     * 根据用户id修改用户名
     *
     * @param name 用户名
     * @param id   用户id
     * @return
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(nativeQuery = true, value = "update auth_user set name= :name where id= :id")
    int updateById(@Param("name") String name, @Param("id") Long id);
}
