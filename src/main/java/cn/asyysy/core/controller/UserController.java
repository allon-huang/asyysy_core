package cn.asyysy.core.controller;


import cn.asyysy.core.common.JsonResult;
import cn.asyysy.core.model.User;
import cn.asyysy.core.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
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
@Api("swaggerDemoController相关的api")
@RequestMapping("/api/user")
public class UserController {
    Logger logger = Logger.getLogger("UserController");

    @Autowired
    UserService userService;

    @PostMapping("save")
    public Object save(@RequestBody User user){
        logger.info("user/update");
        if (null == user) {
            return new JsonResult(JsonResult.ERROR,"用户为空");
        }
        if(StringUtils.isEmpty(user.getUserName())){
            return new JsonResult(JsonResult.ERROR,"用户名不可为空");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return new JsonResult(JsonResult.ERROR,"用户名密码不可为空");
        }
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.setEntity(new User());
        entityWrapper.where("user_name={0}",user.getUserName());
        int sum = userService.selectCount(entityWrapper);
        if(sum != 0){
            return new JsonResult(JsonResult.ERROR,"用户名已注册数量:" + sum);
        }
        // 最后操作时间
        user.setUpdateDate(new Date());
        // 创建时间
        user.setCreateDate(new Date());
        boolean result = userService.insert(user);
        logger.info("用户注册" + result);
        return new JsonResult(JsonResult.SUCCESS,"用户注册",result);
    }

    @PutMapping("update")
    public Object update(@RequestBody User user){
        logger.info("user/update");
        if (null == user) {
            return new JsonResult(JsonResult.ERROR,"用户为空");
        }
        if(StringUtils.isEmpty(user.getUserName())){
            return new JsonResult(JsonResult.ERROR,"用户名不可为空");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return new JsonResult(JsonResult.ERROR,"用户名密码不可为空");
        }
        // 最后操作时间
        user.setUpdateDate(new Date());
        EntityWrapper<User> updateWrapper = new EntityWrapper<>();
        updateWrapper.setEntity(new User());
        // 主键查询
        updateWrapper.where("pkid={0}",user.getPkid());
        boolean result = userService.update(user, updateWrapper);
        logger.info("用户修改" + result);
        return new JsonResult(JsonResult.SUCCESS,"用户修改",result);
    }

    @DeleteMapping("delUser")
    public Object delUser(@RequestParam Long pkid){
        boolean result = userService.deleteById(pkid);
        return new JsonResult(JsonResult.SUCCESS,"删除用户",result);
    }

    @GetMapping("list")
    public Object list(){
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.setEntity(new User());
        List<User> list = userService.selectList(entityWrapper);
        return new JsonResult(JsonResult.SUCCESS,"用户列表",list);
    }

    @GetMapping("listPage")
    public Object listPage(@RequestBody User user){
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.setEntity(new User());
        Page<User> page = new Page<>();
        Page<User> pageResult = userService.selectPage(user, page);
        return new JsonResult(JsonResult.SUCCESS,"用户列表",pageResult);
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParam(name = "userIn", value = "用户实体", paramType = "path", required = true, dataType = "Integer")
    @PostMapping("login")
    public Object login(HttpServletRequest request, HttpServletResponse response, @RequestBody User userIn){
        logger.info("user/login");
        HttpSession session = request.getSession();
        Object userObj = session.getAttribute("user");
        if (null != userObj) {
            return new JsonResult(JsonResult.ERROR,"用户已登录");
        }
        String userName = userIn.getUserName();
        String password = userIn.getPassword();
        if(StringUtils.isEmpty(userName)){
            return  new JsonResult(JsonResult.ERROR,"用户名不可为空");
        }
        if(StringUtils.isEmpty(password)){
            return new JsonResult(JsonResult.ERROR,"用户名密码不可为空");
        }

        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("user_name={0}",userName);
        //entityWrapper.where("password={0}",password);
        User user = userService.selectOne(entityWrapper);
        if (user == null) {
           return new JsonResult(JsonResult.ERROR,"用户不存在");
        }
        if(!password.equals(user.getPassword())){

            return new JsonResult(JsonResult.ERROR,"用户密码错误");
        }
        session.setAttribute("user", user);
        return new JsonResult(JsonResult.SUCCESS,"登录成功",user);
    }

    @RequestMapping("logout")
    public Object logout(HttpServletRequest request){
        logger.info("user/logout");
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return new JsonResult(JsonResult.SUCCESS,"退出登录成功",null);
    }

    @GetMapping("getUser")
    public Object getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        return new JsonResult(JsonResult.SUCCESS,"获取用户信息成功",(User)session.getAttribute("user"));
    }
}

