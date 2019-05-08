package cn.asyysy.core.controller;


import cn.asyysy.core.model.User;
import cn.asyysy.core.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.logging.Logger;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangyaoyu
 * @since 2019-05-08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = Logger.getLogger("UserController");

    @Autowired
    UserService userService;

    @PostMapping("update")
    public Object update(@RequestBody User user){
        logger.info("user/update");
        if (null == user) {
            return 1;
        }
        if(StringUtils.isEmpty(user.getUserName())){
            return "用户名不可为空";
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return "用户名密码不可为空";
        }
        boolean result;
        // 最后操作时间
        user.setUpdateDate(new Date());
        if(null != user.getPkid()){
            EntityWrapper<User> updateWrapper = new EntityWrapper<>();
            updateWrapper.setEntity(new User());
            // 主键查询
            updateWrapper.where("pkid={0}",user.getPkid());
            result = userService.update(user, updateWrapper);
        }else {
            // 创建时间
            user.setCreateDate(new Date());
            result = userService.insert(user);
        }
        logger.info("用户注册与修改" + result);
        return 200;
    }

    @PostMapping("login")
    public Object login(HttpServletRequest request, HttpServletResponse response, @RequestBody User userIn){
        logger.info("user/login");
        HttpSession session = request.getSession();
        Object userObj = session.getAttribute("user");
        if (null != userObj) {
            return "用户已登录";
        }
        String userName = userIn.getUserName();
        String password = userIn.getPassword();
        if(StringUtils.isEmpty(userName)){
            return "用户名不可为空";
        }
        if(StringUtils.isEmpty(password)){
            return "用户名密码不可为空";
        }

        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("user_name={0}",userName);
        //entityWrapper.where("password={0}",password);
        User user = userService.selectOne(entityWrapper);
        if (user == null) {
            return "用户不存在";
        }
        if(!password.equals(user.getPassword())){
            return "用户密码错误";
        }
        session.setAttribute("user", user);
        return 200;
    }

    @RequestMapping("logout")
    public Object logout(HttpServletRequest request){
        logger.info("user/logout");
        HttpSession session = request.getSession();
        Object userObj = session.getAttribute("user");
        if(userObj == null){
            return "用户未登录";
        }
        session.removeAttribute("user");
        return 200;
    }
}

