package com.huahua.dewu.service;

import com.huahua.dewu.model.User;
import com.huahua.dewu.model.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * service模块
 * 用于处理业务逻辑，会调用dao层类中的方法
 * 此处的方法全为interface
 */

public interface UserService {

    /**
     * 注册用户
     *
     * @param userName
     * @param pwd
     * @return
     */
    public Result<User> register(String userName, String pwd);

    /**
     * 执行登录逻辑，登录成功返回 User 对象
     *
     * @param userName
     * @param pwd
     * @return
     */
    public Result<User> login(String userName, String pwd);

    /**
     * 获取多个用户信息
     *
     * @param userIds  查询参数
     * @return
     */
    public List<User> queryUser(List<Long> userIds);

    /**
     * 判断是否登录
     *
     * @param request
     * @return
     */
    public Boolean checkLogin(HttpServletRequest request);
}
