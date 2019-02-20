package com.wkang.springboot.jpalearn.demo.controller;

import com.wkang.springboot.jpalearn.demo.dao.JpaUsrRepository;
import com.wkang.springboot.jpalearn.demo.pojo.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author wkang
 * @date 2019/2/13
 */
@Controller
@RequestMapping("/jpa")
@Api(value = "JpaController|JpaTest")
public class JpaController {

    @Autowired
    private JpaUsrRepository jpaUsrRepository = null;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户编号获取用户")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "Long")
    public UserDO getUser(@RequestParam Long id) {
        UserDO userDO = jpaUsrRepository.findById(id).get();
        return userDO;
    }

    @RequestMapping(value = "/getALot", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户姓名获取用户")
    @ApiImplicitParam(paramType = "query", name = "name", value = "用户名", required = true, dataType = "String")
    public List<UserDO> find(@RequestParam String name) {
        List<UserDO> res = jpaUsrRepository.findSql(name);
        return res;
    }

    @RequestMapping(value = "/updateName", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户编号更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "Long"),
    })
    public int update(@RequestParam String name, @RequestParam Long id) {
        return jpaUsrRepository.updateById(name, id);
    }

}
