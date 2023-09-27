package com.huahua.dewu.api;

import com.huahua.dewu.model.User;
import com.huahua.dewu.service.UserService;
import com.huahua.dewu.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * api模块
 * 返回给前端渲染页面的接口，会调用service中的接口
 */

@Controller
public class UserAPI {

    @Autowired
    private UserService userService;

    /**
     * 注册
     */
    @PostMapping("/api/user/reg")
    @ResponseBody
    public Result<User> reg(@RequestBody User user) {
        return userService.register(user.getUserName(), user.getPwd());
    }

    /**
     * 登录
     */
    @PostMapping("/api/user/login")
    @ResponseBody
    public Result<User> login(@RequestBody User user, HttpServletRequest request) {
        Result<User> result = userService.login(user.getUserName(), user.getPwd());

        if (result.isSuccess()) {
            request.getSession().setAttribute("userId", result.getData().getId());
        }

        return result;
    }

    /**
     * 登出
     */
    @GetMapping("/api/user/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        Result result = new Result();
        request.getSession().removeAttribute("userId");

        result.setSuccess(true);
        return result;
    }

    /**
     * 判断是否登录
     */
    @GetMapping("/api/user/checklogin")
    @ResponseBody
    public Result<Boolean> checkLogin(HttpServletRequest request) {
        Result result = new Result();

        result.setSuccess(true);
        result.setData(userService.checkLogin(request));
        return result;
    }

}
